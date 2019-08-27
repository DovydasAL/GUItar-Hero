package com.guitarhero;

import com.guitarhero.component.*;
import com.guitarhero.entity.Settings;
import com.guitarhero.entity.Song;
import com.guitarhero.entity.UpdateNotesThread;
import com.guitarhero.listener.GuitarKeyAction;
import com.guitarhero.listener.MenuOptionsListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{

    private static final Dimension dimensions = new Dimension(1200,800);
    public static JPanel mainScreen;
    private static JFrame frame;
    public static JMenu options;
    private static GridBagConstraints c;
    public static GamePanel gamePanel = new GamePanel();
    public static ExecutorService executorService = Executors.newSingleThreadExecutor();

    public Main() {
    }

    public static void createComponents() throws IOException, Exception {
        JPanel leftcol = new JPanel();
        LeftColumn.createLeftColumn(leftcol);
        gamePanel = new GamePanel();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weighty = 1;
        c.weightx = 1;
        mainScreen.add(leftcol,c);
        c.weightx = 2;
        mainScreen.add(gamePanel);
    }

    public static void startGame() {
        for (JButton button : SongList.buttons) {
            button.setEnabled(false);
        }
        PlayComponent.play.setText("Stop");
        UpdateNotesThread.stop = false;
        Song song = SongList.selected;
        options.setEnabled(false);
        gamePanel.prepareSong(song);
        executorService = Executors.newCachedThreadPool();
        UpdateNotesThread checkForNote = new UpdateNotesThread();
        executorService.execute(checkForNote);
        PlayComponent.playSong(song.getWavFile());
    }

    public static void stopGame() {
        stopGame(true);
    }

    public static void stopGame(boolean showSummary) {
        if (showSummary) {
            GamePanel.displaySummary();
        }
        for (JButton button : SongList.buttons) {
            button.setEnabled(true);
        }
        PlayComponent.play.setText("Play");
        UpdateNotesThread.stop = true;
        options.setEnabled(true);
        GamePanel.consecutiveNotes = 0;
        GamePanel.multiplier = 1;
        GamePanel.activeNotes = new LinkedList<>();
        GamePanel.graphicNotes = new LinkedList<>();
        GamePanel.allNotes = new LinkedList<>();
        GamePanel.totalNotes = 0;
        GamePanel.notesHit = 0;
        GamePanel.highestConsecutiveNotes = 0;
        GamePanel.notesMissed = 0;
        GamePanel.score = 0;
        executorService.shutdownNow();
        PlayComponent.playSong(null);

    }

    public static void createMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        options = new JMenu("Options");
        options.addMenuListener(new MenuOptionsListener());
        JMenu help = new JMenu("Help");
//        JMenu loadFile = new JMenu("Load Song");
        menuBar.add(options);
        menuBar.add(help);
//        menuBar.add(loadFile);
        frame.setJMenuBar(menuBar);
    }

    public static void main(String[] args) throws IOException, Exception {
        //Make frame non-resizable
        SongList.initializeSongs();
        SwingUtilities.isEventDispatchThread();
        JFrame frame = new JFrame("GUItar Hero");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        Container container = frame.getContentPane();
        mainScreen = new JPanel();
        mainScreen.setLayout(new GridBagLayout());
        mainScreen.setBackground(null);
        mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.red), "r");
        mainScreen.getActionMap().put("r", new GuitarKeyAction());
        mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.green), "g");
        mainScreen.getActionMap().put("g", new GuitarKeyAction());
        mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.yellow), "y");
        mainScreen.getActionMap().put("y", new GuitarKeyAction());
        mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.blue), "b");
        mainScreen.getActionMap().put("b", new GuitarKeyAction());
        mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.orange), "o");
        mainScreen.getActionMap().put("o", new GuitarKeyAction());
        c = new GridBagConstraints();
        //Set preferred dimensions
        mainScreen.setPreferredSize(dimensions);

        createMenuBar(frame);
        //Call function to add components to the screen
        createComponents();
        //Add screen to frame and make it visible
        container.add(mainScreen);
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
