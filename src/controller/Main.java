package controller;

import models.Partie;
import models.Utils;
import models.Zone;

import java.util.List;

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
			Utils.broadcast("---------- "+ zone.getPWinner().getPseudo() +" a gagné la Bataille ! ----------");


			if(i < game.getZones().length-1 ) {

				Utils.broadcast("------------------- REDEPLOIEMENT DE TROUPES -------------------");
				List<Zone> destZones = game.getDestZones();
				for (int j = 1; j < 3; j++) {
					Utils.broadcast("---------- "+ game.getPlayers()[j-1].getPseudo() +" ----------");
					Utils.broadcast(" Deploiement des survivants : ");
					game.redeploy(zone,destZones, j);
					Utils.broadcast(" Deploiement des reservistes : ");
					game.depRes(j,destZones);
				}

			}

		}

		Utils.broadcast("------------------------- FIN DE LA PARTIE -------------------------");
		game.setResults();
		for (Zone zone : game.getZones()) {
			Utils.broadcast("--------------- Zone de combat : " +zone.getName() +" ---------------");
			Utils.broadcast(" Le gagnant est : "+ zone.getPWinner().getPseudo());
		}
		for (int j = 1; j < 3; j++) {
			Utils.broadcast("---------- "+ game.getPlayers()[j-1].getPseudo() +" ----------");
			Utils.broadcast(" Nombre de zones conquises :  " + game.getResults().get(game.getPlayers()[j-1]));
			if(game.getPlayers()[j-1].getWinner()){
				Utils.broadcast(" Le joueur "+ game.getPlayers()[j-1].getPseudo() +" a gagné la partie !");
			}else{
				Utils.broadcast(" Le joueur "+ game.getPlayers()[j-1].getPseudo() +" a perdu la partie !");
			}
		}



    	
        
    }
    
    public static Partie getGame() { return game; }
}
