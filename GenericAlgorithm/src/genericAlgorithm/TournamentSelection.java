package genericAlgorithm;

import java.util.ArrayList;
import java.util.Collections;

public class TournamentSelection {
	Invidual [] players;
	
	public TournamentSelection(Invidual[] players) {
		this.players = players;	
	}
	
	public Invidual[] organizeFullTournament() {
		int populationLength = players.length;
		Invidual [] winners = new Invidual[populationLength];
		
		//zostawienie jednego pustego miejsca na wpisanie obecnie najlepszego aby nie zgubic tego rozwiazania
		for(int i = 0; i < populationLength; i++) {
			winners[i] = organizeTinyTournament();
		}
		return winners;
	}
	
	private Invidual organizeTinyTournament() {
		int bestDraw = getRandomNumber(0,players.length);
		ArrayList<Integer> drawnPlayers = new ArrayList<Integer>();
		ArrayList<Invidual> competitors = new ArrayList<Invidual>();
		
		Invidual bestPlayer = players[bestDraw];
	
		while(drawnPlayers.size() < 3){
			int draw = getRandomNumber(0,players.length);
			if(!drawnPlayers.contains(draw) && draw != bestDraw) {
				drawnPlayers.add(draw);
				competitors.add(players[draw]); // ogarnij kopie; bo referencje
			}
		
		}
		
		for(int i = 0; i < drawnPlayers.size();i++) {
			if(bestPlayer.functionValue > competitors.get(i).functionValue) {
				bestPlayer = competitors.get(i);
			}
		}
	
		return bestPlayer;	
	}
	
	protected int getRandomNumber(int min, int max) {
	    return (int)((Math.random() * (max - min)) + min);
	}
}
