package games.plays;
import gamestests.plays.OrchestratorTests;
/**
 * 
 * @author celina
 * Cette classe est une classe classe executable pour tester les fonctions réalisées dans le package games.plays
 */
public class Test{
    public static void main(String[] args){
        boolean ok = true;
        OrchestratorTests tester = new OrchestratorTests();
        ok = ok && tester.testPlay(false);
        System.out.println(ok ? "All␣tests␣OK" : "At␣least␣one␣test␣OK");
    }
}