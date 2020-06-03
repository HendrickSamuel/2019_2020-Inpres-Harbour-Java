/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HarbourGlobal;

import java.util.Locale;
import java.util.StringTokenizer;

/**
 *
 * @author hydro
 */
public class GestionLocale {
    
     //<editor-fold defaultstate="collapsed" desc="Local to string and opposite">
    public static String localeToString(Locale l) {
        return l.getLanguage() + "," + l.getCountry();
    }

    public static Locale stringToLocale(String s) {
        StringTokenizer tempStringTokenizer = new StringTokenizer(s,",");
        String l = "FR";
        String c = "fr";
        if(tempStringTokenizer.hasMoreTokens())
            l = tempStringTokenizer.nextElement().toString();
        if(tempStringTokenizer.hasMoreTokens())
            c = tempStringTokenizer.nextElement().toString();

        return new Locale(l,c);
    }  
    //</editor-fold>
}
