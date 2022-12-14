package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Zone {
	
    private String name;
    private Boolean isFinish;
    public List<Combattant> combattantP1 = new ArrayList<Combattant> ();
    public List<Combattant> combattantP2 = new ArrayList<Combattant> ();

	private Player Pwinner;

    Zone(String n) {
		this.name = n;
		this.isFinish = null;
	}
	public Player getPWinner() { return this.Pwinner; }
	public void setWinner(Player player) { this.Pwinner=player; }
	public String getName() { return this.name; }
	public Boolean getIsFinish() { return this.isFinish; }

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
		while(this.combattantP1.size()>0 && this.combattantP2.size()>0) {
			j1=0;
			j2=0;
			while (j1 < this.combattantP1.size() && j2 < this.combattantP2.size()) {

				System.out.println();
				System.out.println();
				System.out.println("Action " + (j1 + j2 + 1));
				System.out.println();
				System.out.println();
				if (this.combattantP1.get(j1).getInitiative() > this.combattantP2.get(j2).getInitiative()) {
					System.out.println("Strategie :" + this.combattantP1.get(j1).strategie);
					this.combattantP1.get(j1).strategie.action(this.combattantP1.get(j1), this.combattantP1, this.combattantP2);
					System.out.println();
					Combattant.affComb(this.combattantP1);
					System.out.println();
					Combattant.affComb(this.combattantP2);
					j1++;
				} else {
					System.out.println("Strategie :" + this.combattantP2.get(j2).strategie);
					this.combattantP2.get(j2).strategie.action(this.combattantP2.get(j2), this.combattantP2, this.combattantP1);
					System.out.println();
					Combattant.affComb(this.combattantP1);
					System.out.println();
					Combattant.affComb(this.combattantP2);
					j2++;
				}
			}
			while (j1 < this.combattantP1.size()) {
				System.out.println();
				System.out.println();
				System.out.println("Action " + (j1 + j2 + 1));
				System.out.println();
				System.out.println();
				System.out.println("Strategie :" + this.combattantP1.get(j1).strategie);
				this.combattantP1.get(j1).strategie.action(this.combattantP1.get(j1), this.combattantP1, this.combattantP2);
				System.out.println();
				Combattant.affComb(this.combattantP1);
				System.out.println();
				Combattant.affComb(this.combattantP2);
				j1++;
			}
			while (j2 < this.combattantP2.size()) {
				System.out.println();
				System.out.println();
				System.out.println("Action " + (j1 + j2 + 1));
				System.out.println();
				System.out.println();
				System.out.println("Strategie :" + this.combattantP2.get(j2).strategie);
				this.combattantP2.get(j2).strategie.action(this.combattantP2.get(j2), this.combattantP2, this.combattantP1);
				System.out.println();
				Combattant.affComb(this.combattantP1);
				System.out.println();
				Combattant.affComb(this.combattantP2);
				j2++;
			}
		}
		this.isFinish = true;


    }

}
