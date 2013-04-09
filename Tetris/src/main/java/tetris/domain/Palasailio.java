package tetris.domain;

import java.util.ArrayList;
import java.util.Random;

/**
 * Palasäiliö säilyttää alas pudonneet palat ja palauttaa uuden satunnaisen
 * palan kun edellinen pala ei voi liikkua enää alaspäin.
 *
 * @author heidvill
 */
public class Palasailio {

    private ArrayList<Ruutu> ruudut;
    private int leveys;
    private int korkeus;

    public Palasailio(int leveys, int korkeus) {
        ruudut = new ArrayList();
        this.leveys = leveys;
        this.korkeus = korkeus;
    }

    /**
     * Lisää parametrina annetun palan palasäiliöön.
     *
     * @param pala, säiliöön lisättävä pala
     */
    public void lisaaPala(Pala pala) {
        for (Ruutu ruutu : pala.getRuudut()) {
            ruudut.add(ruutu);
        }
    }

    public ArrayList<Ruutu> getRuudut() {
        return ruudut;
    }

    /**
     * Palauttaa uuden satunnaisen palan peliin.
     *
     * @return uusi satunnainen pala
     */
    public Pala getUusiPala() {
        int luku = new Random().nextInt(7);
        if (luku == 0) {
            return new IPala(leveys, korkeus);
        }
        if (luku == 1) {
            return new JPala(leveys, korkeus);
        }
        if (luku == 2) {
            return new LPala(leveys, korkeus);
        }
        if (luku == 3) {
            return new OPala(leveys, korkeus);
        }
        if (luku == 4) {
            return new SPala(leveys, korkeus);
        }
        if (luku == 5) {
            return new TPala(leveys, korkeus);
        }
        return new ZPala(leveys, korkeus);
    }

    public int sailionKoko() {
        return ruudut.size();
    }

    /**
     * Etsii täysillä riveillä olevat ruudut ja poistaa ne säiliöstä.
     *
     * Jos täysiä rivejä ei ole yhtään, metodi ei tee mitään.
     *
     * @param taydetRivit, sisältää täysien rivien y-koordinaattien arvot
     */
    public void poistaTaydetRivit(ArrayList<Integer> taydetRivit) {
        if (taydetRivit.isEmpty()) {
            return;
        }
        int ylin = korkeus;
        ArrayList<Ruutu> poistettavat = new ArrayList<Ruutu>();
        for (Integer rivi : taydetRivit) {
            for (Ruutu ruutu : ruudut) {
                if (ruutu.getY() == rivi) {
                    poistettavat.add(ruutu);
                }
            }
            if (rivi < ylin) {
                ylin = rivi;
            }
        }
        ruudut.removeAll(poistettavat);
        laskeYlempiaRiveja(ylin, taydetRivit.size());
    }

    private void laskeYlempiaRiveja(int ylaraja, int paljonLasketaan) {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getY() < ylaraja) {
                ruutu.setY(ruutu.getY() + paljonLasketaan);
            }
        }
    }
}
