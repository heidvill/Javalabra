package tetris.peli;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;
import tetris.domain.Pala;
import tetris.domain.Palasailio;
import tetris.domain.Ruutu;
import tetris.gui.Paivitettava;

/**
 * Peli-luokka kokoaa tetriksen kokonaisuudeksi.
 *
 * Peli liikuttaa palaa ja tarkistaa tuleeko täysiä rivejä, jotka pitäisi
 * poistaa.
 *
 * @author heidvill
 */
public class Peli extends Timer implements ActionListener {

    private boolean jatkuu;
    private Paivitettava alusta;
    private Pala pala;
    private Palasailio palasailio;
    private int leveys;
    private int korkeus;
    private Pistelaskuri laskuri;
    private Pala seuraavaPala;
    private int nopeus;

    public Peli(int leveys, int korkeus) {
        super(1000, null);
        this.palasailio = new Palasailio(leveys, korkeus);
        this.jatkuu = true;
        this.pala = palasailio.getUusiPala();
        this.seuraavaPala = palasailio.getUusiPala();
        this.korkeus = korkeus;
        this.leveys = leveys;
        this.laskuri = new Pistelaskuri();
        this.nopeus = 500;

        siirraSeuraavaPalaOikeaanPaikkaan();
        addActionListener(this);
        setDelay(nopeus);
    }
    
    /**
     * Alustaa kaikki attribuutit, jotta voidaan aloittaa uusi peli.
     */
    public void uusiPeli(){
        this.palasailio = new Palasailio(leveys, korkeus);
        this.jatkuu = true;
        this.pala = palasailio.getUusiPala();
        this.seuraavaPala = palasailio.getUusiPala();
        this.laskuri = new Pistelaskuri();
        this.nopeus = 400;

        siirraSeuraavaPalaOikeaanPaikkaan();
        setDelay(nopeus);
    }

    public boolean jatkuu() {
        return jatkuu;
    }

    public void setPiirtoalusta(Paivitettava paivitettava) {
        this.alusta = paivitettava;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (!jatkuu) {
            return;
        }
        pala.liiku();
        pala.osuuAlasRuutuun(palasailio);
        
        if (!pala.isLiikkeessa()) {
            tarkistaLoppuukoPeli();
            palasailio.lisaaPala(pala);
            pala = palasailio.kopioiSeuraavaPala(seuraavaPala.getTyyppi());
            seuraavaPala = palasailio.getUusiPala();
            siirraSeuraavaPalaOikeaanPaikkaan();
            laskuri.kasvataPisteitaPalalla();
        }

        etsiTaysiaRiveja();
        alusta.paivita();
    }

    public Pala getPala() {
        return pala;
    }

    public Palasailio getPalasailio() {
        return palasailio;
    }

    /**
     * Etsii muodostuuko palasäiliön ruuduista täysiä rivejä ja poistaa ne
     * palasäiliöstä. Lisäksi kasvatetaan pistelaskurin pisteitä täysien rivien
     * mukaan. Kasvatetaan nopeutta, jos taso nousee siis jos rivien määrä on jaollinen kymmenellä.
     *
     */
    public void etsiTaysiaRiveja() {
        ArrayList<Integer> taydetRivit = new ArrayList<Integer>();
        for (int rivi = 0; rivi < korkeus; rivi++) {
            int ruutuja = 0;
            for (Ruutu ruutu : palasailio.getRuudut()) {
                if (ruutu.getY() == rivi) {
                    ruutuja++;
                }
            }
            if (ruutuja == leveys) {
                taydetRivit.add(rivi);
            }
        }

        laskuri.kasvataPisteitaRiveilla(taydetRivit.size());
        palasailio.poistaTaydetRivit(taydetRivit);
        if (!taydetRivit.isEmpty() && laskuri.getRivit() % 10 == 0) {
            kasvataNopeutta();
        }
    }

    /**
     * Kasvattaa palan tippumisnopeutta
     */
    public void kasvataNopeutta() {
        if (nopeus >= 90) {
            nopeus -= 50;
            setDelay(nopeus);
        }
    }

    public int getLeveys() {
        return leveys;
    }

    public Pala getSeuraavaPala() {
        return seuraavaPala;
    }

    public int getPisteet() {
        return laskuri.getPisteet();
    }

    public int getTasot() {
        return laskuri.getTaso();
    }

    public int getNopeus() {
        return nopeus;
    }

    /**
     * Siirtää seuraavan palan oikeaan kohtaan ikkunassa, jotta piirtoalusta voi
     * piirtää sen.
     */
    private void siirraSeuraavaPalaOikeaanPaikkaan() {
        for (Ruutu ruutu : seuraavaPala.getRuudut()) {
                ruutu.setX(ruutu.getX() + 7);
            }
        while (seuraavaPala.getRuudut().get(3).getY()!=7) {
            for (Ruutu ruutu : seuraavaPala.getRuudut()) {
                ruutu.setY(ruutu.getY() + 1);
            }
        }
    }

    /**
     * Tarkistetaan palan pysähtymisen jälkeen jääkö sen jokin ruutu pelialueen yläreunaan tai sem ulkopuolelle
     */
    private void tarkistaLoppuukoPeli() {
        for (Ruutu ruutu : pala.getRuudut()) {
            if (ruutu.getY() <= 0) {
                jatkuu = false;
            }
        }
    }
}