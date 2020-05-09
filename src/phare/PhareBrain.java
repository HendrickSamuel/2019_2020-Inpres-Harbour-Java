/******************************************************/
/*Auteur: Hendrick Samuel & Khamana Benedict          */
/*Groupe: 2203                                        */
/*Application: Inpres Harbour                         */
/*Date de creation: 26/04/2020                        */
/******************************************************/
package phare;

import HarbourGlobal.MyLogger;
import java.util.Vector;
import network.NetworkBasicClient;

/**
 *
 * @author benka
 */
public class PhareBrain {
    //<editor-fold defaultstate="collapsed" desc="Variables">
    private NetworkBasicClient _nbc = null;


    private boolean _estConnecte = false;
    private Vector<String> _bateauxEnAttente;
    private String _bateauIdentifie;
    private final int PORT_SERVICE = 50000;
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
  
    //<editor-fold defaultstate="collapsed" desc="Constructeur">
    public PhareBrain()
    {
        //<editor-fold defaultstate="collapsed" desc="Init des variables">
        this.setBateauxEnAttente(new Vector<String>());
        this.setLogger(new MyLogger());
        //</editor-fold>
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
    public void connexionServeur()
    {
        System.out.println("1 :" + this.getNbc());
        if(this._nbc == null)
        {
            this.setNbc(new NetworkBasicClient("localhost", PORT_SERVICE));
            System.out.println(this.Now() + " PhareBrain | le phare est (init) connecté au serveur");
            this._estConnecte = true;
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
            this._estConnecte = false;
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
    
    //</editor-fold>


}
