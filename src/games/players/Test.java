package games.players;

import gamestests.players.NegamaxPlayerTests;
import gamestests.players.NegamaxPlayerWithCacheTests;
/**
 * 
 * @author celina
 * Cette classe est une classe classe executable pour tester les fonctions réalisées dans le package games.players
 */
public class Test {

	public static void main(String[] args) {
		boolean ok = true;
		NegamaxPlayerTests negamaxTester = new NegamaxPlayerTests();
		ok = ok && negamaxTester.testEvaluate();
		ok = ok && negamaxTester.testChooseMove();
		//optionnel
		NegamaxPlayerWithCacheTests negamaxWithCacheTester
		= new NegamaxPlayerWithCacheTests();
		ok = ok && negamaxWithCacheTester.testNimEquals();
		ok = ok && negamaxWithCacheTester.testNimHashCode();
		ok = ok && negamaxWithCacheTester.testTicTacToeEquals();
		ok = ok && negamaxWithCacheTester.testTicTacToeHashCode();
		ok = ok && negamaxWithCacheTester.testEvaluate();
		ok = ok && negamaxWithCacheTester.testChooseMove();
		System.out.println(ok ? "All tests OK" : "At least one test KO");

	}

}
