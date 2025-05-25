package org.arathok.cvssCalc;


import javax.swing.*;
import java.util.ArrayList;
import org.knowm.xchart.*;

public class Fenster extends JFrame {

    StringKaputtmacher clicked = new StringKaputtmacher();
    static int labelXDist = 10;
    static int labelYDist = 120;
    static int labelWidth = 100;
    static int labelHeight = 50;

    static int textFieldXDist = 50;
    static int textFieldYDist = 135;
    static int textFieldWidth = 150;
    static int textFieldHeight = 20;

    static JTextField theVector = new JTextField();
    static JLabel exampleVector = new JLabel("Vector Field Empty! Using Example Vector!");
    static JLabel exploitabilityScoreValue= new JLabel("0.00");
    static ArrayList<JLabel> labels = new ArrayList<>();
    public static ArrayList<JComboBox<String>> textFields = new ArrayList<>();

    public Fenster() {
        initTextfields();
        initLabels();
        setTitle("CSVV Calculator");
        setLayout(null);
        setSize(1200, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel currentAV = new JLabel("Current AttackVector:");
        currentAV.setBounds(10, 10, 200, 30);
        add(currentAV);

        JLabel baseSM = new JLabel("<html><u>Base Score Metrics:</u></html>");
        baseSM.setBounds(10, 60, 200, 30);
        add(baseSM);
        JLabel eM = new JLabel("<html><u>Exploitability Metrics</u></html>");
        eM.setBounds(10, 100, 200, 30);
        add(eM);

        JLabel eeM = new JLabel("<html><u>Environmental Exploitability Metrics</u></html>");
        eeM.setBounds(250, 265, 300, 30);
        add(eeM);

        JLabel iM = new JLabel("<html><u>Impact Metrics</u></html>");
        iM.setBounds(10, 365, 200, 30);
        add(iM);

        JLabel tS = new JLabel("<html><u>Temporal Score Metrics</u></html>");
        tS.setBounds(10, 530, 200, 30);
        add(tS);

        JLabel environMentalSM = new JLabel("<html><u>Environmental Metrics</u></html>");
        environMentalSM.setBounds(250, 60, 200, 30);
        add(environMentalSM);

        JLabel eiM = new JLabel("<html><u>Environmental Impact Metrics</u></html>");
        eiM.setBounds(250, 530, 200, 30);
        add(eiM);

        JLabel isM = new JLabel("<html><u>Impact Subscore Modifiers</u></html>");
        isM.setBounds(250, 100, 200, 30);
        add(isM);


        JLabel exploitabilityScore= new JLabel("<html><u>Base Exploitability</u></html>");
        exploitabilityScore.setBounds(550, 500, 200, 30);
        add(exploitabilityScore);


        exploitabilityScoreValue.setBounds(550, 520, 200, 30);
        add(exploitabilityScoreValue);
        //exploitabilityScore.setVisible(false);



        theVector.setBounds(150, 10, 700, 30);
        theVector.setText(StringKaputtmacher.vector);
        add(theVector);

        for (JComboBox<String> oneTextField : textFields) {
            add(oneTextField);
        }

        for (JLabel oneLabel : labels) {
            add(oneLabel);
        }

        JButton calculate = new JButton("Calculate!");
        calculate.setBounds(1000, 700, 100, 20);
        calculate.addActionListener(clicked);
        add(calculate);


        exampleVector.setBounds(900, 720, 400, 30);
        exampleVector.setVisible(false);
        add(exampleVector);



        setVisible(true);
    }

    public static void initTextfields() {

        //Base Exploitability
        makeDropDown("AV", new String[]{"N: Network", "A: Adjacent", "L: Local", "P: Physical"});
        makeDropDown("AC", new String[]{"L: Low", "H: High"});
        makeDropDown("PR", new String[]{"N: None", "L: Low", "H: High"});
        makeDropDown("UI", new String[]{"N: None", "R: Required"});
        makeDropDown("S", new String[]{"U: Unchanged", "C: Changed"});


        //Base Impact Metrics
        makeDropDown("C", new String[]{"N: None", "L: Low", "H: High"});
        makeDropDown("I", new String[]{"N: None", "L: Low", "H: High"});
        makeDropDown("A", new String[]{"N: None", "L: Low", "H: High"});

        // Temporal Score Metrics
        makeDropDown("E", new String[]{"X: Undefined","U: Unproven", "P: Proof-of-Concept", "F: Functional", "H: High"});
        makeDropDown("RL", new String[]{"X: Undefined","O: Official Fix", "T: Temporary Fix", "W: Workaround", "U: Unavailable"});
        makeDropDown("RC", new String[]{"X: Undefined","U: Unknown", "R: Reasonable", "C: Confirmed"});

        //Environmental Score Metrics

        //Impact Subscore
        makeDropDown("CR", new String[]{"X: Undefined","L: Low", "M: Medium", "H: High"});
        makeDropDown("IR", new String[]{"X: Undefined","L: Low", "M: Medium", "H: High"});
        makeDropDown("AR", new String[]{"X: Undefined","L: Low", "M: Medium", "H: High"});

        //Exploitability
        makeDropDown("MAV", new String[]{"X: Undefined","N: Network", "A: Adjacent", "L: Local", "P: Physical"});
        makeDropDown("MAC", new String[]{"X: Undefined","L: Low", "H: High"});
        makeDropDown("MPR", new String[]{"X: Undefined","N: None", "L: Low", "H: High"});
        makeDropDown("MUI", new String[]{"X: Undefined","N: None", "R: Required"});
        makeDropDown("MS", new String[]{"X: Undefined","U: Unchanged", "C: Changed"});

        // Impact
        makeDropDown("MC", new String[]{"X: Undefined","N: None", "L: Low", "H: High" });
        makeDropDown("MI", new String[]{"X: Undefined","N: None", "L: Low", "H: High"});
        makeDropDown("MA", new String[]{"X: Undefined","N: None", "L: Low", "H: High" });



    }

    public void initLabels() {

        //Base Exploitability

        makeLabel("AV:");
        makeLabel("AC:");


        makeLabel("PR:");
        makeLabel("UI:");
        makeLabel("S:");

        //Base Impact Metrics
        makeLabel("C:");
        makeLabel("I:");
        makeLabel("A:");

        // Temporal Score Metrics
        makeLabel("E:");
        makeLabel("RL:");
        makeLabel("RC:");

        //Environmental Score Metrics

        //Impact Subscore
        makeLabel("CR:");
        makeLabel("IR:");
        makeLabel("AR:");

        //Exploitability
        makeLabel("MAV:");
        makeLabel("MAC:");
        makeLabel("MPR:");
        makeLabel("MUI:");
        makeLabel("MS:");

        // Impact
        makeLabel("MC:");
        makeLabel("MI:");
        makeLabel("MA:");



    }

    public static void makeLabel(String name) {
        JLabel av = new JLabel(name);
        av.setBounds(labelXDist, labelYDist, labelWidth, labelHeight);
        if (name.equals("S:")||name.equals("A:")||name.equals("MS:")||name.equals("AR:"))
        labelYDist += 15;
        if (labelYDist <= 650&&!name.equals("RC:"))
            labelYDist += 50;
        else {
            labelYDist = 120;
            labelXDist = 250;
        }
        labels.add(av);

    }

    public static void makeDropDown(String name, String[] options) {
        JComboBox<String> av = new JComboBox<>(options);
        av.setBounds(textFieldXDist, textFieldYDist, textFieldWidth, textFieldHeight);
        av.setName(name);
        if (name.equals("S")||name.equals("A")||name.equals("MS")||name.equals("AR"))
            textFieldYDist += 15;
        if (textFieldYDist <= 650&&!name.equals("RC"))
            textFieldYDist += 50;
        else {
            textFieldYDist = 135;
            textFieldXDist = 300;
        }
        if(name.equals("AV"))
            av.setSelectedIndex(3);
        if(name.equals("AC"))
            av.setSelectedIndex(1);
        if(name.equals("PR"))
            av.setSelectedIndex(2);
        if(name.equals("UI"))
            av.setSelectedIndex(1);

        textFields.add(av);
    }

}
