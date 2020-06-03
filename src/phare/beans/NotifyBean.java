package phare.beans;

import HarbourGlobal.MyAppProperties;
import HarbourGlobal.MyLogger;
import HarbourGlobal.PropertiesEnum;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class NotifyBean implements BoatListener {
    
    private DefaultListModel _liste = null;
    private boolean _running = false;
    private MyLogger _logger = null;
    private MyAppProperties _MyAppProperties = null;
    
    
    public NotifyBean()
    {
        this(null);
    }
    
    public NotifyBean(JList liste)
    {
        if(liste != null)
            _liste = (DefaultListModel)liste.getModel();
        
        _MyAppProperties = new MyAppProperties();
       _logger = new MyLogger(_MyAppProperties.getPropertie(PropertiesEnum.FileLogPhare));
    }
    
    public void setJListe(JList liste)
    {
        if(liste != null)
            _liste = (DefaultListModel)liste.getModel();
        else
            _liste = null;
    }
    
    public void init()
    {
        _running = true;
    }
    
    public void stop()
    {
        _running = false;
    }
    
    public boolean IsRunning()
    {
        return _running;
    }
    
    @Override
    public void OnBoatEvent(BoatEvent e) {
        if(IsRunning())
        {
            System.out.println("EVENT RECU");
            System.out.println("event recu" + e.Affiche());
            
            if(_liste != null)
            {
                JOptionPane.showMessageDialog(null, "Bateau en approche", "Nouveau bateau !", JOptionPane.INFORMATION_MESSAGE);
                String nouveau = e.getType()+"/"+e.getPavillon();
                _liste.addElement(nouveau);
                _logger.Write("NotifyBean", "Arrivée du bateau: " + nouveau);
            }
        }
        else
            _logger.Write("NotifyBean", "Bean mal configuré n'a pas pu démarrer ");
        
    }
    
}
