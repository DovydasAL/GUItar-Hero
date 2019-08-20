package com.guitarhero;

import com.guitarhero.component.*;
import com.guitarhero.listener.MenuOptionsListener;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main{

    private static final Dimension dimensions = new Dimension(1200,800);
    private static JPanel mainScreen;
    private static JFrame frame;
    private static GridBagConstraints c;
    
    public Main() {
    }

    public static void createComponents() throws IOException, Exception {
        JPanel leftcol = new JPanel();
        LeftColumn.createLeftColumn(leftcol);
        GamePanel game = new GamePanel();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTHWEST;
        c.weighty = 1;
        c.weightx = 1;
        mainScreen.add(leftcol,c);
        c.weightx = 2;
        mainScreen.add(game);
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
        c = new GridBagConstraints();
        //Set preferred dimensions
        mainScreen.setPreferredSize(dimensions);
        
        GamePanel game = new GamePanel();
        createMenuBar(frame);
        //Call function to add components to the screen
        createComponents();
        //Add screen to frame and make it visible
        container.add(mainScreen);
        frame.pack();
        frame.setVisible(true);
        
    }
    
}
