/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gioggi2002
 */
public class ProgettoSCM1213 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // Genero numero code
        List queue1 = new ArrayList();
        List queue2 = new ArrayList();
        List queue3 = new ArrayList();
        List queue4 = new ArrayList();
        
        // Genero numero processi in coda
        
        
        // Prendo quanto di tempo in input
        
        
        Pacchetto p = new Pacchetto();
        Thread t = new Thread(p);
        t.start();
    }
}
