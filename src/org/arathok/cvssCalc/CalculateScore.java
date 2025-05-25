package org.arathok.cvssCalc;

import java.util.HashMap;
import java.util.Locale;

public class CalculateScore {
    static Float exploitabilityBase = 0f;
    static HashMap<String, Float> avLookup = new HashMap<>();
    static HashMap<String, Float> acLookup = new HashMap<>();
    static HashMap<String, Float> prLookup = new HashMap<>();
    static HashMap<String, Float> uiLookup = new HashMap<>();
    static HashMap<String, Float> ciaLookup = new HashMap<>();


    public static void init()
    {
        // Attack Vector (AV)
        avLookup.put("N", 0.85f); // Network
        avLookup.put("A", 0.62f); // Adjacent
        avLookup.put("L", 0.55f); // Local
        avLookup.put("P", 0.20f); // Physical

        // Attack Complexity (AC)
        acLookup.put("L", 0.77f); // Low
        acLookup.put("H", 0.44f); // High

        // Privileges Required (PR)
        prLookup.put("N", 0.85f); // None
        prLookup.put("L", 0.62f); // Low
        prLookup.put("H", 0.27f); // High



        // User Interaction (UI)
        uiLookup.put("N", 0.85f); // None
        uiLookup.put("R", 0.62f); // Required

        // Confidentiality / Integrity / Availability (C, I, A)
        ciaLookup.put("N", 0.00f); // None
        ciaLookup.put("L", 0.22f); // Low
        ciaLookup.put("H", 0.56f); // High
    }
    public static void scores (HashMap<String,String>singleValues)
    {

        //Exploitability

        exploitabilityBase = 8.22f* avLookup.get(singleValues.get("AV"))*acLookup.get(singleValues.get("AC"))*prLookup.get(singleValues.get("PR"))*uiLookup.get(singleValues.get("UI"));

        Fenster.exploitabilityScoreValue.setText(String.format(Locale.US,"%.1f", exploitabilityBase));




    }

}
