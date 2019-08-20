package com.guitarhero.listener;

import com.guitarhero.entity.Settings;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.util.concurrent.Flow;

public class MenuOptionsListener implements MenuListener {

    public static JTextField greenField = new JTextField(Settings.green,5);
    public static JTextField redField = new JTextField(Settings.red,5);
    public static JTextField yellowField = new JTextField(Settings.yellow,5);
    public static JTextField blueField = new JTextField(Settings.blue,5);
    public static JTextField orangeField = new JTextField(Settings.orange,5);
    public static JDialog dialog = new JDialog();

    public void menuSelected(MenuEvent event) {
        JMenu source = (JMenu) event.getSource();
        if (source.getText().equals("Options")) {
            if (dialog.isVisible()) {
                return;
            }
            dialog = new JDialog();
            JPanel panel = new JPanel(new GridLayout(0,2));
            dialog.add(panel);
            JButton submit = new JButton("Save Settings");
            submit.addActionListener(new SaveOptionsListener());
            submit.setActionCommand("Save");
            JLabel greenLabel = new JLabel("Green: ");
            JLabel redLabel = new JLabel("Red: ");
            JLabel yellowLabel = new JLabel("Yellow: ");
            JLabel blueLabel = new JLabel("Blue: ");
            JLabel orangeLabel = new JLabel("Orange: ");
            greenLabel.setHorizontalAlignment(SwingConstants.CENTER);
            redLabel.setHorizontalAlignment(SwingConstants.CENTER);
            yellowLabel.setHorizontalAlignment(SwingConstants.CENTER);
            blueLabel.setHorizontalAlignment(SwingConstants.CENTER);
            orangeLabel.setHorizontalAlignment(SwingConstants.CENTER);

            panel.add(greenLabel);
            panel.add(greenField);
            panel.add(redLabel);
            panel.add(redField);
            panel.add(yellowLabel);
            panel.add(yellowField);
            panel.add(blueLabel);
            panel.add(blueField);
            panel.add(orangeLabel);
            panel.add(orangeField);
            panel.add(new JLabel(""));
            panel.add(submit);
            dialog.pack();
            dialog.setVisible(true);

        }
    }

    public void menuDeselected(MenuEvent event) {

    }

    public void menuCanceled(MenuEvent event) {

    }
}