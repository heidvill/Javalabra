
package tetris.domain;

//import java.util.ArrayList;


public abstract class Pala {
  // private ArrayList<Ruutu> ruudut;

    public Pala() {
       //ruudut = new ArrayList(); 
    }
   
   public abstract void liiku();
    abstract void kierraOikealle();
    abstract void lisaaRuutu();
    
}
