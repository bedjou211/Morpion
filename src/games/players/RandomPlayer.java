package games.players;
import games.genericgames.*;
import java.util.*;
/**
 * 
 * @author celina
 *Cette classe est une representation d'un joeur qui utilise une fonction aléatoire dans ses choix
 */
public class RandomPlayer implements Player {
    private Random random;
    public RandomPlayer (Random random){
        this.random= random;
    }
    @Override
    public int chooseMove(Game p){
        ArrayList<Integer> liste = p.validMoves();
        int n = random.nextInt(liste.size()) ;
        while(n>liste.size()-1 || n<0){
            n = random.nextInt(liste.size()) ;
        }
        return liste.get(n);
    }
    @Override
    public String toString(){
        return "Joueur aléatoire n° "+this.hashCode();
    }
}
