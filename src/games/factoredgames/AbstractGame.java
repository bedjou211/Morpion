package games.factoredgames;
/**
 * 
 * @author celina
 *cette classa est une abstraction d'un Game facotrisé
 */
public abstract class  AbstractGame {

    protected String firstPlayer;
    protected String secondPlayer;
    protected String joueurCourant;
    /**
     * 
     * @param firstPlayer le joueur 1
     * @param secondPlayer le joueur 2
     * initialisation du joueur courant au joueur 1
     */
    public AbstractGame(String firstPlayer,String secondPlayer){
        this.firstPlayer  =firstPlayer;
        this.secondPlayer = secondPlayer;
        this.joueurCourant = firstPlayer;
    }
    /**
     * 
     * @return le joueur courant
     */
    public String getCurrentPlayer(){
        return this.joueurCourant;
    }
    /**
     * 
     * @param x le coup à éxécuter 
     * Change le plateau de jeu en éxécutant le coup x
     */
    protected abstract void doExecute(int x);
    /**
     * 
     * @param x le coup à éxécuter 
     * Change le joueur courant et le plateur de jeu en éxécutant le coup x avec la fontion doExecute
     */
    public void execute(int x){
        doExecute(x);
        if(this.joueurCourant == this.firstPlayer){
            this.joueurCourant = this.secondPlayer;
        }
        else{
            this.joueurCourant = this.firstPlayer;
        }
    }
    /**
     * @return la representation de la situation en chaine de caracteres
     */
    public abstract String situationToString();
    /**
     * 
     * @return true si la partie est finie false sinon
     */
	public abstract boolean isOver();
	/**
    * 
    * @return le joueur ayant gagné la partie sinon null
	*/
	public abstract String getWinner();
	/**
     * 
     * @param x le coup qu'on veut jouer
     * @return true si le coup peut etre joué false sinon
     */
	public abstract boolean isValid(int x) ;
}