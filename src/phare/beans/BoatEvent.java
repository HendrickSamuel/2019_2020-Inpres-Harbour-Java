/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phare.beans;

import java.util.Date;
import java.util.EventObject;


public class BoatEvent extends EventObject {
    
    private String _type;
    private Date _date;
    private String _pavillon;
    
    public BoatEvent(Object source) {
        super(source);
    }
    
    public BoatEvent(Object source, String type, Date date, String pavillon)
    {
        this(source);
        _type = type;
        _date = date;
        _pavillon = pavillon;
    }
    
    public String Affiche()
    {
        return _type+"/"+_pavillon+"/"+_date;
    }
    
    public String getType()
    {
        return _type;
    }
    
    public String getPavillon()
    {
        return _pavillon;
    }
    
    public Date getDate()
    {
        return _date;
    }
    
}
