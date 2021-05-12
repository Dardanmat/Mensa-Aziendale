/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compito.mensaaziendale;

/**
 * Thread produttore che produce e deposita i piatti sul bancone.
 * @author Dardan Matias Berisha
 */
public class Cuoco extends Thread{

    private Bancone b;
    private int piatto = 1;
    private int numDipendenti;
    
    /**
     * Costruttore
     * @param name nome del cuoco .
     * @param b bancone sul quale il cuoco deposita i piatti prodotti.
     * @param numDipendenti numero dei dipendenti per i quali fare i piatti, verrà prodotto un piatto per ogni cliente.
     */
    public Cuoco(String name, Bancone b, int numDipendenti) {
        super(name);
        this.b = b;
        this.numDipendenti = numDipendenti;
    }

    @Override
    public void run() {
        
        while (numDipendenti > 0) { //il cuoco prepara piatti fino a quando non ci sono più dipendenti
            
            System.out.println("Cuoco prepara piatto " + piatto);
            b.depositaPiatto(piatto);
            piatto++;
            
            numDipendenti--; //un dipendente è stato servito
        }
        
    }
}
