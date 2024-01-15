package games.plays;
import games.genericgames.*;
/**
 * 
 * @author celina
 *Cette classe represente un arbitre de jeu
 */
public class Orchestrator{
    private Game game;
    /**
     * 
     * @param game le jeu à arbitrer
     */
    public Orchestrator (Game game){
        this.game = game;
    }
    /**
     * simulation du jeu
     */
    public void play(){
        int coup;
        
        while(game.isOver()==false){
            System.out.println(game.situationToString());
            coup = game.getCurrentPlayer().chooseMove(game);
            game.execute(coup);
            
        }
        if(game.getWinner()==null){
            System.out.println("match null");
        }
        else {
            System.out.println("Vainqeur "+game.getWinner());
        }

    }
}