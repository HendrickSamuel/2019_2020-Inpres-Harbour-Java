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
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.CheckBox;
import javax.swing.JCheckBox;
import network.NetworkBasicServer;


public final class CapitainerieBrain {
    
    private NetworkBasicServer _nbs = null;
    private int PORT_ECOUTE = 50000;
    private String _messageAEnvoyer;
    

    public Vector<Amarrage> ListeAmarrages;
    public Vector<String> ListeBateauxEntree;
    private MyLogger _logger;
    
    private Bateau _bateauEnCoursAmarrage;
    
    private Amarrage _AmarrageSelectionne;
    
    private int _coteSelectionne;
    private int _emplacementSelectione;
    
    private String _connectedUser;
    private boolean _isUserConnected;
    
    public CapitainerieBrain() {
        _logger = new MyLogger();
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
            oos.writeObject(ListeBateauxEntree);
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
            ListeBateauxEntree = (Vector<String>)ois.readObject();
            System.out.println("j'ai chargé " + ListeBateauxEntree.size() + " bateaux en attente");
        } 
        catch(FileNotFoundException ex)
        {
            ListeBateauxEntree = new Vector<String>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try{
           FileInputStream fis = new FileInputStream(rep+sep+"amarrages.data");
           ObjectInputStream ois = new ObjectInputStream(fis);
           ListeAmarrages = (Vector<Amarrage>)ois.readObject();
           System.out.println("j'ai chargé " + ListeAmarrages.size() + " amarrages");
        } 
        catch(FileNotFoundException ex)
        {
            System.out.println("Fichier non trouvé, Initialisation de InpresHarbour");
            ListeAmarrages = new Vector<Amarrage>();
            InitHarbour();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void InitHarbour()
    {
        Ponton ponton;
        Quai quai;
        
        ponton = new Ponton(1, 5);
        ListeAmarrages.add(ponton);
        
        ponton = new Ponton(2, 8);
        ListeAmarrages.add(ponton);
        
        ponton = new Ponton(3,5);
        ListeAmarrages.add(ponton);
        
        quai = new Quai(1, 7);
        ListeAmarrages.add(quai);
        
        quai = new Quai(2, 5);
        ListeAmarrages.add(quai);

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
        // verifi la validite 
        if(getAmarrageSelectionne() instanceof Ponton)
        {
            Ponton ponton = (Ponton)getAmarrageSelectionne();
            // verifier la taille disponible + coté
            MoyenDeTransportSurEau[] cote = ponton.getListe(getCoteSelectionne());
            // verif == null
            cote[getEmplacementSelectione()] = bateau;
        }
        else
        if(getAmarrageSelectionne() instanceof Quai)
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
            if(getAmarrageSelectionne() instanceof Ponton)
            {
                if(getEmplacementSelectione() != -1 && getCoteSelectionne() != -1) // verifier qu'on ne depasse pas
                    return true;
                else
                    return false;
            }
            else
            if(getAmarrageSelectionne() instanceof Quai)
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

    public Bateau getBateauEnCoursAmarrage()
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
    void setAmarrageSelectionne(Amarrage amarrageSelectionne)
    {
        this._AmarrageSelectionne = amarrageSelectionne;
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
        if(getAmarrageSelectionne() != null)
        {
            if(getAmarrageSelectionne() instanceof Ponton)
            {
               return getAmarrageSelectionne().getIdentifiant()+getCoteSelectionne()+"*"+_emplacementSelectione;
            }
            else
            if(getAmarrageSelectionne() instanceof Quai)
            {
                return getAmarrageSelectionne().getIdentifiant()+"*"+_emplacementSelectione;
            }
            else
                return "";
        }
        else
            return "";
        
    }
    
    public void DemarrerServeur(JCheckBox check)
    {
        if(!IsServerOn())
        {
            _nbs = new NetworkBasicServer(PORT_ECOUTE, check);
        }
        else
            System.out.println("Le serveur est déja en cours");
    }
    
    public void ArreterServeur()
    {
        if(IsServerOn())
        {
            _nbs.setEndReceiving();
            _nbs = null;
        }
    }

    public boolean IsServerOn() {
        if(_nbs == null)
            return false;
        else
            return true;
    }
    
    public void sendMessage(String amarrage)
    {
        _nbs.sendMessage(amarrage);
    }
    
    public String ReadMessage()
    {
        if(IsServerOn())
        {
            String message = _nbs.getMessage();
            return message;
        }
        else
            return "";
    }

    public String getMessageAEnvoyer() {
        return _messageAEnvoyer;
    }

    public void setMessageAEnvoyer(String _messageAEnvoyer) {
        this._messageAEnvoyer = _messageAEnvoyer;
    }
    
    public void SetBateauFromText(String text)
    {
        boolean found = false;
        //division de la chaine de charactere passée au format Test -- Peche -- FR -> Q2*4 OU Test -- Plaisance -- FR -> P22*4
        
        text = text.replaceAll("\\s+",""); // prendre char espace ?
        text = text.replaceAll("--"," ");
        text = text.replaceAll("->"," ");
        text = text.replaceAll("\\*"," ");
        
        StringTokenizer st = new StringTokenizer(text);

        String nomBateau = st.nextToken();
        
        String typeBateau = st.nextToken();
        
        String pavillon = st.nextToken();
        
        String amarrage = st.nextToken(); // P11 ou Q1
        String cote = "";
        switch(amarrage.substring(0,1))
        {
            case "Q":
                cote = "-1";
                break;
                
            case "P":
                cote = amarrage.substring(amarrage.length()-1);
                amarrage = amarrage.substring(0,amarrage.length()-1);
                break;         
        }

        String emplacement = st.nextToken();        
        // recherche l'amarrage
        
        Enumeration enu = ListeAmarrages.elements();
        while(enu.hasMoreElements() && !found)
        {
            Amarrage am = (Amarrage)enu.nextElement();
            if(am.getIdentifiant().compareTo(amarrage) == 0)
            {
                found = true;
                System.out.println("Trouvé");
                this.setAmarrageSelectionne(am);
                this.setEmplacementSelectione(Integer.parseInt(emplacement));
                this.setCoteSelectionne(Integer.parseInt(cote));
                
                //verifier que l'emplacement contient le bateau en cours ? 
            }
        }
        
        if(!found)
        {
            System.out.println("Pas Trouvé");
        }
        
    }
    
}
