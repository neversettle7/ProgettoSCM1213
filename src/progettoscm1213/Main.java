package progettoscm1213;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Giovanni Dini
 */
public class Main {
    public static int quantum;
    public static int npacchetti;
    public static final ReentrantLock queue = new ReentrantLock(true);
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException
    {
        
        System.out.println("/******************************************/");
        System.out.println("* PROGRAMMA DI SIMULAZIONE DI UN ALGORITMO *");
        System.out.println("*           DEFICIT ROUND ROBIN            *");
        System.out.println("/******************************************/");
        System.out.println("*    PROGETTO DI SISTEMI DI COMUNICAZIONE  *");
        System.out.println("*       MULTIMEDIALI - A.A. 2012/2013      *");
        System.out.println("/******************************************/");
        System.out.println("*    GIOVANNI DINI - MATRICOLA 232274      *");
        System.out.println("/******************************************/");
        System.out.println("\n");
        System.out.println("Il programma simula un algoritmo di routing Deficit Round Robin.");
        System.out.println("Vi verrà chiesto quante code generare e la lunghezza del quanto di tempo.");
        System.out.println("Il numero dei pacchetti per ogni coda verrà poi generato casualmente (compreso tra 1 e 10) ");
        System.out.println("così come il tempo a loro necessario (compreso tra 1 e 1000).");
        System.out.println("Per inserire un numero di pacchetti fissi per ogni coda, è sufficiente ");
        System.out.println("decommentare la parte relativa nel codice sorgente.");
        System.out.println();
        
        // Quante code genero?
        Scanner input = new Scanner(System.in);
        System.out.println("Quante code devo generare?");
        while (!input.hasNextInt())
        {
            System.out.printf("Hai inserito un input non valido. Ricordati di aggiungere solo numeri. Ritenta.\n");
            input.next();
        }
        int ncode = input.nextInt();
        
        /*
         * DECOMMENTARE SE SI VUOLE DECIDERE QUANTI PACCHETTI GENERARE
         * Quanti pacchetti genero?
         * System.out.println("Quanti pacchetti devo generare per ogni coda?");
         * while (!input.hasNextInt())
         * {
         * System.out.printf("Hai inserito un input non valido. Ricordati di aggiungere solo numeri. Ritenta.\n");
         * input.next();
         * }
         * npacchetti = input.nextInt();
         */
        
        // Quanto sarà il quantum?
        System.out.println("Quanto è lungo il quanto di tempo?");
        while (!input.hasNextInt())
        {
            System.out.printf("Hai inserito un input non valido. Ricordati di aggiungere solo numeri. Ritenta.\n");
            input.next();
        }
        quantum = input.nextInt();
        
        // Chiudiamo lo scanner
        input.close();
        
        // Genero code (che genereranno i pacchetti)
        Coda coda[] = new Coda[ncode];
        for (int i = 0; i < ncode; i++){
            coda[i] = new Coda(i+1);
            coda[i].start();
        }
    }
}