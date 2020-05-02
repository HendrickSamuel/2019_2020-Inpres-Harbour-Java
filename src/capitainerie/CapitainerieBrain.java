/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 27/03/2020                        */
/******************************************************/
package capitainerie;

import Amarrages.*;
import HarbourGlobal.MyLogger;
import VehiculesMarins.Bateau;
import VehiculesMarins.MoyenDeTransportSurEau;
import inpresharbour.InpresHarbour;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;


public final class CapitainerieBrain {

    public Vector<Amarrage> ListeAmarrages;
    public Vector<MoyenDeTransportSurEau> ListeBeateauxEnAttente;
    private MyLogger _logger;
    
    private Bateau _bateauEnCoursAmarrage;
    private Amarrage _AmarrageSelectionne;
    
    private int _coteSelectionne;
    private int _emplacementSelectione;
    
    private String _connectedUser;
    private boolean _isUserConnected;
    
    public CapitainerieBrain() {
        _logger = new MyLogger();
        //ListeAmarrages = new Vector<Amarrage>();
        Load();
        setCoteSelectionne(-1);
        setEmplacementSelectione(-1);
    }
    
    public void Save()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
       
        try{
            FileOutputStream fos = new FileOutputStream(rep+sep+"bateaux.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListeBeateauxEnAttente);
            // dire combien on a encodés
        } 
        catch (IOException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        try{
            FileOutputStream fos = new FileOutputStream(rep+sep+"amarrages.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListeAmarrages);
            // dire combien on a encodés
        } 
        catch (IOException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void Load()
    {
       String sep = System.getProperty("file.separator");
       String rep = System.getProperty("user.dir");
       
        try{
            FileInputStream fis = new FileInputStream(rep+sep+"bateaux.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ListeBeateauxEnAttente = (Vector<MoyenDeTransportSurEau>)ois.readObject();
            System.out.println("j'ai chargé " + ListeBeateauxEnAttente.size() + " bateaux");
            // dire combien on a encodés
        } 
        catch(FileNotFoundException ex)
        {
            ListeBeateauxEnAttente = new Vector<MoyenDeTransportSurEau>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try{
            FileInputStream fis = new FileInputStream(rep+sep+"amarrages.data");
            ObjectInputStream ois = new ObjectInputStream(fis);
            ListeAmarrages = (Vector<Amarrage>)ois.readObject();
            System.out.println("j'ai chargé " + ListeAmarrages.size() + " amarrages");
            // dire combien on a encodés
        } 
        catch(FileNotFoundException ex)
        {
            ListeAmarrages = new Vector<Amarrage>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
    public void RegisterUser(String newUser)
    {
        _connectedUser = newUser;
        _isUserConnected = true;
    }
    
    public void LogoutUser()
    {
        _isUserConnected = false;
    }
    
    public boolean isUserConnected()
    {
        return _isUserConnected;
    }

    public String getConnectedUser() {
        return _connectedUser;
    }
    
    public String Now()
    {
        return _logger.Now();
    }
    
    
    public void AmarrerBateau(Bateau bateau)
    {
        if(getAmarrageSelectionne().getClass().toString().compareTo("class Amarrages.Ponton") == 0)
        {
            Ponton ponton = (Ponton)getAmarrageSelectionne();
            // verifier la taille disponible + coté
            MoyenDeTransportSurEau[] cote = ponton.getListe(getCoteSelectionne());
            // verif == null
            cote[getEmplacementSelectione()] = bateau;
        }
        else
        if(getAmarrageSelectionne().getClass().toString().compareTo("class Amarrages.Quai") == 0)
        {
            Quai quai = (Quai)getAmarrageSelectionne();
            // verifier la taille disponible
            MoyenDeTransportSurEau[] emplacements = quai.getListe();
            // verif == null
            emplacements[getEmplacementSelectione()] = bateau;
        }
        setBateauEnCoursAmarrage(null);
    }
    
    public boolean IsAmarrageValide()
    {
        if(getAmarrageSelectionne() != null)
        {
            System.out.println(getAmarrageSelectionne().getClass().toString());
            if(getAmarrageSelectionne().getClass().toString().compareTo("class Amarrages.Ponton") == 0)
            {
                if(getEmplacementSelectione() != -1 && getCoteSelectionne() != -1) // verifier qu'on ne depasse pas
                    return true;
                else
                    return false;
            }
            else
            if(getAmarrageSelectionne().getClass().toString().compareTo("class Amarrages.Quai") == 0)
            {
                if(getEmplacementSelectione() != -1) // verifier qu'on ne depasse pas
                    return true;
                else
                    return false;
            }
            else
                return false;
        }
        else
            return false;
    }

    public
            Bateau getBateauEnCoursAmarrage()
    {
        return _bateauEnCoursAmarrage;
    }

    public
    void setBateauEnCoursAmarrage(Bateau _bateauEnCoursAmarrage)
    {
        this._bateauEnCoursAmarrage = _bateauEnCoursAmarrage;
    }

    public
            Amarrage getAmarrageSelectionne()
    {
        return _AmarrageSelectionne;
    }

    public
    void setAmarrageSelectionne(Amarrage _AmarrageSelectionne)
    {
        this._AmarrageSelectionne = _AmarrageSelectionne;
    }

    public int getCoteSelectionne()
    {
        return _coteSelectionne;
    }

    public
    void setCoteSelectionne(int _coteSelectionne)
    {
        this._coteSelectionne = _coteSelectionne;
    }

    public int getEmplacementSelectione()
    {
        return _emplacementSelectione;
    }

    public
    void setEmplacementSelectione(int _emplacementSelectione)
    {
        this._emplacementSelectione = _emplacementSelectione;
    }
    
    public String GetEmplacement()
    {
        return getAmarrageSelectionne().getIdentifiant()+getCoteSelectionne()+"*"+_emplacementSelectione;
    }
    
}
