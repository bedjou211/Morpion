package games.nim;
/**
 * 
 * @author celina
 *Cette classe représente une situatuin du jeu de nim
 */
public class Nim{
    private int n;
    private int k ;
    private String j1;
    private String j2;
    private int nombreCourant;
    private String joueurCourant;
    /**
     * 
     * @param n le nombre initial d'allumettes
     * @param k le nombre maximal d'allumettes qu'on peut retirer
     * @param firstPlayer le joeur 1
     * @param secondPlayer le joueur 2
     * initialisation du jeu
     */
    public Nim(int n,int k,String j1,String j2){
        this.n = n;
        this.k = k;
        this.j1 = j1;
        this.j2 = j2;
        this.nombreCourant = n;
        this.joueurCourant = j1;
    }
    /**
     * 
     * @return le nombre initial d'allumettes
     */

    public int getInitialNbMatches(){
        return this.n;
    }
    /**
     * 
     * @return le nombre d'allumettes restantes
     */
    public int getCurrentNbMatches(){
        return this.nombreCourant;
    }
    /**
     * 
     * @return le joueur courant
     */
    public String getCurrentPlayer(){
        return this.joueurCourant;
    }
    /**
     * @return la representation de la situation en chaine de caracteres
     */
    public String situationToString(){
        return "Il reste "+this.nombreCourant+" allumettes";
    }
    /**
     * 
     * @param nombreAllumettes le nombre d'allumettes à soustraire
     * soustrairen nombreAllumettes du tas si ceci est possible
     */
    public void removeMatches(int nombreAllumettes){
        this.nombreCourant = this.nombreCourant - nombreAllumettes;
        if(this.joueurCourant == this.j1){
            this.joueurCourant = this.j2;
        }
        else{
            this.joueurCourant = this.j1;
        }
    }
    /**
     * 
     * @param nombreAllumettes le nombre d'allumette à soustraire 
     * @return true si le nombreAllumettes peut etre soustrait du tas salse sinon
     */
    public boolean isValid(int nombreAllumettes){
        if(nombreAllumettes >0 && nombreAllumettes<=this.nombreCourant && nombreAllumettes<=this.k){
            return true;
        }
        return false;   
    }
    /**
     * 
     * @return true si la partie est términée false sinon
     */
    public boolean isOver(){
        if(this.nombreCourant == 0){
            return true;
        }
        return false;
    }
    /**
     * 
     * @return le joueur ayant gagné la partie sinon null
 	*/
    public String getWinner(){
        if(isOver() == false){
            return null;
        }
        else{
            if(this.joueurCourant == this.j1){
                return this.j1;
            }
            else{
                return this.j2;
            }
            
        }
    }

}