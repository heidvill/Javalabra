
package tetris.domain;

import java.util.ArrayList;

public class Palasailio {
    private ArrayList<Pala> palat;
    private int leveys;
    private int korkeus;

    public Palasailio(int leveys, int korkeus) {
        palat = new ArrayList();
        this.leveys = leveys;
        this.korkeus = korkeus;
        
        lisaaPalat();
    }
    
    private void lisaaPalat(){
        palat.add(new IPala(leveys, korkeus));
        palat.add(new JPala(leveys, korkeus));
        palat.add(new LPala(leveys, korkeus));
        palat.add(new OPala(leveys, korkeus));
        palat.add(new SPala(leveys, korkeus));
        palat.add(new TPala(leveys, korkeus));
        palat.add(new ZPala(leveys, korkeus));
    }

    public ArrayList<Pala> getPalat() {
        return palat;
    }
    
    public Pala getPala(int indeksi){
        return palat.get(indeksi);
    }
    
    public int sailionKoko(){
        return palat.size();
    }
    
    
    
}
