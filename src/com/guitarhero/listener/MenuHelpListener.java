package com.guitarhero.listener;

import com.guitarhero.Main;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

public class MenuHelpListener implements MenuListener {

    public static JDialog dialog = new JDialog();

    public void menuSelected(MenuEvent event) {
        if (dialog.isVisible()) {
            return;
        }
        dialog = new JDialog(Main.frame, "Help");
        dialog.setPreferredSize(new Dimension(550,500));
        dialog.setResizable(false);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        dialog.add(panel);

        JButton close = new JButton("Close");
        close.addActionListener(new CloseHelpListener());
        close.setActionCommand("Close");
        panel.add(close, BorderLayout.PAGE_END);

        JTextPane helpField = new JTextPane();
        helpField.setContentType("text/html");
        JScrollPane helpFieldScrollPane = new JScrollPane(helpField);
        helpFieldScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        helpFieldScrollPane.setPreferredSize(new Dimension(250,250));
        helpField.setText("<html><h1 style=\"text-align:center\">Test</h1>" +
                "</html>");
        helpField.setCaretPosition(0);
        helpField.setEditable(false);
        panel.add(helpFieldScrollPane, BorderLayout.CENTER);
//        panel.add(helpField, BorderLayout.CENTER);

        dialog.pack();
        dialog.setVisible(true);
    }

    public void menuDeselected(MenuEvent event) {

    }

    public void menuCanceled(MenuEvent event) {

    }
}
