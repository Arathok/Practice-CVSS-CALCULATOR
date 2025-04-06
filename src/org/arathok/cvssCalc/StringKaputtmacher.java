package org.arathok.cvssCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static org.arathok.cvssCalc.Fenster.textFields;

public class StringKaputtmacher implements ActionListener {
    public static String vector = "";
    public static String exampleVector = "AV:A/AC:H/PR:L/UI:R/S:U/C:N/I:N/A:N/E:U/RL:O/RC:U/CR:L/IR:L/AR:L/MAV:N/MAC:L/MPR:N/MUI:N/MS:U/MC:N/MI:N/MA:N";
    String [] splitVector;
    HashMap<String,String> singleValues=new HashMap<>();
    HashMap<String,String> selectedValues=new HashMap<>();

    @Override
    public void actionPerformed(ActionEvent e) {
        if (vector.isEmpty()) {
        StringBuilder newVector= new StringBuilder();
        for (JComboBox<String> oneDropDown: textFields)
        {
            selectedValues.put(oneDropDown.getName(),(String)oneDropDown.getSelectedItem());
        }
        Fenster.theVector.setText("");

        }


        this.splitVector = vector.split("/");
        for (String aString : splitVector)
        {
            singleValues.put(aString.split(":")[0],aString.split(":")[1]);
        }
    }

}
