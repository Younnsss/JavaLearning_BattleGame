package models;
import java.util.ArrayList;
import java.util.List;

public class Player {
	
    private String pseudo,filiere;
    private int creditECTS;
    private int score;
    private List<Combattant> combattant = new ArrayList<Combattant> ();
    public List<Combattant> reserviste = new ArrayList<Combattant> ();
    
    Player(String pseudo, String filiere){
    	this.pseudo = pseudo;
    	this.filiere = filiere;
    	this.creditECTS = 400;
        this.score = 0;
    }

    public String getPseudo() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.pseudo;
    }

    void setPseudo(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.pseudo = value;
    }

    int getCreditECTS() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.creditECTS;
    }

    void setCreditECTS(int value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.creditECTS = value;
    }

    String getFiliere() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.filiere;
    }

    void setFiliere(String value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.filiere = value;
    }

    public int getScore() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.score;
    }

    public void updateScore() {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.score++;
    }

    List<Combattant> getCombattant() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.combattant;
    }

    void setCombattant(List<Combattant> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.combattant = value;
    }

    List<Combattant> getReserviste() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.reserviste;
    }

    void setReserviste(List<Combattant> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.reserviste = value;
    }
    

}
