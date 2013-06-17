/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gioggi2002
 */
public class Queue extends Thread {
    private int id;
    private final int nthreads;
    public ReentrantLock service = new ReentrantLock();
    
    public Queue(int id, int nthreads){
        this.id = id;
        this.nthreads = nthreads;
    }
    
    @Override
    public void run() {
        //System.out.println("Sono la lista #"+this.id+" e sto per generare "+nthreads+" pacchetti.");
        ArrayList<Pacchetto> coda = new ArrayList();
        Pacchetto p[] = new Pacchetto[nthreads];
        int i = 0;
        while (i < nthreads){
            p[i] = new Pacchetto(id+1, i+1);
            coda.add(p[i]);
            i++;
        }
        System.out.println("Generazione della coda "+(id)+" conclusa, "+nthreads+" pacchetti caricati.");
        i = 0;
        int y = 0;
        while (i < nthreads){
            service.lock();
            try {
                boolean esito = p[i].verifica(p[i].dimensione);
                if (esito == true){
                    i++;
                }
            } finally {
                service.unlock();
            }
        }
        System.out.println("Sono la lista #"+this.id+" e termino la generazione dei pacchetti.");
    }
    
    public void servizio() {
        for (int i = 0; i < nthreads; i++){
            
        }
    }
}
