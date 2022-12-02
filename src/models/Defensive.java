package models;

import java.util.List;

public class Defensive implements Strategie {

    @Override
    public void action(Combattant c, List<Combattant> l1, List<Combattant> l2) {
        Utils.soigner(c,l1,l2);
    }


}
