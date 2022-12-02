package models;

import java.util.List;

public interface Strategie {
	public void action(Combattant c, List<Combattant> l1, List<Combattant> l2);
}
