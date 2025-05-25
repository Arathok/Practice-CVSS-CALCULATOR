package org.arathok.cvssCalc;


import javax.swing.*;

public class Main {


   public static void main(String[] args)
   {
      CalculateScore.init();
      SwingUtilities.invokeLater(Fenster::new);
   }

}
