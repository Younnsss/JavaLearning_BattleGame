package models;

public class Offensive implements Strategie {

    @Override
    public void action(Combattant etu1, Combattant etu2) {
        Utils.attaquer(etu1, etu2);
    }


}
