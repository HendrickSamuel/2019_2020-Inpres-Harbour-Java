package inpresharbour;

import HarbourGlobal.MyLogger;
import capitainerie.Beans.DepartBean;
import capitainerie.Beans.DepartManager;
import network.NetworkBasicServer;

public class InpresHarbour {

    public static void main(String[] args) {
        /*MyLogger ml = new MyLogger();
        ml.Write("coucou");
        ml.Write("coucou");
        ml.ReadAll();*/

        DepartBean db = new DepartBean();
        DepartManager dm = new DepartManager();
        
        db.addDepartListener(dm);
        
        db.init();
        db.start();
        System.out.println("apres thread");
        
    }
}
