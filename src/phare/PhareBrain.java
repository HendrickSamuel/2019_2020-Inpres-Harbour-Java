/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 26/04/2020                        */
/******************************************************/
package phare;

import HarbourGlobal.MyAppProperties;
import HarbourGlobal.MyLogger;
import HarbourGlobal.PropertiesEnum;
import java.util.Vector;
import javax.swing.JCheckBox;
import javax.swing.JList;
import network.NetworkBasicClient;
import network.NetworkBasicServer;
import phare.beans.BoatBean;
import phare.beans.KindOfBoatBean;
import phare.beans.NotifyBean;

public class PhareBrain {
    //<editor-fold defaultstate="collapsed" desc="Variables">
    
    MyAppProperties _mMyAppProperties = null;
    
    //<editor-fold defaultstate="collapsed" desc="Client">
    private NetworkBasicClient _nbc = null;
    private boolean _estConnecte = false;
    private Vector<String> _bateauxEnAttente;
    private String _bateauIdentifie;
    private int PORT_SERVICE = 50000;
    private MyLogger _logger;
    private String _reponseBateauIdentifie;
    private String _reponseBateauEntreRade;
    private String _amarrageEnCours;
    private String _emplacementEnCours;
    private final String _delimiteur = "/";
    public static final String ENVOI_IDENTIFICATION = "1";
    public static final String RECEP_IDENTIFICATION = "2";
    public static final String ENVOI_ENTRE_RADE = "3";
    public static final String RECEP_ENTRE_RADE = "4";
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Serveur">
    private NetworkBasicServer _nbs = null;
    private int PORT_DEPART = 50001;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="BeansGenerator">
    private KindOfBoatBean _KOBbean = null;
    private NotifyBean _notifyBean = null;
    private BoatBean _boatBean = null;
    //</editor-fold>
    
    //</editor-fold>
  
    //<editor-fold defaultstate="collapsed" desc="Constructeur">
    public PhareBrain()
    {
        //<editor-fold defaultstate="collapsed" desc="Init des variables">
        _mMyAppProperties = new MyAppProperties();
        PORT_SERVICE = Integer.parseInt(_mMyAppProperties.getPropertie(PropertiesEnum.PortArrive));
        PORT_DEPART = Integer.parseInt(_mMyAppProperties.getPropertie(PropertiesEnum.PortDepart));
        
        this.setBateauxEnAttente(new Vector<String>());
        this.setLogger(new MyLogger(_mMyAppProperties.getPropertie(PropertiesEnum.FileLogPhare)));
        //</editor-fold>
        
        _KOBbean = new KindOfBoatBean();
        _notifyBean = new NotifyBean();
        _boatBean = new BoatBean();
    }
    //</editor-fold>


