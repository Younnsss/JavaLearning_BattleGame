package models;

import java.util.List;

public class Aleatoire implements Strategie {


    @Override
    public void action(Combattant c, List<Combattant> l1, List<Combattant> l2) {
        
        if (Math.round(Math.random() * 1000) >= 500) {
            Utils.attaquer(c,l1,l2);
        } else {
            Utils.soigner(c,l1,l2);
        }
    }

}
