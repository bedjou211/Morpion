package games.genericgames;
import gamestests.genericgames.AbstractGameTests;
import gamestests.genericgames.NimTests;
import gamestests.genericgames.TicTacToeTests;
import gamestests.genericgames.TicTacToeWithHintsTests;
/**
 * 
 * @author celina
 * Cette classe est une classe classe executable pour tester les fonctions réalisées dans le package games.genericgames
 */
public class Test{
    public static void main(String[] args){
                
        boolean ok = true;
        AbstractGameTests abstractGameTester = new AbstractGameTests();
        ok = ok && abstractGameTester.testGetCurrentPlayer();
        ok = ok && abstractGameTester.testExecute();
        NimTests nimTester = new NimTests();
        ok = ok && nimTester.testGetInitialNbMatches();
        ok = ok && nimTester.testGetCurrentNbMatches();
        ok = ok && nimTester.testGetCurrentPlayer();
        ok = ok && nimTester.testExecute();
        ok = ok && nimTester.testIsValid();
        ok = ok && nimTester.testValidMoves();
        ok = ok && nimTester.testIsOver();
        ok = ok && nimTester.testGetWinner();
        ok = ok && nimTester.testCopy();
        TicTacToeTests ticTacToeTester = new TicTacToeTests();
        ok = ok && ticTacToeTester.testGetCurrentPlayer();
        ok = ok && ticTacToeTester.testExecuteAndIsValid();
        ok = ok && ticTacToeTester.testValidMoves();
        ok = ok && ticTacToeTester.testWins();
        ok = ok && ticTacToeTester.testGetWinner();
        ok = ok && ticTacToeTester.testIsOver();
        ok = ok & ticTacToeTester.testCopy();
        // Si la classe TicTacToeWithHints existe (exercice optionnel)
        TicTacToeWithHintsTests ticTacToeWithHintsTester
        = new TicTacToeWithHintsTests();
        ok = ok && ticTacToeWithHintsTester.testGetCurrentPlayer();
        ok = ok && ticTacToeWithHintsTester.testExecuteAndIsValid();
        ok = ok && ticTacToeWithHintsTester.testValidMoves();
        ok = ok && ticTacToeWithHintsTester.testWins();
        ok = ok && ticTacToeWithHintsTester.testGetWinner();
        ok = ok && ticTacToeWithHintsTester.testIsOver();
        ok = ok && ticTacToeWithHintsTester.testHints();
        ok = ok & ticTacToeWithHintsTester.testCopy();
        System.out.println ( ok ? " All ␣ tests ␣ OK " : " At ␣ least ␣ one ␣ test ␣ KO " );
    }
}
