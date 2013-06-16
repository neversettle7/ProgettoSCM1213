/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gioggi2002
 */
public class Pacchetto implements Runnable {
    public int dimensione;
    private String nome;
    
    public Pacchetto(String nome){
        this.nome = nome;
    }
    
    @Override
    public void run() {
        dimensione = generaDimensione();
        //System.out.println("Sono il thread "+this.nome);
        System.out.println("Thread "+this.nome+" - Attesa generata: "+dimensione);
        //System.out.println("Aspetto "+dimensione+" ms");
        try {
            Thread.sleep(dimensione);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pacchetto.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread "+this.nome+" muore.");
    }
    
    public int generaDimensione(){
        Random randomgen = new Random();
        int dimension = randomgen.nextInt(500);
        return dimension;
    }
}
