package tetris.gui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import tetris.domain.Ruutu;
import tetris.peli.Peli;
import tetris.domain.Pala;

/**
 * Piirtoalusta piirtää taustan, liikkuvan palan ja pysähtyneet palat sekä
 * pisteet, räjäytetyt rivit ja seuraavan palan
 *
 * @author heidvill
 */
public class Piirtoalusta extends JPanel implements Paivitettava {

    private Peli peli;
    private int palanSivunPituus;

    public Piirtoalusta(Peli peli, int palanSivunPituus) {
        super.setBackground(Color.GRAY);
        this.peli = peli;
        this.palanSivunPituus = palanSivunPituus;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.WHITE);
        g.fill3DRect(0, 0, 200, 400, true);

        g.setColor(peli.getPala().getVari());
        for (Ruutu r : peli.getPala().getRuudut()) {
            g.fill3DRect(r.getX() * palanSivunPituus, r.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }

        for (Ruutu ruutu : peli.getPalasailio().getRuudut()) {
            g.setColor(ruutu.getVari());
            g.fill3DRect(ruutu.getX() * palanSivunPituus, ruutu.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }

        if(!peli.jatkuu()){
            g.setColor(Color.RED);
            g.drawString("Peli päättyi!", 210, 240);
            g.drawString("Aloita uusi peli", 210, 260);
            g.drawString("painamalla Enter.", 210, 280);
        }
        
        g.setColor(Color.WHITE);
        g.drawString("Taso", 210, 20);
        g.drawString("" + peli.getTasot(), 210, 37);
        
        g.drawString("Pisteet", 210, 72);
        g.drawString("" + peli.getPisteet(), 210, 90);
        
        g.drawString("Seuraava pala", 210, 130);
     
        g.setColor(peli.getSeuraavaPala().getVari());
        for (Ruutu r : peli.getSeuraavaPala().getRuudut()) {
            g.fill3DRect(r.getX() * palanSivunPituus, r.getY() * palanSivunPituus, palanSivunPituus, palanSivunPituus, true);
        }
    }

    @Override
    public void paivita() {
        repaint();
    }
}
