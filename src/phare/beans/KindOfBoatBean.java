package phare.beans;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Vector;
import javax.swing.JList;

public class KindOfBoatBean implements UtilisateurNombre {
    
    private ThreadRandomGenerator _randomGenerator;
    private boolean _running;
    private String _type = null;
    
    private int _tiragePlaisance = 7;
    private int _tiragePeche = 17;
    
    private int _delai = 1;
    
    private PropertyChangeSupport GestProp = new PropertyChangeSupport(this); 
    
    public KindOfBoatBean()
    {
         this(7, 17, 5);
    }
    
    public KindOfBoatBean(int tiragePlaisance, int tiragePeche, int delai)
    {
        _tiragePeche = tiragePeche;
        _tiragePlaisance = tiragePlaisance;
        _delai = delai;
    }
    
    public void AddPropertyChangedListener(PropertyChangeListener l)
    {
        GestProp.addPropertyChangeListener(l);
    }
    
    public void setType(String type)
    {
        GestProp.firePropertyChange("Type", _type, type); // envoi ancienne et nouvelle valeur
        _type = type;
    }
    
    public void setDelai(int delai)
    {
        _delai= delai;
    }
    
    public void setMultiplePeche(int peche)
    {
     _tiragePeche = peche;   
    }
    
    public void setMultiplePlaisance(int plaisance)
    {
        _tiragePlaisance = plaisance;
    }
    
    public String getType()
    {
        return _type;
    }
    
    public void init()
    {
        if(!IsRunning())
        {
            _running = true;
        }
        else
            System.out.println("Bean deja en cours");
    }
        
    public boolean IsRunning()
    {
        return _running;
    }
    
    public void run()
    {
        if(IsRunning())
        {
            _randomGenerator = new ThreadRandomGenerator(this, 0, 100,2 , _delai);
            _randomGenerator.start();
        }
        else
            System.out.println("Bean non initialisé");
    }
    
    @Override
    public String getIdentifiant() {
        return "ID";
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void traiteNombre(int n) { // reception du ThreadRandom
        int borneInferieure = 0, borneSuperieure = 20;
        int random = (int)(borneInferieure +     Math.random()*(borneSuperieure - borneInferieure));
        
        System.out.println("Nombre apres réveil = " +random);
        
        if(random % _tiragePeche == 0)
        {
            setType("PECHE");
        }
        else
        if(random % _tiragePlaisance == 0)
        {
            setType("PLAISANCE");
        }
    }
    
}
