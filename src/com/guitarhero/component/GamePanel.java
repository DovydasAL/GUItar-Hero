package com.guitarhero.component;

import com.guitarhero.entity.GraphicNote;
import com.guitarhero.entity.Note;
import com.guitarhero.entity.Song;
import com.guitarhero.listener.CloseSummaryListener;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel {

	public static final DecimalFormat percentFormat = new DecimalFormat("0.00");
	public static final int floor = 620;
    public static LinkedList<Note> allNotes = new LinkedList<>();
    public static LinkedList<Note> activeNotes = new LinkedList<>();
    public static LinkedList<GraphicNote> graphicNotes = new LinkedList<>();
    public static Integer score = 0;
    public static Integer multiplier = 1;
    public static Integer consecutiveNotes = 0;
    public static Integer highestConsecutiveNotes = 0;
    public static Integer notesHit = 0;
    public static Integer totalNotes = 0;
    public static Integer notesMissed = 0;
    public static JDialog summaryDialog =  new JDialog();

	
	private Image bg = new ImageIcon("resources/game_bg.png").getImage();
	private Image green = new ImageIcon("resources/green_note.png").getImage();
	private Image red = new ImageIcon("resources/red_note.png").getImage();
	private Image yellow = new ImageIcon("resources/yellow_note.png").getImage();
	private Image blue = new ImageIcon("resources/blue_note.png").getImage();
	private Image orange = new ImageIcon("resources/orange_note.png").getImage();
	private Image grey = new ImageIcon("resources/grey_note.png").getImage();
	private Image green_b = new ImageIcon("resources/green_button.png").getImage();
	private Image red_b = new ImageIcon("resources/red_button.png").getImage();
	private Image yellow_b = new ImageIcon("resources/yellow_button.png").getImage();
	private Image blue_b = new ImageIcon("resources/blue_button.png").getImage();
	private Image orange_b = new ImageIcon("resources/orange_button.png").getImage();
	
	
	public GamePanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(700,800));
        setBackground(new Color(11,11,15));
        setSize(new Dimension(700,800));
        //JLabel imageLabel = new JLabel(new ImageIcon("resources/game_bg.png"));
        //add(imageLabel);
	}

	public void prepareSong(Song song) {
	    Note firstNote = song.getFirstNote();
	    while (firstNote != null) {
	        allNotes.addLast(firstNote);
	        firstNote = firstNote.getNextNote();
        }
	    totalNotes = allNotes.size();
    }

    public void checkForNote(int millisecondsElapsed) {
		Note nextNote = null;
		if (!allNotes.isEmpty()) {
			nextNote = allNotes.getFirst();
		}
	    if (nextNote != null && nextNote.getTimestamp() < millisecondsElapsed) {
	        activeNotes.add(nextNote);
	        allNotes.remove(nextNote);
        }
	    updatePositions();
		repaint();
    }

    public static void displaySummary() {
		summaryDialog = new JDialog();
		JPanel panel = new JPanel();
		JLabel score = new JLabel("Score: " + GamePanel.score);
		JLabel consecutiveNotes = new JLabel("Highest Consecutive Notes: " + GamePanel.highestConsecutiveNotes);
		JLabel missed = new JLabel("Notes Missed: " + notesMissed);
		JLabel percentageHit = new JLabel("Percent of Notes Hit: " + percentFormat.format((double) GamePanel.notesHit / GamePanel.totalNotes));
		JButton closeButton = new JButton("Close");
		closeButton.addActionListener(new CloseSummaryListener());
		panel.add(score);
		panel.add(consecutiveNotes);
		panel.add(missed);
		panel.add(percentageHit);
		panel.add(closeButton);
		summaryDialog.add(panel);
		summaryDialog.pack();
		summaryDialog.setVisible(true);
	}
   
    public static void createGamePanel(JPanel game) {
    	game.setLayout(new BoxLayout(game, BoxLayout.Y_AXIS));
        game.setPreferredSize(new Dimension(700,800));
        game.setBackground(new Color(11,11,15));
        JLabel imageLabel = new JLabel(new ImageIcon("resources/game_bg.png"));
        game.add(imageLabel);
 
    }

    public static void processKey(String color) {
		Integer graphicNoteSize = graphicNotes.size();
		int notes = (graphicNoteSize < 5) ? graphicNoteSize : 5;
		for (int i=0;i<notes;i++) {
			GraphicNote note = graphicNotes.get(i);
			if (color.equals(note.color) && note.yOffset > floor-25 && note.yOffset < floor+25) {
				//compare y values
				graphicNotes.remove(note);
				if (consecutiveNotes > highestConsecutiveNotes) {
					highestConsecutiveNotes = consecutiveNotes;
				}
				if (consecutiveNotes > 10) {
					consecutiveNotes = 0;
					multiplier = multiplier + 1;
				}
				notesHit = notesHit + 1;
				consecutiveNotes = consecutiveNotes + 1;
				score = score + 100 * multiplier;
				return;
			}
		}
		multiplier = 1;
		consecutiveNotes = 0;

	}


    public void updatePositions() {
		ArrayList<GraphicNote> remove = new ArrayList<>();
	    for (GraphicNote note : graphicNotes) {
			if (note.yOffset > 800) {
				notesMissed = notesMissed + 1;
				remove.add(note);
				continue;
			}
	        note.yOffset = note.yOffset + 10;
	    }
	    graphicNotes.removeAll(remove);
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(bg, 0,0,null);
    	//draws 5 note buttons
    	g.drawImage(green_b,125 + 65, 630, null);
    	g.drawImage(red_b, 125 + 65*2, 630, null);
    	g.drawImage(yellow_b, 125 + 65*3, 630, null);
    	g.drawImage(blue_b, 125 + 65*4, 630, null);
    	g.drawImage(orange_b, 127 + 65*5, 630, null);
    	
    	
    	
    	for (Note note : activeNotes) {
    	    if (note.isGreen()) {
    	        graphicNotes.addLast(new GraphicNote(128 + 65*1, "g"));
            }
    	    if (note.isRed()) {
                graphicNotes.addLast(new GraphicNote(128 + 65*2, "r"));
            }
    	    if (note.isYellow()) {
                graphicNotes.addLast(new GraphicNote(128 + 65*3, "y"));
            }
    	    if (note.isBlue()) {
                graphicNotes.addLast(new GraphicNote(128 + 65*4, "b"));
            }
    	    if (note.isOrange()) {
                graphicNotes.addLast(new GraphicNote(128 + 65*5, "o"));
            }
    	    activeNotes.remove(note);
        }
    	for (GraphicNote note : graphicNotes) {
			if (note.color.equals("g") && note.yOffset < floor+25) {
				g.drawImage(green, note.xPosition-4, note.yOffset, null);
			}
			if (note.color.equals("r") && note.yOffset < floor+25) {
				g.drawImage(red, note.xPosition-4, note.yOffset, null);
			}
			if (note.color.equals("y") && note.yOffset < floor+25) {
				g.drawImage(yellow, note.xPosition-4, note.yOffset, null);
			}
			if (note.color.equals("b") && note.yOffset < floor+25) {
				g.drawImage(blue, note.xPosition-4, note.yOffset, null);
			}
			if (note.color.equals("o") && note.yOffset < floor+25) {
				g.drawImage(orange, note.xPosition-4, note.yOffset, null);
			}
			if (note.yOffset > floor+25) {
				g.drawImage(grey, note.xPosition-4, note.yOffset, null);
			}

		}
    	g.drawString(score.toString(), 100, 100);
    }


}

