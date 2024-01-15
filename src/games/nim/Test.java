package games.nim;
import gamestests.nim.NimTests ;
public class Test{
    
    public static void main(String[] args){
       
        boolean ok = true ;
        NimTests nimTester = new NimTests();
        ok = ok && nimTester.testGetInitialNbMatches();
        ok = ok && nimTester.testGetCurrentNbMatches();
        ok = ok && nimTester.testGetCurrentPlayer();
        ok = ok && nimTester.testRemoveMatches();
        ok = ok && nimTester.testIsValid();
        ok = ok && nimTester.testIsOver();
        ok = ok && nimTester.testGetWinner();
        System.out.println( ok ? " All ␣ tests ␣ OK " : " At ␣ least ␣ one ␣ test ␣ KO " );
   }
}
