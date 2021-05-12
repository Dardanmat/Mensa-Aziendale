/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compito.mensaaziendale;

/**
 * Thread consumatore che prende i piatti dal bancone.
 * @author Dardan Matias Berisha
 */
public class Dipendente extends Thread{
    
    private int piatto;
    private Bancone b;
    
    /**
     * Costruttore.
     * @param name nome del dipendente.
     * @param b bancone sul quale il dipendente prende i piatti.
     */
    public Dipendente(String name, Bancone b) {
        super(name);
        this.b = b;
    }

    @Override
    public void run() {
        
        System.out.println("Dipendente " + getName() + " aspetta il proprio turno");
        piatto = b.prendiPiatto(); //dipendente prende il piatto
        System.out.println("Dipendente " + getName() + " ha preso il piatto " + piatto);
        
    }
    
    
    
}
