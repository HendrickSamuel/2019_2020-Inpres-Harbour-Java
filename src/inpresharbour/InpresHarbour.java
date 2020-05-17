package inpresharbour;

import HarbourGlobal.MyLogger;

public class InpresHarbour {

    public static void main(String[] args) {
        MyLogger ml = new MyLogger();
        ml.Write("coucou");
        ml.Write("coucou");
        ml.ReadAll();
    }
    
}
