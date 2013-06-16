/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author gioggi2002
 */
public class ProgettoSCM1213 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Quante code genero?
        Scanner input = new Scanner(System.in);
        /*System.out.println("Quante code devo generare?");
         * int ncode = input.nextInt();*/
        
        System.out.println("Quanti thread devo generare per ogni coda?");
        int nthreads = input.nextInt();
        System.out.println("Sto per generare "+nthreads+" threads per ogni coda.");
        
        // Genero una HashMap in cui inserire le code (per farvi riferimento)
        Map liste = new HashMap();
        
        // Genero code
        // Genero x pacchetti nella coda
        System.out.println("Sto per generare 5 code con "+nthreads+" processi in ognuna.");
        List lista1 = new ArrayList();
        List lista2 = new ArrayList();
        List lista3 = new ArrayList();
        List lista4 = new ArrayList();
        for (int y = 1; y != nthreads+1; y++){
            Pacchetto p = new Pacchetto("Pacchetto #"+y);
            Thread t = new Thread(p);
            lista1.add(t);
            lista2.add(t);
            lista3.add(t);
            lista4.add(t);
        }
        // Prendo il primo pacchetto nella coda e lo faccio eseguire
        System.out.println("Lista1 size: "+lista1.size());
    }
}