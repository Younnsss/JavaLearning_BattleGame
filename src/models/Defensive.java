package models;

public class Defensive implements Strategie {

    @Override
    public void action(Combattant etu1, Combattant etu2) {
        Utils.soigner(etu1, etu2);
    }


}
