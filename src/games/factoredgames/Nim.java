package games.factoredgames;
/**
 * 
 * @author celina
 *Cette classe représente une situatuin du jeu de nim
 */
public class Nim extends AbstractGame{
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
    public Nim(int n,int k,String firstPlayer,String secondPlayer){
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
    public boolean isOver(){
        if(this.nombreCourant == 0){
            return true;
        }
        return false;
    }
    @Override
    public String getWinner(){
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

}