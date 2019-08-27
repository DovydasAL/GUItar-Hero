package com.guitarhero.listener;

import com.guitarhero.Main;
import com.guitarhero.entity.Settings;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.io.File;
import java.io.IOException;
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
            dialog = new JDialog(Main.frame, "Settings");
            dialog.setPreferredSize(new Dimension(500,450));
            JPanel panel = new JPanel(new GridLayout(0,2));
            panel.setBackground(new Color(69,10,12));
            try {
    			panel.setFont(Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Quantico-Regular.ttf")));
    			panel.setFont(panel.getFont().deriveFont(30.0f));
    		} catch (FontFormatException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
            dialog.add(panel);
            JButton reset = new JButton("Reset to Default");
            reset.addActionListener(new ResetDefaultOptionsListener());
            reset.setActionCommand("Reset");
            JButton submit = new JButton("Save Settings");
            submit.addActionListener(new SaveOptionsListener());
            submit.setActionCommand("Save");
            JButton cancel = new JButton("Cancel");
            cancel.addActionListener(new CancelOptionsListener());
            cancel.setActionCommand("Cancel");
            JLabel greenLabel = new JLabel("Green: ");
            JLabel redLabel = new JLabel("Red: ");
            JLabel yellowLabel = new JLabel("Yellow: ");
            JLabel blueLabel = new JLabel("Blue: ");
            JLabel orangeLabel = new JLabel("Orange: ");
            try {
            	Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Roddenberry Italic.ttf"));
            	Color textcolor = Color.white;
            	greenLabel.setFont(customFont);
				greenLabel.setFont(greenLabel.getFont().deriveFont(30.0f));
				greenLabel.setForeground(textcolor);
				redLabel.setFont(customFont);
				redLabel.setFont(greenLabel.getFont().deriveFont(30.0f));
				redLabel.setForeground(textcolor);
				yellowLabel.setFont(customFont);
				yellowLabel.setFont(greenLabel.getFont().deriveFont(30.0f));
				yellowLabel.setForeground(textcolor);
				blueLabel.setFont(customFont);
				blueLabel.setFont(greenLabel.getFont().deriveFont(30.0f));
				blueLabel.setForeground(textcolor);
				orangeLabel.setFont(customFont);
				orangeLabel.setFont(greenLabel.getFont().deriveFont(30.0f));
				orangeLabel.setForeground(textcolor);
				
			} catch (FontFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
            panel.add(reset);
            panel.add(cancel);
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
