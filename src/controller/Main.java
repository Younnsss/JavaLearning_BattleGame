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
			Utils.broadcast("------------------------- FIN COMBAT : "+zone.getName()+" -------------------------");
			if(zone.combattantP1.size() == 0) {
				zone.setWinner(game.getPlayers()[1]);
			} else {
				zone.setWinner(game.getPlayers()[0]);
			}
			Utils.broadcast("---------- "+ zone.getWinner().getPseudo() +" a gagné la Bataille ! ----------");


			if(i < game.getZones().length-1 ) {

				Utils.broadcast("------------------- REDEPLOIEMENT DE TROUPES -------------------");
				for (int j = 1; j < 3; j++) {
					Utils.broadcast("---------- "+ game.getPlayers()[j-1].getPseudo() +" ----------");
					Utils.broadcast(" Deploiement des survivants : ");
					game.redeploy(zone, zone.getWinner(), j);
					Utils.broadcast(" Deploiement des reservistes : ");
					game.depRes(j);
				}

			}

		}
    	
        
    }
    
    public static Partie getGame() { return game; }
}
