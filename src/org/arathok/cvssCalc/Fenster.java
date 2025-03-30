package org.arathok.cvssCalc;

import javax.swing.*;
import java.awt.*;

public class Fenster extends JFrame {
    public Fenster ()
    {
        setTitle("CSVV Calculator");
        setLayout(null);
        setSize(1080,720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel label = new JLabel("Hallo");
        label.setBounds(150 ,150,100,30);
        add(label);
        setVisible(true);
    }
}
