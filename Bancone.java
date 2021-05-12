/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compito.mensaaziendale;

import static java.lang.Thread.sleep;
import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Bancone su cui vengono depositati e prelevati i piatti.
 * @author Dardan Matias Berisha
 */
public class Bancone {
    
    private int piattoSulBancone;
    
    private Semaphore semVuoto = new Semaphore(1); //semaforo che regola quando il cuoco può depositare un piatto
    private Semaphore semPieno = new Semaphore(0); //semaforo che regola quando il dipendente può prendere il piatto, inizia da 0 perché inizialmente deve aspettare un piatto
    
    /**
     * Metodo usato dal cuoco per depositare sul bancone i piatti creati.
     * @param piatto piatto da depositare sul bancone.
     */
    public void depositaPiatto(int piatto){
        
        try {
            sleep(new Random().nextInt(100)+100); //tempo che impiega il cuoco a preparare e depositare il piatto: da 100 a 199 ms
            
        } catch (InterruptedException ex) {
            Logger.getLogger(Cuoco.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            semVuoto.acquire(); //il cuoco aspetta che si possa piazzare il piatto
        } catch (InterruptedException ex) {
            Logger.getLogger(Bancone.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        piattoSulBancone = piatto; //il cuoco piazza il piatto 
        
        semPieno.release();// il dipendente può prendere il piatto
        
    }
    
    /**
     * Metodo usato dal dipendente per prendere il piatto dal bancone.
     * @return il piatto da prendere sul bancone.
     */
    public int prendiPiatto(){
        
        try {
            semPieno.acquire(); // il cliente aspetta che gli venga dato il permesso di prendere il piatto
        } catch (InterruptedException ex) {
            Logger.getLogger(Bancone.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int p = piattoSulBancone;
        
        try {
            Thread.sleep(new Random().nextInt(100)+1000); //tempo che impiega un dipendente a prendere il piatto: da 1000 a 1099 ms
        } catch (InterruptedException ex) {
            Logger.getLogger(Bancone.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        semVuoto.release(); //il cuoco può iniziare a preparare un altro piatto
        
        return p;
    }
    
}
