/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gioggi2002
 */
public class Main {
    public static ReentrantLock queue;
    public static int quantum;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ReentrantLock queue = new ReentrantLock(true);
        
        // Quante code genero?
        Scanner input = new Scanner(System.in);
        System.out.println("Quante code devo generare?");
        int ncode = input.nextInt();
        
        System.out.println("Quanti thread devo generare per ogni coda?");
        int nthreads = input.nextInt();
        
        System.out.println("Quanto è il quanto di tempo? (i pacchetti avranno una dimensione"
                + " massima generata tra 1 e 500ms");
        quantum = input.nextInt();
        
        // Genero code
        // Genero x pacchetti nella coda
        System.out.println("Sto per generare "+ncode+" code con "+nthreads+" pacchetti in ognuna.");
        ArrayList listacode = new ArrayList();
            Queue q[] = new Queue[ncode];
            for (int i = 0; i < ncode; i++){
                q[i] = new Queue(i+1, nthreads);
                listacode.add(q[i]);
                q[i].start();
            try {
                q[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
        // Faccio partire le liste
        for (int i = 0; i < ncode; i++){
                q[i] = new Queue(i+1, nthreads);
                listacode.add(q[i]);
                q[i].servizio();
            }
        
        // Termino la main
        System.out.println("*** La main termina ***");
    }
}