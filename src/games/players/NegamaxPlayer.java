package games.players;

import games.genericgames.Game;
/**
 * 
 * @author celina
 *cette classe permet de represnter un joeur utilisant l'algorithme negamax dans son raisonement 
 */
public class NegamaxPlayer implements Player {
	
	/**
	 * Initialisation
	 */
	public NegamaxPlayer() {
		
	}

	@Override
	public int chooseMove(Game p) {
		int bestVal = -2;
		int bestMov = -1;
		for(int c : p.validMoves()) {
			Game p2 = p.copy();
			p2.execute(c);
			int v = -1*evaluate(p2);
			if(bestVal == -2 || v>bestVal) {
				bestVal = v;
				bestMov = c;
			}
		}
		return bestMov;
	}
	/**
	 * 
	 * @param p l'instantiation du jeu de type Game
	 * @return l'evaluation de la situation pour le joeur courant
	 */
	public int evaluate(Game p){
		if(p.isOver()) {
			if(p.getWinner()==null) {
				return 0;
			}
			else {
				if(p.getWinner().equals(p.getCurrentPlayer())) {
					return 1;
				}
				else {
					return -1;
				}
			}
		}
		else {
			int res = -2 ;
			for(int c : p.validMoves()){
				Game p2 = p.copy();
				p2.execute(c);
				int v = -1*evaluate(p2);
				if (res == -2 || v>res)
					res = v;
			}
			return res;
		}
		
	}

}
