package models;
public class Aleatoire implements Strategie {


    @Override
    public void action(Combattant etu1, Combattant etu2) {
        
        if (Math.round(Math.random() * 1000) >= 500) {
            Utils.attaquer(etu1, etu2);
        } else {
            Utils.soigner(etu1, etu2);
        }
    }

}
