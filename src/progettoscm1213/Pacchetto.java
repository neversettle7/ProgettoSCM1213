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
    private int idlista;
    
    public Pacchetto(int idlista, int id){
        this.idlista = idlista;
        this.id = id;
        this.dimensione = generaDimensione();
    }
    
    @Override
    public void run() {
        //boolean esito = verifica(this.dimensione);
        //this.dimensione = generaDimensione();
        //System.out.println("Sono il thread "+this.nome);
        //System.out.println("C"+this.idlista+"P"+this.id+" - Dimensione: "+dimensione);
        //System.out.println("C"+this.idlista+"P"+this.id+" servito ("+this.dimensione+")");
    }
    
    public boolean verifica(int dimensione) {
        if(dimensione <= Main.quantum){
            System.out.println("C"+this.idlista+"P"+this.id+" viene servito subito. (D="+this.dimensione+" Q="+Main.quantum+")");
            return true;
        } else {
            System.out.println("C"+this.idlista+"P"+this.id+" deve aspettare. (D="+this.dimensione+" Q="+Main.quantum+")");
            return false;
        }
    }
    
    public int generaDimensione(){
        Random randomgen = new Random();
        int dimension = randomgen.nextInt(500);
        return dimension;
    }
}
