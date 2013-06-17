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
public class Pacchetto extends Thread {
    public int dimensione;
    private int id;
    private final int idlista;
    
    public Pacchetto(int idlista, int id){
        this.idlista = idlista;
        this.id = id;
    }
    
    @Override
    public void run() {
        dimensione = generaDimensione();
        //System.out.println("Sono il thread "+this.nome);
        //System.out.println("Thread "+this.id+" dalla coda "+this.idlista+" - Attesa generata: "+dimensione);
        //System.out.println("Aspetto "+dimensione+" ms");
        try {
            Thread.sleep(dimensione);
        } catch (InterruptedException ex) {
            Logger.getLogger(Pacchetto.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Thread "+this.id+" servito.");
    }
    
    public int generaDimensione(){
        Random randomgen = new Random();
        int dimension = randomgen.nextInt(500);
        return dimension;
    }
}
