/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package progettoscm1213;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author gioggi2002
 */
public class Coda extends Thread {
    private int quantumattuale;
    private int contatoreripetizioni;
    private int contatorepacchetti = 1;
    private int id;
    
    public Coda(int id){
        this.id = id;
    }
    
    @Override
    public void run() {
        // Genero pacchetti
        ArrayList<Pacchetto> coda = new ArrayList();
        coda = generaPacchetti(coda, Main.npacchetti);
        // Controllo se coda vuota o meno
        // System.out.println("La coda contiene "+coda.size()+" elementi.");
        // Settiamo il quantum
        quantumattuale = Main.quantum;
        System.out.println("--Coda "+this.id+" in partenza con "+coda.size()+" elementi.");
        // Fin quando i pacchetti non sono finiti
        while (coda.isEmpty() == false){
            // Eseguo operazioni sulla coda
            service(coda);
        }
        
        // Termino
        System.out.println("Coda "+this.id+" ha terminato gli elementi.");
    }
    
    public void service(ArrayList<Pacchetto> coda){
        // Prendo controllo
        Main.queue.lock();
        // Quantum attuale = quantum * contatoreripetizioni delle ripetizioni
        if (contatoreripetizioni > 0){
            quantumattuale = Main.quantum * (contatoreripetizioni+1);
        }
        // Controllo se dimensioni pacchetto >= quanto di tempo
        if (coda.get(0).dimensione <= quantumattuale){
            int dimensione = coda.get(0).dimensione;
            // Eseguo pacchetto
            System.out.println("C"+this.id+"P"+contatorepacchetti+" servito. (D="+dimensione+" - Q="+quantumattuale+")");
            // Scarto pacchetto
            
            // Resetto quantum
            quantumattuale = Main.quantum;
            
            // Rimuovo il pacchetto appena passato
            coda.remove(0);
            // Azzero il contatore delle ripetizioni
            contatoreripetizioni = 0;
            // Passo a elemento successivo della lista
            contatorepacchetti++;
            //System.out.println("La coda contiene ancora "+coda.size()+" elementi.");
            // Cedo controllo
            Main.queue.unlock();
        } else {
            int dimensione = coda.get(0).dimensione;
            // Aumento contatoreripetizioni per segnalare che avrò un multiplo del quantum al prossimo giro
            System.out.println("C"+this.id+"P"+contatorepacchetti+" NON servito. (D="+dimensione+" - Q="+quantumattuale+")");
            contatoreripetizioni++;
            // Cedo controllo
            Main.queue.unlock();
        }
    }
    
    public ArrayList generaPacchetti(ArrayList<Pacchetto> coda, int npacchetti) {
        
        /*
         * DECOMMENTARE SE SI VUOLE DECIDERE QUANTI PACCHETTI GENERARE (anche nella main)
         * (E COMMENTARE LE RIGHE SOTTO)
         * Genero pacchetti
         * Pacchetto p[] = new Pacchetto[npacchetti];
         */
        
        // Genero pacchetti random
        Random randomgen = new Random();
        npacchetti = randomgen.nextInt(10);
        Pacchetto p[] = new Pacchetto[npacchetti];
        for (int i = 0; i < npacchetti; i++){
            int dimensione = generaDimensione();
            p[i] = new Pacchetto(dimensione);
            //System.out.println(dimensione);
            // Inserisco pacchetti in coda
            coda.add(p[i]);
        }
        
        // Ritorno coda
        return coda;
    }
    
    public int generaDimensione() {
        // Generiamo una dimensione random per i pacchetti
        Random randomgen = new Random();
        int dimension = randomgen.nextInt(500);
        return dimension;
    }
}