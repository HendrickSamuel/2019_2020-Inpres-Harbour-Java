/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 27/03/2020                        */
/******************************************************/
package capitainerie;

import Amarrages.*;
import Equipage.Equipage;
import Equipage.SailorWithoutIdentificationException;
import HarbourGlobal.MyLogger;
import VehiculesMarins.*;
import capitainerie.Beans.*;
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


public final class CapitainerieBrain implements DepartListener {
       
    private String[] _etapes;
    private int _etape;
    
    private NetworkBasicServer _nbs = null;
    private int PORT_ECOUTE = 50000;
    private String _messageAEnvoyer;
    
    private DepartBean dbean = null;

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
        _logger = new MyLogger("capitainerie");
        _logger.Write("capitainerieBrain", "démarrage de la capitainerie");
        Load();
        setCoteSelectionne(-1);
        setEmplacementSelectione(-1);
        
        _etapes = new String[4];
    }
    
    public void Save()
    {
        String sep = System.getProperty("file.separator");
        String rep = System.getProperty("user.dir");
        
         try{
            FileOutputStream fos = new FileOutputStream(rep+sep+"bateaux.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListeBateauxEntree);
            getLogger().Write("capitainerieBrain", "sauvegarde de " + ListeBateauxEntree.size() + "éléments dans " + rep+sep+"bateaux.data");
        } 
        catch (IOException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        try{
            FileOutputStream fos = new FileOutputStream(rep+sep+"amarrages.data");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ListeAmarrages);
            getLogger().Write("capitainerieBrain", "sauvegarde de " + ListeAmarrages.size() + "éléments dans " + rep+sep+"amarrages.data");
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
            getLogger().Write("capitainerieBrain", "chargement de " + ListeBateauxEntree.size() + "éléments de " + rep+sep+"bateaux.data");
        } 
        catch(FileNotFoundException ex)
        {
            getLogger().Write("capitainerieBrain", "création d'une nouvelle liste de bateaux en entrée car aucun fichier de sauvegarde n'éxiste");
            ListeBateauxEntree = new Vector<String>();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(InpresHarbour.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        try{
           FileInputStream fis = new FileInputStream(rep+sep+"amarrages.data");
           ObjectInputStream ois = new ObjectInputStream(fis);
           ListeAmarrages = (Vector<Amarrage>)ois.readObject();
            getLogger().Write("capitainerieBrain", "chargement de " + ListeAmarrages.size() + "éléments de " + rep+sep+"amarrages.data");
        } 
        catch(FileNotFoundException ex)
        {
            getLogger().Write("capitainerieBrain", "Initialisation de InpresHarbour car aucun fichier des amarrages n'éxiste");
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
    
    public boolean AmarrerBateau(Bateau bateau, Amarrage amarrage, int cote, int emplacement)
    {
        // verifi la validite 
        if(amarrage instanceof Ponton)
        {
            Ponton ponton = (Ponton)amarrage;
            // verifier la taille disponible + coté
            MoyenDeTransportSurEau[] liste = ponton.getListe(cote);
            // verif == null
            if(liste[emplacement] == null)
            {
                liste[emplacement] = bateau;
                return true;
            }
            else
                return false;
        }
        else
        if(amarrage instanceof Quai)
        {
            Quai quai = (Quai)amarrage;
            // verifier la taille disponible
            MoyenDeTransportSurEau[] liste = quai.getListe();
            // verif == null
            if(liste[emplacement] == null)
            {
                liste[emplacement] = bateau;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }
    
    public Bateau GetBateauAmarre(Amarrage amarrage, int cote, int emplacement)
    {
        if(amarrage instanceof Ponton)
        {
            Ponton ponton = (Ponton)amarrage;
            // verifier la taille disponible + coté
            MoyenDeTransportSurEau[] liste = ponton.getListe(cote);
            // verif == null
            return (Bateau)liste[emplacement];
        }
        else
        if(amarrage instanceof Quai)
        {
            Quai quai = (Quai)amarrage;
            // verifier la taille disponible
            MoyenDeTransportSurEau[] liste = quai.getListe();
            // verif == null
            return (Bateau)liste[emplacement];
        }
        else
            return null;
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
            _logger.Write("CapitainerieBrain","Démarrage du serveur");
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
            _logger.Write("CapitainerieBrain","Arret du serveur");
        }
    }

    public boolean IsServerOn() {
        if(_nbs == null)
            return false;
        else
            return true;
    }
    
    public void sendMessage(int etape)
    {
        _etape = etape; // trace du dernier message envoyé
        etape--;
        _logger.Write("CapitainerieBrain","Envoi du message: "+ "Envoi de: " + _etapes[etape] +" à l'étape "+_etape);
        _nbs.sendMessage(_etapes[etape]);
    }
    
    
    
    public String ReadMessage()
    {
        if(IsServerOn())
        {
            String message = _nbs.getMessage();
            int etape = Integer.parseInt(message.substring(0,1));
            _etape = etape;
            _logger.Write("CapitainerieBrain","Lecture du message: "+ message +" à l'étape "+_etape);
            SetMessage(etape, message);
            return message;
        }
        else
            return "";
    }
    
    public String getMessage(int etape)
    {
        etape--;
        return _etapes[etape];
    }
    
    public void SetMessage(int etape, String msg)
    {
        etape--;
        _etapes[etape] = msg;
    }
    
    public void SelectBateauFromText(String text)
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
        
        Enumeration enu = ListeAmarrages.elements();
        while(enu.hasMoreElements() && !found)
        {
            Amarrage am = (Amarrage)enu.nextElement();
            if(am.getIdentifiant().compareTo(amarrage) == 0)
            {
                found = true;
                System.out.println("Trouvé");
                setAmarrageSelectionne(am);
                setCoteSelectionne(Integer.parseInt(cote));
                setEmplacementSelectione(Integer.parseInt(emplacement));
                
                setBateauEnCoursAmarrage(GetBateauAmarre(am,Integer.parseInt(cote),Integer.parseInt(emplacement)));
                
                System.out.println(IsAmarrageValide());
                System.out.println(getBateauEnCoursAmarrage());
            }
        }
    }
    
    public Bateau CreerBateauFromString(String text)
    {
        try {
            // "nom/type/pavillon/longueur"
            
            StringTokenizer st = new StringTokenizer(text,"/");
            String nom = st.nextToken();
            String type = st.nextToken();
            String pavillon = st.nextToken();
            int longueur = Integer.parseInt(st.nextToken());
            
            switch(type)
            {
                case "Peche":
                    BateauPeche bpe = new BateauPeche(nom, "?", longueur, 0, pavillon, true, new Equipage(), Energie.autre, type);
                    _logger.Write("CapitainerieBrain","Création du bateau: " + bpe);
                    return bpe;
                    
                case "Plaisance":
                   BateauPlaisance bp = new BateauPlaisance(nom,"?",longueur,0,pavillon, new Equipage(), true ,Energie.autre, type);
                   _logger.Write("CapitainerieBrain","Création du bateau " + bp);
                   return bp;

                default: return null; 
            }
        } catch (SailorWithoutIdentificationException ex) {
            return null;
        } catch (ShipWithoutIdentificationException ex) {
            return null;
        }
    }
    
    public boolean AmarrerBateauToID(Bateau bateau, String text)
    {
        StringTokenizer st = new StringTokenizer(text,"\\*");
        
        String amarrage = st.nextToken();
        String emplacement = st.nextToken();
        
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
        
        Enumeration enu = ListeAmarrages.elements();
        while(enu.hasMoreElements())
        {
            Amarrage am = (Amarrage)enu.nextElement();
            if(am.getIdentifiant().compareTo(amarrage) == 0)
            {
               return AmarrerBateau(bateau, am, Integer.parseInt(cote), Integer.parseInt(emplacement));
            }
        }
        
        return false;  
    }

    public MyLogger getLogger() {
        return _logger;
    }
    
    public void ConnectClient()
    {
        if(dbean == null)
        {
            dbean = new DepartBean();
            dbean.addDepartListener(this);
            dbean.init();
        }
        dbean.Connect();
    }
    
    public void DisconnectClient()
    {
        if(dbean != null)
        {
            dbean.setEnMarche(false);
            dbean.Deconnect();
        }
    }
    
    public void SendDepart(MoyenDeTransportSurEau mte)
    {
        dbean.setBateauEnDepart(mte);
        if(dbean.getState() == Thread.State.NEW)
            dbean.start();
    }

    @Override
    public void OnDepartReturn(DepartEvent e) {
        System.out.println("CAPITAINERIE A RECU: " + e.getResult());
    }
    
}
