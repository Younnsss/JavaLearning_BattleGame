package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zone {
	
    private String name;
    private Player winner;
    public List<Combattant> combattantP1 = new ArrayList<Combattant> ();
    public List<Combattant> combattantP2 = new ArrayList<Combattant> ();

    Zone(String n) {
		this.name = n;
		this.winner = null;
	}
	
	public String getName() { return this.name; }
	public Player getWinner() { return this.winner; }

    List<Combattant> getCombattantP1() { return this.combattantP1;}

    void setCombattantP1(List<Combattant> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.combattantP1 = value;
    }
    
    List<Combattant> getCombattantP2() {
        // Automatically generated method. Please delete this comment before entering specific code.
        return this.combattantP2;
    }

    void setCombattantP2(List<Combattant> value) {
        // Automatically generated method. Please delete this comment before entering specific code.
        this.combattantP2 = value;
    }
    
    
    public void combat() {
    	Collections.sort(this.combattantP1);
    	Collections.sort(this.combattantP2);
    	Combattant.affComb(this.combattantP1);
    	System.out.println();
    	Combattant.affComb(this.combattantP2);
    	System.out.println();
    	System.out.println();
    	int j1=0,j2=0;
    	while (j1<this.combattantP1.size() && j2<this.combattantP2.size()) {
			if(this.combattantP1.get(j1).getInitiative()>this.combattantP2.get(j2).getInitiative()) {
				
				j1++;
			}else {
				j2++;
			}
		}
    	while(j1<this.combattantP1.size()) {
			j1++;
    	}
    	while(j2<this.combattantP2.size()) {
			j2++;
    	}
    	
    	
    }

}
