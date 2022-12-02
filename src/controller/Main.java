package controller;

import models.Partie;
import models.Utils;
import models.Zone;

public class Main {
	
	private static Partie game = new Partie();
    
    public static void main(String[] args) {
    	
    	Utils.broadcast("------------------- INITIALISATION -------------------");
    	String choice;
    	
    	game.initZones(new String[] {"Bibliothèque", "Bureau des Etudiants", 
				"Quartier administratif", "Halle indistrielle", "Halle sportive"});
    	
    	String[] choices = {"random", "manual"};
    	for (int i = 0; i < 2; i++) {
    		Utils.broadcast("--------------- Joueur "+ (i+1) +" ---------------");
    		
    		do {
    			choice = Utils.input("Sélectionne une méthode de création de combat: (random/manual)");
    		} while (!Utils.in(choice, choices));
    		
    		switch (choice) {
    			case "random":
    				game.initAutoPlayer(i);
    	    		game.initAutoComb(i);
    				break;
    			default:
    				game.initPlayer(i);
    	    		game.initComb(i);
    				break;
    		}
		}
    	
    	
    	Utils.broadcast("------------------- DEPLOIEMENT DE TROUPES -------------------");
    	for (int i = 0; i < 2; i++) {
    		
    		do {
    			choice = Utils.input("Sélectionne une méthode de création de combat: (random/manual)");
    		} while (!Utils.in(choice, choices));
    		
    		switch (choice) {
    			case "random":
    				Utils.broadcast("--------------- "+ game.getPlayers()[i].getPseudo() +" ---------------");
    				game.autoRes(i);
    				game.autoDep(i);
    				break;
    			default:
    				Utils.broadcast("--------------- "+ game.getPlayers()[i].getPseudo() +" ---------------");
    	    		game.choixRes(i);
    	    		game.depComb(i);
    				break;
    		}
    		
		}
    	
    	Utils.broadcast("------------------------- COMBAT -------------------------");
    	for (int i = 0; i < game.getZones().length; i++) {
			Zone zone = game.getZone(game.chooseZone());
			Utils.broadcast("--------------- Zone de combat "+ (i+1)+ " : " +zone.getName() +" ---------------");
			zone.combat();
		}
    	
        
    }
    
    public static Partie getGame() { return game; }
}
