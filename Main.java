package compito.mensaaziendale;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dardan Matias Berisha
 */
public class Main {
    public static void main(String[] args) {
        
        Bancone b = new Bancone();
        
        ArrayList<Dipendente> listaDipendenti = new ArrayList<>();
        
        for (int i = 0; i < 10; i++) {
            listaDipendenti.add(new Dipendente("dip" + (i+1), b));
        }
        
        Cuoco cuoco = new Cuoco("cuoco", b, listaDipendenti.size());
        
        cuoco.start();
        
        for (Dipendente d : listaDipendenti) {
            d.start();
        }
        
        for (Dipendente d : listaDipendenti) {
            try {
                d.join();
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        System.out.println("\nFine pausa pranzo");
        
    }
}
