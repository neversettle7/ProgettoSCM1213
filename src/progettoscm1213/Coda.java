package progettoscm1213;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Giovanni Dini
 */
public class Coda extends Thread {
    private int quantumattuale;
    private int contatorepacchetti = 1;
    private int id;
    private int deficit = 0;
    private int deficitiniziale = 0;
    
    public Coda(int id){
        this.id = id;
    }
    
    @Override
    public void run() {
        // Genero pacchetti
        ArrayList<Pacchetto> coda = new ArrayList<>();
        coda = generaPacchetti(coda, Main.npacchetti);
        // Controllo se coda vuota o meno
        // System.out.println("La coda contiene "+coda.size()+" elementi.");
        // Settiamo il quantum
        quantumattuale = Main.quantum;
        System.out.println("--Coda "+this.id+" in partenza con "+coda.size()+" pacchetti.");
        // Fin quando i pacchetti non sono finiti
        while (coda.isEmpty() == false){
            // Eseguo operazioni sulla coda
            service(coda);
        }
        
        // Termino
        System.out.println("Coda "+this.id+" - Pacchetti terminati.");
    }
    
    public void service(ArrayList<Pacchetto> coda){
        // Prendo controllo
        Main.queue.lock();
        
        quantumattuale = Main.quantum + deficit;
        
        // Controllo se dimensioni pacchetto >= quanto di tempo
        if (coda.get(0).dimensione <= quantumattuale){
            
            // Prendo la dimensione del pacchetto
            int dimensione = coda.get(0).dimensione;
            
            // Calcolo il deficit
            deficitiniziale = deficit + Main.quantum;
            deficit = quantumattuale - dimensione;
            
            disegno(coda, deficit, deficitiniziale, this.id);
            //System.out.println("Deficit attuale: "+deficit);
            
            // Servo pacchetto
            System.out.println("CODA "+this.id+" - PACCHETTO "+contatorepacchetti+" SERVITO. (D="+dimensione+" - Q="+quantumattuale+")");
            
            // Rimuovo il pacchetto appena passato
            coda.remove(0);
            
            // Passo a elemento successivo della lista
            contatorepacchetti++;
            
            //System.out.println("La coda contiene ancora "+coda.size()+" elementi.");
            // Cedo controllo
            Main.queue.unlock();
        } else {
            // Prendo la dimensione del pacchetto
            //int dimensione = coda.get(0).dimensione;
            
            // Aumento contatoreripetizioni per segnalare che avrò un multiplo del quantum al prossimo giro
            //System.out.println("C"+this.id+"P"+contatorepacchetti+" NON servito. (D="+dimensione+" - Q="+quantumattuale+")");
            
            // Calcolo il deficit
            deficitiniziale = deficit;
            deficit = quantumattuale;
            disegno(coda, deficit, deficitiniziale, this.id);
            
            // Cedo controllo
            Main.queue.unlock();
        }
    }
    
    public ArrayList<Pacchetto> generaPacchetti(ArrayList<Pacchetto> coda, int npacchetti) {
        
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
        int dimension = randomgen.nextInt(1000);
        return dimension;
    }
    
    public void disegno(ArrayList<Pacchetto> coda, int deficit, int deficitiniziale, int id) {
        int dimensione0 = coda.get(0).dimensione;
        System.out.println("CODA "+id+"   |----"+dimensione0+"----|   ->   DI: "+deficitiniziale+"   DF: "+deficit);
    }
}