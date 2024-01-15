package games.tictactoe;
import java.util.Scanner;
/**
 * Clette classe est une classe de démo des fonctionalités réalisées dans le package gmaes.tictactoe
 */
public class MainMorpion{
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in); 

        int coup ;
        String answer;

        System.out.println("Voullez vous jouer avec les indices ?");
        answer = scanner.next();

        TicTacToe game ;

        if( answer.equals("oui")) {
            game = new TicTacToeWithHints("Mike","Celina");
        }else{
            game = new TicTacToe("Mike","Celina");
        }
           
        System.out.println(game.situationToString());
        
        while(!game.isOver() ){
            System.out.println("C’est à "+game.getCurrentPlayer()+" de jouer");
            game.afficheCoupValides();
            System.out.println("Votre  coup ? : ");
            coup = scanner.nextInt();
            if((coup<9 || coup>=0 ) && game.isValid(coup)){
                game.execute(coup);
                System.out.println(game.situationToString());
            }
            else{
                System.out.println("Coup invalide !!!!!!");
            }

        }
        if(game.getWinner()==null){
            System.out.println("match null");
        }
        else {
            System.out.println("Vainqeur "+game.getWinner());
        }

        scanner.close ();
    }
}