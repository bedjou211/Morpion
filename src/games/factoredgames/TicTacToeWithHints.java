package games.factoredgames;
import java.util.*;
/**
 * 
 * @author celina
 *Cette classe represnete un jeu de morpion avec indications
 */
public class TicTacToeWithHints extends TicTacToe{
	/**
	 * 
	 * @param firstPlayer le joueur 1
	 * @param secondPlayer le joueur 2
	 */
    public TicTacToeWithHints(String firstPlayer,String secondPlayer){
        super(firstPlayer,secondPlayer);
    }
    /**
     * 
     * @return une liste des coups danger
     */
    public ArrayList<Integer> hints(){
        ArrayList<Integer> liste = new ArrayList<Integer>();
        //si la plateau est vide et le nombre de cases non vides  inferieure a 3 c'est inutile de le tester
        if(validMoves().size()<=6){ //nombre de cases vide inferieure ou égale a 6 donc on teste
            String joueurAdversaire =null ;
            if(getCurrentPlayer()==this.firstPlayer) // au lieu de dupliquer le code pour le joueur 1 et 2 on  pourra creer une variable joueurAdversaire null et de lui affecter le joueur adversaire du joueur courant 
                joueurAdversaire = this.secondPlayer;
            else
                joueurAdversaire = this.firstPlayer;
            for(int coup : validMoves()){ // simuler tous les coups qui sont valides c'est a dire les coups qui appartiennent a la liste retourner par la fonction validMoves
                tab[ligne(coup)][colonne(coup)] = joueurAdversaire;
                if(getWinner() == joueurAdversaire){ //match terminer le gagnant est le joueurAdversaire donc on peut l'ajouter a la liste 
                    liste.add(coup);
                }
                tab[ligne(coup)][colonne(coup)] = null;  //annuler le coup simuler 
            }
               
            
        }
        return liste;
    }
    @Override
    public String situationToString(){
            String chaine="";
            for (int i = 1 ; i<= 3 ; i++){
                chaine += " "+ i;
            }
            chaine += System.lineSeparator();
            for(int i =0;i<tab.length;i++){
                chaine += (i+1);
                for(int j= 0;j<tab[0].length;j++){
                    if(this.tab[i][j] == null){
                        if(hints().contains(3*i+j)){ //j'ai remarqué que la relation entre i:ligne et j:colonne avec le coup concerner est 3*i+j par exemple le coup 0 =3*0+0 
                            chaine = chaine +" "+"!";
                        }
                        else{
                            chaine = chaine +" "+".";
                        }
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




}