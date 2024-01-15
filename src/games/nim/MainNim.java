package games.nim;
import java.util.Scanner;
/**
 * 
 * @author celina
 *Cette classe est une classe de demo du jeu de nim
 */
public class MainNim{
    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in); 

        System.out.println("veuillez saisir le nombre n(tas d'allumettes)  : ");
        int n = scanner.nextInt();
        

        System.out.println("veuillez saisir le nombre k  : ");
        int k = scanner.nextInt();
        

        System.out.println("veuillez saisir le joueur 1 : ");
        String j1 = scanner.next();
        

        System.out.println("veuillez saisir le joueur 2 : ");
        String j2 = scanner.next(); 
 
        Nim game = new Nim(n,k,j1,j2);

        while (game.isOver() == false){
            System.out.println("veuillez saisir le coup : ");
            String couP = scanner.next();
            int coup = Integer.parseInt(couP);
            if(game.isValid(coup) == true){
                game.removeMatches(coup);
                System.out.println(game.situationToString());
            }
           
        }
        System.out.println("le gagnant est :"+ game.getWinner());
        scanner.close();
    }

}