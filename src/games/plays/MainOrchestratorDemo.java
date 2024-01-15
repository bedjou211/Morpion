package games.plays;

import java.util.Random;
import java.util.Scanner;

import games.genericgames.Game;
import games.genericgames.Nim;
import games.genericgames.TicTacToe;
import games.players.Human;
import games.players.NegamaxPlayer;
import games.players.NegamaxPlayerWithCache;
import games.players.Player;
import games.players.RandomPlayer;

/**
 * Clette classe est une classe de démo des fonctionalités réalisées dans le package gmaes.plays
 */
public class MainOrchestratorDemo {

	public static void main(String[] args) {
		Random rand = new Random(123);
		Scanner scanner=new Scanner(System.in);
		Game game ;

		Player player1 ;
		Player player2 ;
		System.out.println("Si vous voulez jouer:\nhumain vs random tapez 1\nhumain vs humain tapez 2\nrandom vs random tapez 3\nnegamax vs random tapez 4\nnegamax avec cache vs random tapze 5");
		int choice = scanner.nextInt();
		while(choice >5 || choice <1 ) {
			System.out.println("Saise incorrect reéssayez :");
			choice = scanner.nextInt();
							
		}
		switch (choice){
		case 1:
			player1 = new Human("Moi", scanner);
			player2 = new RandomPlayer(rand);
			break;
			case 2 :
				player1 = new Human("humain1", scanner);
				player2 = new Human("humain2", scanner);
				break;
			case 3:
				player1 = new RandomPlayer(rand);
				player2 = new RandomPlayer(rand);
				break;
			case 4:
				player1 = new NegamaxPlayer();
				player2 = new RandomPlayer(rand);
				break;
			case 5:
				player1 = new NegamaxPlayerWithCache();
				player2 = new RandomPlayer(rand);
				break;
			default :
				player1 = new Human("Moi", scanner);
				player2 = new RandomPlayer(rand);
				break;
		}
		choice = -1;
		System.out.println("Choix de jeu:\njeu de nim tapez 1\njeu de TicTacToe tapez 2");
		choice = scanner.nextInt();
		while (choice>2 || choice < 0) {
			System.out.println("Saise incorrect reéssayez :");
			choice = scanner.nextInt();
		}
		switch (choice){
		case 1:
			game = new Nim(14, 3, player1, player2);
			break;
		case 2 :
			game = new TicTacToe(player1, player2);
			break;
		default:
			game = new TicTacToe(player1, player2);
			break;
		}
		
		Orchestrator orchestrator = new Orchestrator(game);
		orchestrator.play();
		scanner.close();
	}

}
