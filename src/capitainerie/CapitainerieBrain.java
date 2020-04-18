package capitainerie;

import Amarrages.*;
import java.util.Vector;


public class CapitainerieBrain {

    public Vector<Amarrage> ListeAmarrages;
    
    private String _connectedUser;
    private boolean _isUserConnected;
    
    public CapitainerieBrain() {
        ListeAmarrages = new Vector<Amarrage>();
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
    
    
    
}
