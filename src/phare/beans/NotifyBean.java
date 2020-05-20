package phare.beans;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class NotifyBean implements BoatListener {
    
    private DefaultListModel _liste = null;
    private boolean _running = false;
    
    public NotifyBean()
    {
        this(null);
    }
    
    public NotifyBean(JList liste)
    {
        if(liste != null)
            _liste = (DefaultListModel)liste.getModel();
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
            JOptionPane.showMessageDialog(null, "Bateau en approche", "Titre", JOptionPane.INFORMATION_MESSAGE);
            
            if(_liste != null)
            {
                String nouveau = e.getType()+"/"+e.getPavillon();
                _liste.addElement(nouveau);
            }
        }
        else
            System.out.println("Bean mal configuré");
        
    }
    
}
