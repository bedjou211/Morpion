package games.tictactoe;
import gamestests.tictactoe.TicTacToeTests ;
import gamestests .tictactoe.TicTacToeWithHintsTests ;
/**
 * 
 * @author celina
 * Cette classe est une classe classe executable pour tester les fonctions réalisées dans le package games.tictactoe
 */
public class Test{
    public static void main(String[] args){
        boolean ok = true ;
        TicTacToeTests ticTacToeTester = new TicTacToeTests ();
        ok = ok && ticTacToeTester . testGetCurrentPlayer();
        ok = ok && ticTacToeTester . testExecuteAndIsValid ();
        ok = ok && ticTacToeTester . testValidMoves ();
        ok = ok && ticTacToeTester . testGetWinner ();
        ok = ok && ticTacToeTester . testIsOver ();
        
        TicTacToeWithHintsTests tester = new TicTacToeWithHintsTests ();
        ok = ok && tester . testGetCurrentPlayer();
        ok = ok && tester . testExecuteAndIsValid();
        ok = ok && tester . testValidMoves ();
        ok = ok && tester . testWins ();
        ok = ok && tester . testGetWinner ();
        ok = ok && tester . testIsOver ();
        ok = ok && tester . testHints ();
        System . out . println ( ok ? " All ␣ tests ␣ OK " : " At ␣ least ␣ one ␣ test ␣ KO " );
         
 
    }
}
