package capitainerie.Beans;

import VehiculesMarins.MoyenDeTransportSurEau;
import java.io.Serializable;
import static java.lang.Thread.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.NetworkBasicClient;

public class DepartBean extends Thread implements Serializable
{
    private MoyenDeTransportSurEau _bateauxEnDepart;
    private NetworkBasicClient _nbc = null;
    private boolean _estConnecte = false;
    private final int PORT_SERVICE = 50001;
    
    private boolean _enMarche = false;
    
    private Vector<DepartListener> _DepartListeners;

    public DepartBean() {
        //constructeur par défaut
        _DepartListeners = new Vector<>();
    }
    
    public void Connect()
    {
        _nbc = new NetworkBasicClient("localhost", PORT_SERVICE);
    }
    
    public void Deconnect()
    {
        _nbc.setEndSending();
    }
    
    private void fireDepartEvent(boolean validiteDepart)
    {
        DepartEvent de = new DepartEvent(this, validiteDepart);
        for(int i = 0; i < _DepartListeners.size(); i++ )
        {
            DepartListener dl = (DepartListener)_DepartListeners.elementAt(i); 
            dl.OnDepartReturn(de);
        }
    }
    
    public void addDepartListener(DepartListener dl)
    {
        if (! _DepartListeners.contains(dl)) _DepartListeners.add(dl);
    }

    public void setBateauEnDepart(MoyenDeTransportSurEau mte)
    {
        _bateauxEnDepart = mte;
    }
    
    public void setEnMarche(boolean enMarche) {
        this._enMarche = enMarche;
    }
    
    public boolean isEnMarche()
    {
        return this._enMarche;
    }
    
    public void init()
    { 
        this.setEnMarche(true);
    }
    
    @Override
    public  synchronized  void run() {
        while(this.isEnMarche())
        {
            while(_bateauxEnDepart == null)
            {
                try {
                    sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DepartBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            String reponse = _nbc.sendString(_bateauxEnDepart.toString());
            if(reponse.compareTo("true")== 0)
                fireDepartEvent(true); // true si depart ok false si depart pas ok 
            else
                fireDepartEvent(false);
            
            _bateauxEnDepart = null;
        }
        
            System.out.println("je ne peux pas démarrer");
            this.Deconnect();
            Thread.currentThread().interrupt();
    }
}
