package games.players;
import games.genericgames.*;
import java.util.*;
/**
 * 
 * @author celina
 *Cette classe represente un joueur humain
 */
public class Human implements Player{
    private String Nom;
    private Scanner scanner;
    /**
     * 
     * @param Nom le nom du joeur
     * @param scanner l'instantiation du scanner qui va recevoir les saisies du joeurs
     */
    public Human (String Nom,Scanner scanner){
        this.Nom = Nom;
        this.scanner=scanner;
    }
    @Override
    public  int chooseMove(Game p){
        for(int elem: p.validMoves()){
       	    System.out.println (elem);
        }
        int n = scanner.nextInt();
        while(!p.isValid(n)){
            n = scanner.nextInt();
        }
        return n;
    }
    @Override
    public String toString(){
        return Nom;
    }
}