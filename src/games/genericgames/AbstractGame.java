package games.genericgames;
import games.players.Player;
/**
 * 
 * @author celina
 *cette classa est une abstraction d'un Game generic
 */
public abstract class  AbstractGame implements Game{

    protected Player firstPlayer;
    protected Player secondPlayer;
    protected Player joueurCourant;
    /**
     * 
     * @param firstPlayer le joueur 1
     * @param secondPlayer le joueur 2
     * initialisation du joueur courant au joueur 1
     */
    
    public AbstractGame(Player firstPlayer,Player secondPlayer){
        this.firstPlayer  =firstPlayer;
        this.secondPlayer = secondPlayer;
        this.joueurCourant = firstPlayer;
    }
    @Override
    public Player getCurrentPlayer(){
        return this.joueurCourant;
    }

    protected abstract void doExecute(int x);
    @Override
    public void execute(int x){
        doExecute(x);
        if(this.joueurCourant == this.firstPlayer){
            this.joueurCourant = this.secondPlayer;
        }
        else{
            this.joueurCourant = this.firstPlayer;
        }
    }
}