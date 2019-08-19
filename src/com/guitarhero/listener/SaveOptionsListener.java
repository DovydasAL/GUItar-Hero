package com.guitarhero.listener;

import com.guitarhero.entity.Settings;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveOptionsListener implements ActionListener {

    public void actionPerformed(ActionEvent event) {
        if (event.getActionCommand().equals("Save")) {
            Settings.green = MenuOptionsListener.greenField.getText();
            Settings.red = MenuOptionsListener.redField.getText();
            Settings.yellow = MenuOptionsListener.yellowField.getText();
            Settings.blue = MenuOptionsListener.blueField.getText();
            Settings.orange = MenuOptionsListener.orangeField.getText();
            MenuOptionsListener.dialog.dispose();
        }
    }

}
