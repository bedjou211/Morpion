package games.players;
import games.genericgames.*;
/**
 * 
 * @author celina
 *interface d'un type Player
 */
public interface Player{
	/**
	 * 
	 * @param p L'instatiation d'un jeu de type Game
	 * @return le coup choisi
	 */
    public abstract int chooseMove(Game p);
}