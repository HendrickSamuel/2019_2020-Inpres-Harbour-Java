package inpresharbour;

import Amarrages.Ponton;
import Equipage.SailorWithoutIdentificationException;
import VehiculesMarins.Bateau;
import VehiculesMarins.ShipWithoutIdentificationException;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.*; 
import java.util.Properties; 
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InpresHarbour {

    public static void main(String[] args) {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        System.out.println(rep);
        
        Vector<Ponton> bats;
                
        try{
            FileInputStream fis = new FileInputStream(rep+sep+"test.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            bats = (Vector<Ponton>)ois.readObject();
            bats.forEach(x -> x.Affiche());
        } 
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }   
        
        
       
        
        
        try{
            bats = new Vector<Ponton>();
            
            Ponton b1 = new Ponton(1,1);
            Ponton b2 = new Ponton(2,1);
            Ponton b3 = new Ponton(3,1);            
            bats.add(b3);
            bats.add(b2);
            bats.add(b1);
            
            FileOutputStream fos = new FileOutputStream(rep+sep+"test.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(bats);
        } catch (IOException ex) {        
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
