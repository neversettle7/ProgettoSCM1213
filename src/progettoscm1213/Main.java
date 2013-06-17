/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author gioggi2002
 */
public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // Quante code genero?
        Scanner input = new Scanner(System.in);
        System.out.println("Quante code devo generare?");
        int ncode = input.nextInt();
        
        System.out.println("Quanti thread devo generare per ogni coda?");
        int nthreads = input.nextInt();
        
        System.out.println("Quanto è il quanto di tempo? (i pacchetti avranno una dimensione"
                + " massima generata tra 1 e 500ms");
        int quantum = input.nextInt();
        Util.clearConsole();
        
        // Genero una HashMap in cui inserire le code (per farvi riferimento)
        Map liste = new HashMap();
        
        // Genero code
        // Genero x pacchetti nella coda
        System.out.println("Sto per generare "+ncode+" code con "+nthreads+" pacchetti in ognuna.");
        ArrayList listacode = new ArrayList();
            Queue q[] = new Queue[ncode];
            for (int i = 0; i < ncode; i++){
                q[i] = new Queue(i+1, nthreads);
                listacode.add(q[i]);
                q[i].start();
            }
        // 
        
    }
}