package models;

import java.util.List;

public class Offensive implements Strategie {

    @Override
    public void action(Combattant c, List<Combattant> l1, List<Combattant> l2) {
        Utils.attaquer(c,l1,l2);
    }


}
