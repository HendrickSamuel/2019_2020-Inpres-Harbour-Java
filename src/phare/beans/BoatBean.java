package phare.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.Vector;

public class BoatBean implements PropertyChangeListener  {

    private Vector<BoatListener> _boatListeners = null;
    private String[] _pavillons = {"CH", "UK", "BE", "US", "ID", "BR", "AR", "ES"
        , "FR", "DE", "NL", "LU", "CN", "IN", "CA", "AU", "LK", "CU", "DK", "MZ"
        , "FI", "NO", "SL", "PY", "IE", "VA", "MH", "ME", "SZ", "FJ", "CL", "MG"
        , "PE", "TH", "EG", "JM", "IS", "PK", "NG", "BD", "RU", "JP", "MX", "PH"
        , "CD", "ZA", "IT", "KR", "SE", "DZ", "MA"}; 
// liste des pavillons disponibles
    
    public BoatBean() 
    {
        _boatListeners = new Vector<BoatListener>();
    }
    
    public void AddBoatListener(BoatListener l)
    {
        if(!_boatListeners.contains(l))
            _boatListeners.add(l);
    }
    
    private void fireBoatEvent(String type, String pavillon) // appel de tous les listeners
    {
        BoatEvent be = new BoatEvent(this, type, new Date(), pavillon);
        for(int i = 0; i < _boatListeners.size(); i++ )
        {
            BoatListener dl = (BoatListener)_boatListeners.elementAt(i); 
            dl.OnBoatEvent(be);
        }
    }
            
    @Override
    public void propertyChange(PropertyChangeEvent evt) { // reception de l'evenement par KindOfBoatBean
        
        String type = evt.getNewValue().toString(); // recuperation type dans l'event
        
        int borneInferieure = 0, borneSuperieure = _pavillons.length;
        int random = (int)(borneInferieure +     Math.random()*(borneSuperieure - borneInferieure));
        
        String pav = _pavillons[random]; // recuperation pavillon au hasard
        fireBoatEvent(type , pav);
    }
}
