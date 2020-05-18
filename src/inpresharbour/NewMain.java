/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inpresharbour;

import java.util.Scanner;
import network.NetworkBasicServer;

/**
 *
 * @author hydro
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        NetworkBasicServer nbs = new NetworkBasicServer(50000, null);
        System.out.println("Please input a line");
        String line = scanner.nextLine();
        
        String msg = nbs.getMessage();
        nbs.sendMessage(msg);
        
        System.out.println("Please input a line");
        line = scanner.nextLine();
    }
    
}
