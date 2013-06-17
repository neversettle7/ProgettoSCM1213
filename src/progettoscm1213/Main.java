/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author gioggi2002
 */
public class Main {
    public static int quantum;
    public static int npacchetti;
    public static final ReentrantLock queue = new ReentrantLock(true);
    public static final ReentrantLock start = new ReentrantLock();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        // Quante code genero?
        Scanner input = new Scanner(System.in);
        System.out.println("Quante code devo generare?");
        int ncode = input.nextInt();
        
        /* 
         * DECOMMENTARE SE SI VUOLE DECIDERE QUANTI PACCHETTI GENERARE
         * Quanti pacchetti genero?
         * System.out.println("Quanti pacchetti devo generare per ogni coda?");
         * npacchetti = input.nextInt();
         */
        
        // Quanto sarà il quantum?
        System.out.println("Quanto è il quanto di tempo?");
        quantum = input.nextInt();
        
        // Genero code (che genereranno i pacchetti)
        queue.lock();
        Coda coda[] = new Coda[ncode];
        for (int i = 0; i < ncode; i++){
            coda[i] = new Coda(i+1);
            coda[i].start();
        }
        queue.unlock();
    }
}