package games.players;

import java.util.HashMap;
import java.util.Map;

import games.genericgames.Game;
/**
 * 
 * @author celina
 *cette classe permet de represnter un joeur utilisant l'algorithme negamax dans son raisonement avec une cache stockant les situation déja vues
 */
public class NegamaxPlayerWithCache extends NegamaxPlayer {
	Map<Game ,Integer> visitedStuation;
	/**
	 * initialisation
	 */
	public NegamaxPlayerWithCache() {
		super();
		visitedStuation = new HashMap<>();
	}
	@Override
	public int evaluate(Game p){
		if(visitedStuation.containsKey(p)) {
			return visitedStuation.get(p);
		}
		else {
			int val = super.evaluate(p);
			visitedStuation.put(p, val);
			return val;
		}
	}
	
}
