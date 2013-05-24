/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.Random;

/**
 *
 * @author gioggi2002
 */
public class Pacchetto implements Runnable {
    public int dimensione;
    
    @Override
    public void run() {
        dimensione = generaDimensione();
        System.out.println("Dimensione generata: "+dimensione);
    }
    
    public int generaDimensione(){
        Random randomgen = new Random();
        int dimension = randomgen.nextInt(1000);
        return dimension;
    }
}
