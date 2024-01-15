Informations Personnelles :
Nom : BEDJOU
Prénom : Celina
N° étudiant : 22112538

Informations utile sur le code :

mode d'emploi :


liste des classes exécutables : 
		*package plays : MainOrchestratorDemo.java
		
		
Compilation & éxecution( on se positionne dans le dossier src/games):
	*MainOrchestratorDemo:
	 ->compilation :javac -d ../../build -cp ../../lib/gamestests.jar plays/*.java players/*.java  genericgames/*.java
	 ->execution : java -cp ../../build games.plays.MainOrchestratorDemo
	

Compilation & execution des tests (on se positionne dans le dossier src/games + Les libraries des test devront etre placées dans le dossier lib):
	>compilation de tous les packages :javac -d ../../build -cp ../../lib/gamestests.jar plays/*.java players/*.java  genericgames/*.java 
	
	>execution package genericgames :
	
	java -cp "../../build:../../lib/gamestests.jar"  games.genericgames.Test
	
	>execution package players :
	
	**pour execution class humain + random :
	java -cp "../../build:../../lib/gamestests.jar"  games.players.test
	**pour executer class negamaxplayer + negamaxplayerwithcache :
	java -cp "../../build:../../lib/gamestests.jar"  games.players.Test
	
	>execution package plays :
	
	java -cp "../../build:../../lib/gamestests.jar"  games.plays.Test
	
	
	
	
	
petite precision dossier doc contient la java doc du projet faite on s'inspirant du  site Générateur de documentation >> http://www.metz.supelec.fr  apartir de la commande javadoc *. java -d Doc pour l'ouvrire il suffit d'ouvrir le fichier index.html.
	
	
	
	
	
	
	
	
	
	
	
