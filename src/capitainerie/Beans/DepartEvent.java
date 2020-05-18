/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitainerie.Beans;

import java.util.EventObject;

/**
 *
 * @author hydro
 */
public class DepartEvent extends EventObject {
    
    private boolean _result;
    
    public DepartEvent(Object source) {
        super(source);
        _result = false;
    }
    
    public DepartEvent(Object source, boolean departvalide) {
        super(source);
        _result = departvalide;
    }
    
    public boolean getResult()
    {
        return _result;
    }
   
    
}
