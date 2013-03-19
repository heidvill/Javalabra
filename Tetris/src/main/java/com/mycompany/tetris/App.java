package com.mycompany.tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
import tetris.peli.Peli;


public class App {
    public static void main( String[] args ){
     Peli peli = new Peli(20, 20);

        Kayttoliittyma kali = new Kayttoliittyma(peli, 20);
        SwingUtilities.invokeLater(kali);

        while (kali.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        peli.setPaivitettava(kali.getPaivitettava());
        peli.start();
    }
}
