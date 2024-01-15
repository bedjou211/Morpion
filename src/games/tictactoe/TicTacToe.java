package games.tictactoe;
import java.util.*;
/**
 * 
 * @author celina
 *Cette classe représente une situatuin du jeu de morpion
 */
public class TicTacToe{

    protected String firstPlayer;
    protected String secondPlayer;
    protected String joueurCourant;
    protected String[][] tab;
    /**
     * 
     * @param firstPlayer le joueur 1
     * @param secondPlayer le joueur 2
     * initialisation du plateau de jeu
     */
    public TicTacToe(String firstPlayer,String secondPlayer){
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.tab = new String[3][3];
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
     * @param x le coup à éxécuter 
     * Change le joueur courant et le plateur de jeu en éxécutant le coup x 
     */
    public void execute(int x){
        
        this.tab[ligne(x)][colonne(x)] = this.joueurCourant;
        if(this.joueurCourant == firstPlayer){
            this.joueurCourant = secondPlayer;
        }else{
            this.joueurCourant = firstPlayer;
        }
    }
    /**
     * 
     * @param x le coup qu'on veut jouer
     * @return true si le coup peut etre joué false sinon
     */
    public boolean isValid(int x){
        int i = ligne(x);
        int j = colonne(x);
        if(tab[i][j] == null){
            return true;
        }
        return false;

    }
    /**
     * 
     * @return les coup valides
     */
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
    public boolean wins(String joueur,int row,int column,int deltaRow,int deltaColumn){
        if( 0<=row+2*deltaRow  && row+2*deltaRow<3 && 0<=column+2*deltaColumn && column+2*deltaColumn<3  ){
            if(this.tab[row][column] == joueur && this.tab[row+deltaRow][column+deltaColumn]==joueur && this.tab[row+2*deltaRow][column+2*deltaColumn]==joueur){
                return true;
            }
        }
        return false;
    }
    /**
     * 
     * @return le joueur ayant gagné la partie sinon null
 	*/
    public String getWinner(){ 
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
    /**
     * 
     * @return true si la partie est finie false sinon
     */
    public boolean isOver(){
        if(getWinner()!=null){
            return true ;//partie terminer
        }
        else if(validMoves().isEmpty()){
            return true; //match null
        }
        return false; //match non terminer
    }

    /**
     * 
     * @param coup le coup
     * @return la représentation du coup sous forme de chaine de caractere
     */
    public String moveToString(int coup){
        return "("+(ligne(coup)+1)+","+(colonne(coup)+1)+")";
    }
    /**
     * 
     * @return la representation de la situation sous forme de chaine de caractere
     */
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

}
