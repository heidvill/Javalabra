package com.mycompany.tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
import tetris.peli.Peli;

public class App {

    public static void main(String[] args) {
        Peli tetris = new Peli(10, 20);

        Kayttoliittyma kayttis = new Kayttoliittyma(tetris, 20);
        SwingUtilities.invokeLater(kayttis);

        while (kayttis.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        tetris.start();
    }
}
