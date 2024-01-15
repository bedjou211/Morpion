package games.genericgames;
import games.players.*;
/**
 * Interface represente un type Game
 */
import java.util.*;
public interface Game{
	/**
	 * 
	 * @return le joueur courant
	 */
    public abstract Player getCurrentPlayer();
    /**
     * 
     * @return la liste des coups qui peuvent etre joués
     */
    public abstract ArrayList<Integer> validMoves();
    /**
     * 
     * @param x le coup
     * @return true si le coup x peut etre joué false sinon
     */
    public abstract boolean isValid(int x);
    /**
     * 
     * @param x le coup à éxécuter 
     * Change le plateau de jeu en éxécutant le coup x
     */
    public abstract void execute(int x);
    /**
     * 
     * @return true si la partie est finie false sinon
     */
    public abstract boolean isOver();
    /**
     * 
     * @return le joueur ayant gagné la partie sinon null
 	*/
    public abstract Player getWinner();
    /**
     * 
     * @param move le coup à jouer
     * @return la representation du coup move sous forme de chaine de caracteres
     */
    public abstract String moveToString(int move);
    /**
     * 
     * @return la representation du plateau sous forme de chaine de caracteres
     */
    public abstract String situationToString();
    /**
     * 
     * @return une copie de jeu
     */
    public abstract Game copy();    
}