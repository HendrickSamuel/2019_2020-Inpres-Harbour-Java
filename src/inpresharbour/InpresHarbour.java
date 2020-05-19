package inpresharbour;

import HarbourGlobal.MyAppProperties;
import HarbourGlobal.MyLogger;
import HarbourGlobal.PropertiesEnum;
import capitainerie.Beans.DepartBean;
import capitainerie.Beans.DepartManager;
import network.NetworkBasicServer;

public class InpresHarbour {

    public static void main(String[] args) {
        MyAppProperties mp = new MyAppProperties();
        mp.setPropertie(PropertiesEnum.PortDepart, "50001");
        mp.setPropertie(PropertiesEnum.PortArrive, "50000");
        mp.setPropertie(PropertiesEnum.ReferencesSimulation, "7");
        mp.setPropertie(PropertiesEnum.TempsSommeil, "7");
        
        mp.setPropertie(PropertiesEnum.FileAmarrages, "amarrages.data");
        mp.setPropertie(PropertiesEnum.FileBateauxAttente, "bateaux.data");
        mp.setPropertie(PropertiesEnum.FileLogCapitainerie, "capitainerie.log");
        mp.setPropertie(PropertiesEnum.FileLogCapitainerie, "phare.log");
        mp.setPropertie(PropertiesEnum.PortDepart, "50000");
        
        String test = mp.getPropertie(PropertiesEnum.PortDepart);
        System.out.println(test);
        
        mp.Save();
        
    }
}
