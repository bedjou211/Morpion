package games.genericgames;
import java.util.*;
import games.players.*;
/**
 * 
 * @author celina
 *Cette classe représente une situatuin du jeu de nim
 */
public class Nim extends AbstractGame {
    private int n;
    private int k ;
    private int nombreCourant;
    /**
     * 
     * @param n le nombre initial d'allumettes
     * @param k le nombre maximal d'allumettes qu'on peut retirer
     * @param firstPlayer le joeur 1
     * @param secondPlayer le joueur 2
     * initialisation du jeu
     */
    public Nim(int n,int k,Player firstPlayer,Player secondPlayer){
        super(firstPlayer,secondPlayer);
        this.n = n;
        this.k = k;
        this.nombreCourant = n;
    }
    /**
     * 
     * @return le nombre initial d'allumettes
     */
    public int getInitialNbMatches(){
        return this.n;
    }
    /**
     * 
     * @return le nombre d'allumettes restantes
     */
    public int getCurrentNbMatches(){
        return this.nombreCourant;
    }
    @Override
    public Player getCurrentPlayer(){
        return this.joueurCourant;
    }
    @Override
    public String situationToString(){
        return "Il reste "+this.nombreCourant+" allumettes";
    }

    @Override
    public void doExecute(int nombreAllumettes ){
        this.nombreCourant = this.nombreCourant - nombreAllumettes;
    }
    
    @Override
    public boolean isValid(int nombreAllumettes){
        if(nombreAllumettes >0 && nombreAllumettes<=this.nombreCourant && nombreAllumettes<=this.k){
            return true;
        }
        return false;   
    }
    @Override 
    public ArrayList<Integer> validMoves(){
        ArrayList<Integer> liste = new ArrayList<Integer>();
            for(int i =0;i<=this.k;i++){
                if(isValid(i)){
                    liste.add(i);
                }
            }
         return liste;
    }
    @Override
    public boolean isOver(){
        if(this.nombreCourant == 0){
            return true;
        }
        return false;
    }
    @Override
    public Player getWinner(){
        if(isOver() == false){
            return null;
        }
        else{
            if(this.joueurCourant == this.firstPlayer){
                return this.firstPlayer;
            }
            else{
                return this.secondPlayer;
            }
            
        }
    }
    @Override 
    public String moveToString(int move){
        return "("+move+")";
    }

    @Override 
    public Game copy(){
        Nim n;
        if(this.getCurrentPlayer() == this.firstPlayer)
            n = new Nim(this.getInitialNbMatches(),k,this.firstPlayer,this.secondPlayer);
        else
            n = new Nim(this.getInitialNbMatches(),k,this.secondPlayer,this.firstPlayer);
        n.nombreCourant = this.nombreCourant;
        return n ;
    }
    @Override
    public boolean equals(Object o) {
    	if(o instanceof Nim) {
    		Nim otherNim = (Nim) o;
    		return this.getCurrentPlayer().equals(getCurrentPlayer())&&this.getInitialNbMatches()==otherNim.getInitialNbMatches()&&this.getCurrentNbMatches()==otherNim.getCurrentNbMatches();
    	}
    	else
    		return false;
    	
    }
    @Override
    public int hashCode() {
		return Objects.hash(this.getCurrentPlayer(),this.getCurrentNbMatches(),this.getInitialNbMatches());
    	
    }
}
