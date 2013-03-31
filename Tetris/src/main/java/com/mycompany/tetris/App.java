package com.mycompany.tetris;

import javax.swing.SwingUtilities;
import tetris.gui.Kayttoliittyma;
import tetris.peli.Peli;

public class App {

    public static void main(String[] args) {
        Peli tetris = new Peli(12, 20);

        Kayttoliittyma kali = new Kayttoliittyma(tetris, 20);
        SwingUtilities.invokeLater(kali);

        while (kali.getPiirtoalusta() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        tetris.setPiirtoalusta(kali.getPiirtoalusta());
        tetris.start();
    }
}
