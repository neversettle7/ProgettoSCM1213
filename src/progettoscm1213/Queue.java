/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gioggi2002
 */
public class Queue extends Thread {
    private int id;
    private final int nthreads;
    
    public Queue(int id, int nthreads){
        this.id = id;
        this.nthreads = nthreads;
    }
    
    @Override
    public void run() {
        //System.out.println("Sono la lista #"+this.id+" e sto per generare "+nthreads+" pacchetti.");
        ArrayList coda = new ArrayList();
        Pacchetto p[] = new Pacchetto[nthreads];
        for (int i = 0; i < nthreads; i++){
            p[i] = new Pacchetto(id+1, i);
            coda.add(p[i]);
            p[i].start();
            try {
                this.sleep(50);
            } catch (InterruptedException ex) {
                Logger.getLogger(Queue.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Coda: "+(id+1)+" - Pacchetto: "+i+" - Dimensione: "+p[i].dimensione);
        }
        //System.out.println("Sono la lista #"+this.id+" e la mia coda è di "+coda.size()+" elementi.");
        //System.out.println("Sono la lista #"+this.id+" e termino.");
    }

}
