/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capitainerie.Beans;

/**
 *
 * @author hydro
 */
public class DepartManager implements DepartListener {

    public DepartManager() {
    }
    
    @Override
    public void OnDepartReturn(DepartEvent e) {
        System.out.println("réveillé par un signal");
        System.out.println(e.getResult());
    } 
}
