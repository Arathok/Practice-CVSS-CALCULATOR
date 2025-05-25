package org.arathok.cvssCalc;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import static org.arathok.cvssCalc.Fenster.textFields;

public class StringKaputtmacher implements ActionListener {
    public static String vector = "";
    public static String exampleVector = "AV:A/AC:H/PR:L/UI:R/S:U/C:N/I:N/A:N/E:U/RL:O/RC:U/CR:L/IR:L/AR:L/MAV:N/MAC:L/MPR:N/MUI:N/MS:U/MC:N/MI:N/MA:N";
    String[] splitVector;
    HashMap<String, String> singleValues = new HashMap<>();


    @Override
    public void actionPerformed(ActionEvent e) {
        vector=Fenster.theVector.getText();
        if (vector.isEmpty()) {
            StringBuilder newVector = new StringBuilder();
            for (JComboBox<String> oneDropDown : textFields) {

                String selectedItem = (String) oneDropDown.getSelectedItem();
                if (selectedItem != null && !selectedItem.contains("X")) {
                    newVector.append(oneDropDown.getName()+":");
                    singleValues.put(oneDropDown.getName(), ((String) oneDropDown.getSelectedItem()).split(":")[0]);
                    newVector.append(selectedItem.split(":")[0]);
                    newVector.append("/");
                }

            }
            newVector.deleteCharAt(newVector.length()-1);
            Fenster.theVector.setText(newVector.toString());
            vector= newVector.toString();
        } else {
            this.splitVector = vector.split("/");
            for (String aString : splitVector) {
                singleValues.put(aString.split(":")[0], aString.split(":")[1]);
            }
            for
            // Auswahlboxen setzen

        }

        CalculateScore.scores(singleValues);




    }

}
