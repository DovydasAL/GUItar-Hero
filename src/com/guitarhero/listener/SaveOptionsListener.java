package com.guitarhero.listener;

import com.guitarhero.Main;
import com.guitarhero.entity.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveOptionsListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Save")) {
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).remove(KeyStroke.getKeyStroke(Settings.red));
            Main.mainScreen.getActionMap().remove("r");
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).remove(KeyStroke.getKeyStroke(Settings.green));
            Main.mainScreen.getActionMap().remove("g");
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).remove(KeyStroke.getKeyStroke(Settings.yellow));
            Main.mainScreen.getActionMap().remove("y");
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).remove(KeyStroke.getKeyStroke(Settings.blue));
            Main.mainScreen.getActionMap().remove("b");
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).remove(KeyStroke.getKeyStroke(Settings.orange));
            Main.mainScreen.getActionMap().remove("o");
            Settings.green = MenuOptionsListener.greenField.getText();
            Settings.red = MenuOptionsListener.redField.getText();
            Settings.yellow = MenuOptionsListener.yellowField.getText();
            Settings.blue = MenuOptionsListener.blueField.getText();
            Settings.orange = MenuOptionsListener.orangeField.getText();
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.red), "r");
            Main.mainScreen.getActionMap().put("r", new GuitarKeyAction());
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.green), "g");
            Main.mainScreen.getActionMap().put("g", new GuitarKeyAction());
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.yellow), "y");
            Main.mainScreen.getActionMap().put("y", new GuitarKeyAction());
            Main.mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.blue), "b");
            Main.mainScreen.getActionMap().put("b", new GuitarKeyAction());
            Main. mainScreen.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(Settings.orange), "o");
            Main. mainScreen.getActionMap().put("o", new GuitarKeyAction());
            MenuOptionsListener.dialog.dispose();
        }
    }

}
