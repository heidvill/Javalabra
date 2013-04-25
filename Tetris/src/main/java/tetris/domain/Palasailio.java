package tetris.domain;

import java.util.ArrayList;
import java.util.Random;
import tetris.Palatyyppi;

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
        } else if (luku == 1) {
            return new JPala(leveys, korkeus);
        } else if (luku == 2) {
            return new LPala(leveys, korkeus);
        } else if (luku == 3) {
            return new OPala(leveys, korkeus);
        } else if (luku == 4) {
            return new SPala(leveys, korkeus);
        } else if (luku == 5) {
            return new TPala(leveys, korkeus);
        } else {
            return new ZPala(leveys, korkeus);
        }
    }

    /**
     * Luo uuden palan seuraavan palan tyypin mukaan.
     *
     * @param tyyppi kopioitavan palan tyyppi
     * @return uusi pala, joka on samanmuotoinen kuin parametrina annettava
     * tyyppi
     *
     * @see Palatyyppi
     */
    public Pala kopioiSeuraavaPala(Palatyyppi tyyppi) {
        if (tyyppi == Palatyyppi.I) {
            return new IPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.J) {
            return new JPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.L) {
            return new LPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.O) {
            return new OPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.S) {
            return new SPala(leveys, korkeus);
        } else if (tyyppi == Palatyyppi.T) {
            return new TPala(leveys, korkeus);
        } else {
            return new ZPala(leveys, korkeus);
        }
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

    /**
     * Laskee poistetun/poistettujen rivi(e)n yläpuolisia rivejä.
     *
     * @param raja kertoo minkä koordinaatin yläpuolisia rivejä lasketaan
     * @param paljonLasketaan kertoo monta askelta rivejä lasketaan, riippuu
     * poistettujen rivien määrästä.
     */
    private void laskeYlempiaRiveja(int raja, int paljonLasketaan) {
        for (Ruutu ruutu : ruudut) {
            if (ruutu.getY() < raja) {
                ruutu.setY(ruutu.getY() + paljonLasketaan);
            }
        }
    }
}
