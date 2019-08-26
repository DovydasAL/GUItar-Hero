package com.guitarhero.component;

import com.guitarhero.entity.GraphicNote;
import com.guitarhero.entity.Note;
import com.guitarhero.entity.Song;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class GamePanel extends JPanel {

    public static LinkedList<Note> allNotes = new LinkedList<>();
    public static LinkedList<Note> activeNotes = new LinkedList<>();
    public static LinkedList<GraphicNote> graphicNotes = new LinkedList<>();
    public static Integer score = 0;
    public static Integer multiplier = 1;
    public static Integer consecutiveNotes = 0;

	
	private Image bg = new ImageIcon("resources/game_bg.png").getImage();

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
			if (color.equals(note.color)) {
				graphicNotes.remove(note);
				if (consecutiveNotes > 10) {
					consecutiveNotes = 0;
					multiplier = multiplier + 1;
				}
				consecutiveNotes = consecutiveNotes + 1;
				score = score + 100 * multiplier;
				return;
			}
		}
		multiplier = 0;
		consecutiveNotes = 0;

	}
    
    public static void drawnote(int note, Graphics g) {
    	switch(note){
    		case 1: 
    			g.setColor(Color.GREEN);
    		break;
    		case 2:
    			g.setColor(Color.RED);
    		break;
    		case 3:
    			g.setColor(Color.yellow);
    		break;
    		case 4:
    			g.setColor(Color.BLUE);
    		break;
    		case 5:
    			g.setColor(Color.ORANGE);
    		break;
    	}
    	
    	g.fillOval(128 + 65*note, 0, 50, 50);
    	g.setColor(Color.WHITE);
    	g.fillOval(140 + 65*note, 12, 25, 25);
    }


    public void updatePositions() {
	    for (GraphicNote note : graphicNotes) {
	        note.yOffset = note.yOffset + 10;
	    }
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(bg, 0,0,null);
    	for (Note note : activeNotes) {
    	    if (note.isGreen()) {
    	        drawnote(1, g);
    	        graphicNotes.addLast(new GraphicNote(128 + 65*1, "g"));
            }
    	    if (note.isRed()) {
    	        drawnote(2, g);
                graphicNotes.addLast(new GraphicNote(128 + 65*2, "r"));
            }
    	    if (note.isYellow()) {
    	        drawnote(3, g);
                graphicNotes.addLast(new GraphicNote(128 + 65*3, "y"));
            }
    	    if (note.isBlue()) {
    	        drawnote(4,g);
                graphicNotes.addLast(new GraphicNote(128 + 65*4, "b"));
            }
    	    if (note.isOrange()) {
    	        drawnote(5,g);
                graphicNotes.addLast(new GraphicNote(128 + 65*5, "o"));
            }
    	    activeNotes.remove(note);
        }
    	for (GraphicNote note : graphicNotes) {
			if (note.color.equals("g")) {
				g.setColor(Color.GREEN);
			}
			if (note.color.equals("r")) {
				g.setColor(Color.RED);
			}
			if (note.color.equals("y")) {
				g.setColor(Color.YELLOW);
			}
			if (note.color.equals("b")) {
				g.setColor(Color.BLUE);
			}
			if (note.color.equals("o")) {
				g.setColor(Color.ORANGE);
			}
			g.fillOval(note.xPosition, note.yOffset, 50, 50);
			g.setColor(Color.WHITE);
			g.fillOval(note.xPosition + 12, note.yOffset + 12, 25, 25);

		}
    	g.drawString(score.toString(), 100, 100);
    }


}

