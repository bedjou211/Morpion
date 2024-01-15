package games.genericgames;
import java.util.*;
import games.players.*;
/**
 * 
 * @author celina
 *Cette classe représente une situatuin du jeu de morpion
 */
public class TicTacToe extends AbstractGame{

    protected Player[][] tab;
    /**
     * 
     * @param firstPlayer le joueur 1
     * @param secondPlayer le joueur 2
     * initialisation du plateau de jeu
     */
	public TicTacToe(Player firstPlayer,Player secondPlayer){
        super(firstPlayer,secondPlayer);
        this.tab = new Player[3][3];
        
    }
    @Override
    public Player getCurrentPlayer(){
        return this.joueurCourant;
    }
    /**
     * 
     * @param x le numéro d'une case dans le plateau de jeu
     * @return la ligne où se trouve x dans le plateau de jeu
     */
    public int ligne(int x){
        return x/3;
    }
    /**
     * 
     * @param x le numéro d'une case dans le plateau de jeu
     * @return la colonne où se trouve x dans le plateau de jeu
     */
    public int colonne(int x){
        return x-3*ligne(x);

    }
    /**
     * 
     * @return tab
     */
    public Player[][] getTab() {
		return tab;
	}
    
    @Override
    public void doExecute(int x){
        this.tab[ligne(x)][colonne(x)] = this.joueurCourant;
    }

    @Override
    public boolean isValid(int x){
        int i = ligne(x);
        int j = colonne(x);
        if(tab[i][j] == null){
            return true;
        }
        return false;

    }
    @Override
    public ArrayList<Integer> validMoves(){
        ArrayList<Integer> liste = new ArrayList<Integer>();
            for(int i =0;i<9;i++){
                if(isValid(i)){
                    liste.add(i);
                }
            }
         return liste;
    }
    /**
     * 
     * @param joueur 
     * @param row
     * @param column
     * @param deltaRow
     * @param deltaColumn
     * @return
     */
    public boolean wins(Player joueur,int row,int column,int deltaRow,int deltaColumn){
        if( 0<=row+2*deltaRow  && row+2*deltaRow<3 && 0<=column+2*deltaColumn && column+2*deltaColumn<3  ){
            if(this.tab[row][column] == joueur && this.tab[row+deltaRow][column+deltaColumn]==joueur && this.tab[row+2*deltaRow][column+2*deltaColumn]==joueur){
                return true;
            }
        }
        return false;
    }
    @Override
    public Player getWinner(){ 
        for(int i =0;i<this.tab.length;i++){
            for(int j= 0;j<this.tab[0].length;j++){
                for(int k=-1;k<2;k++){ //{-1,0,1}
                    for(int h=-1;h<2;h++){ //{-1,0,1}
                        if((k+h!=0 || k*h != 0) && wins(this.tab[i][j],i,j,k,h)==true){
                            return this.tab[i][j];
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean isOver(){
        if(getWinner()!=null){
            return true ;//partie terminer
        }
        else if(validMoves().isEmpty()){
            return true; //match null
        }
        return false; //match non terminer
    }

    @Override
    public String moveToString(int coup){
        return "("+(ligne(coup)+1)+","+(colonne(coup)+1)+")";
    }
    @Override
    public String situationToString(){
        String chaine="";
        for (int i = 1 ; i<= 3 ; i++){
            chaine += " "+ i;
        }
        chaine += System.lineSeparator();
        for(int i =0;i<this.tab.length;i++){
            chaine += (i+1);
            for(int j= 0;j<this.tab[0].length;j++){
                if(this.tab[i][j] == null){
                    chaine = chaine +" "+".";
                }
                if(this.tab[i][j] == this.firstPlayer){
                    chaine = chaine +" "+"O";
                }
                else if(this.tab[i][j] == this.secondPlayer){
                    chaine = chaine +" "+"X";
                }
            }
            chaine += System.lineSeparator();
        }
        return chaine;
    }
    
    //cette methode elle parcourt la liste des coups valides puis elle le coup avec la coordonnee qui lui corespond on utilisant la methode moveToString 
    public void afficheCoupValides(){
        System.out.println("Coups valides :");
        for(int l : validMoves()){
            System.out.println(l+"="+moveToString(l));
        }
    }
    @Override
    public Game copy(){
        TicTacToe n ;
        if(this.getCurrentPlayer()== this.firstPlayer)
            n= new TicTacToe(this.firstPlayer,this.secondPlayer);
        else{
            n= new TicTacToe(this.secondPlayer,this.firstPlayer);
        }
        Player[][] tab;
        tab = new Player[3][3];
        for(int i=0;i<tab.length;i++){
            for(int j=0;j<tab.length;j++){
                tab[i][j] = this.tab[i][j];
            }
        } 
        n.tab = tab;  
        return n;
    }
    @Override
    public boolean equals(Object o) {
    	if(o instanceof TicTacToe) {
    		TicTacToe otherTic = (TicTacToe) o;
    		return  this.getCurrentPlayer().equals(getCurrentPlayer())&&Arrays.deepEquals(tab, otherTic.getTab());
    	}
    	else
    		return false;
    	
    }
    @Override
    public int hashCode() {
		return Objects.hash(this.getCurrentPlayer(),Arrays.deepHashCode(tab));
    	
    }
}