    //<editor-fold defaultstate="collapsed" desc="Méthodes">
    //<editor-fold defaultstate="collapsed" desc="Getters">
    public NetworkBasicClient getNbc() {
        return _nbc;
    }
    /*-----------------------------------------------------------*/
    public Vector<String> getBateauxEnAttente() {
        return _bateauxEnAttente;
    }
    /*-----------------------------------------------------------*/
    public String getDelimiteur() {
        return _delimiteur;
    }
    /*-----------------------------------------------------------*/
    public String getBateauIdentifie() {
        return _bateauIdentifie;
    }
    /*-----------------------------------------------------------*/
    public MyLogger getLogger() {
        return _logger;
    } 
    /*-----------------------------------------------------------*/
    public boolean EstConnecte() {
        return _estConnecte;
    }
    /*-----------------------------------------------------------*/
    public String getReponseBateauIdentifie() {
        return _reponseBateauIdentifie;
    }
    /*-----------------------------------------------------------*/
    public String getReponseBateauEntreRade() {
        return _reponseBateauEntreRade;
    }
    /*-----------------------------------------------------------*/
    public String getAmarrageEnCours() {
        return _amarrageEnCours;
    }
    /*-----------------------------------------------------------*/
    public String getEmplacementEnCours() {
        return _emplacementEnCours;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Setters">
    public void setNbc(NetworkBasicClient nbc){
        this._nbc = nbc;
    }
    /*-----------------------------------------------------------*/
    public void setBateauxEnAttente(Vector<String> _bateauxEnAttente) {
        this._bateauxEnAttente = _bateauxEnAttente;
        this._bateauxEnAttente.add("Peche / CH");
        this._bateauxEnAttente.add("Plaisance / UK");
        this._bateauxEnAttente.add("Plaisance / FR");
        this._bateauxEnAttente.add("Peche / BE");
    }
    /*-----------------------------------------------------------*/
    public void setBateauIdentifie(String _bateauIdentifie) {
        this._bateauIdentifie = _bateauIdentifie;
    }
    /*-----------------------------------------------------------*/
    public void setLogger(MyLogger _logger) {
        this._logger = _logger;
    }
    /*-----------------------------------------------------------*/
    public void setEstConnecte(boolean estConnecte) {
        this._estConnecte = estConnecte;
    }
    /*-----------------------------------------------------------*/
    public void setAmarrageEnCours(String amarrageEnCours) {
        this._amarrageEnCours = amarrageEnCours;
    }
    /*-----------------------------------------------------------*/
    public void setEmplacementEnCours(String emplacementEnCours) {
        this._emplacementEnCours = emplacementEnCours;
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Publique">
    
    //<editor-fold defaultstate="collapsed" desc="NetworkClient">
    public void connexionServeur()
    {
        System.out.println("1 :" + this.getNbc());
        if(this._nbc == null)
        {
            this.setNbc(new NetworkBasicClient("localhost", PORT_SERVICE));
            System.out.println(this.Now() + " PhareBrain | le phare est (init) connecté au serveur");
            this._estConnecte = true; // utile ? 
            System.out.println("2 :" + this.getNbc());
            
            /*catch(java.lang.NullPointerException e)
            {
                this._nbc = null;
                System.out.println(this.Now() + "PhareBrain NULL| le phare ne peut "
                        + "pas se connecter au serveur, ce dernier n'est pas lancé");
                System.out.println(e.getMessage());
                this._estConnecte = false;
            }
            catch (java.net.ConnectException e) {
                this._nbc = null;
                System.out.println(this.Now() + "PhareBrain ConnectException | le phare ne peut "
                        + "pas se connecter au serveur, ce dernier n'est pas lancé");
                System.out.println(e.getMessage());
                this._estConnecte = false;
            }*/
        }
        else
            System.out.println(this.Now() + " PhareBrain | le phare est déjà connecté au serveur");
    }
    /*-----------------------------------------------------------*/
    public void deconnexionServeur()
    {
        if(this._nbc != null)
        {
            this.getNbc().setEndSending();
            this._nbc = null;
            this._estConnecte = false; // utile ? 
            System.out.println(this.Now() + " PhareBrain | le phare est deconnecté au serveur");
        }
        else
        {
            System.out.println(this.Now() + " PhareBrain | le phare n'est pas connecté au serveur");
        }
    }
    /*-----------------------------------------------------------*/
    public String Now()
    {
        return _logger.Now();
    }
    /*-----------------------------------------------------------*/
    //BateauQuiAEteIdentifie - 1
    public void envoiMsg(String typeEnvoi, String nomBateau , String Type , String pavillon , String longueur)
    { 
        _reponseBateauIdentifie = this._nbc.sendString(typeEnvoi + "/" + nomBateau + "/" + Type + "/" + pavillon + "/" + longueur);
    }
    /*-----------------------------------------------------------*/
    //BateauEntreRade - 3
    public void envoiMsgRade(String typeEnvoi, String msg)
    { 
        _reponseBateauEntreRade = this._nbc.sendString(typeEnvoi + "/" + msg);
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="NetworkServer">
    public void StartServeur(JCheckBox check){
        if(!IsServeurRunning())
        {
            _nbs = new NetworkBasicServer(PORT_DEPART, check);
            _logger.Write("PhareBrain","Démarrage du serveur"); 
            
        }
    }
    
    public void ArreterServeur()
    {
        if(IsServeurRunning())
        {
            _nbs.setEndReceiving();
            _nbs = null;
            _logger.Write("PhareBrain","Arret du serveur");
        }
    }
        
    public boolean IsServeurRunning()
    {
        return _nbs != null;
    }
    
    public void sendMessage(String message)
    {
        _logger.Write("PhareBrain","Envoi du message: " + message);
        _nbs.sendMessage(message);
    }
    
    public String ReadMessage()
    {
        if(IsServeurRunning())
        {
            String message = _nbs.getMessage();
            return message;
        }
        else
            return "";
    }
    //</editor-fold>.
    
    public void InitBeans(JList liste)
    {
        _notifyBean.setJListe(liste);
        _boatBean.AddBoatListener(_notifyBean);
        _KOBbean.AddPropertyChangedListener(_boatBean);
        _KOBbean.setDelai(Integer.parseInt(_mMyAppProperties.getPropertie(PropertiesEnum.TempsSommeil)));
        _KOBbean.setMultiplePeche(Integer.parseInt(_mMyAppProperties.getPropertie(PropertiesEnum.SimulationPeche)));
        _KOBbean.setMultiplePlaisance(Integer.parseInt(_mMyAppProperties.getPropertie(PropertiesEnum.SimulationPlaisance)));
        _notifyBean.init();
        _KOBbean.init();
        _KOBbean.run();
    }
    //</editor-fold>
    
    //</editor-fold>
    
}
