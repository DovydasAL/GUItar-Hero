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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{

    private static final Dimension dimensions = new Dimension(1200,800);
    private static JPanel mainScreen;
    private static JFrame frame;
    private static GridBagConstraints c;
    public static GamePanel gamePanel = new GamePanel();

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
        Song song = SongList.selected;
        gamePanel.prepareSong(song);
        UpdateNotesThread checkForNote = new UpdateNotesThread();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(checkForNote);
    }

    public static void stopGame() {

    }

    public static void createMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenu options = new JMenu("Options");
        options.addMenuListener(new MenuOptionsListener());
        JMenu help = new JMenu("Help");
        JMenu loadFile = new JMenu("Load Song");
        menuBar.add(options);
        menuBar.add(help);
        menuBar.add(loadFile);
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
