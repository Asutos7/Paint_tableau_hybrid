import java.util.Scanner;

// Classe qui aide le bouton trace à faire afficher un point grâce à la console
public class Coordonnees {

    private int x=0;
    private int y=0;


    public Coordonnees(){
        while(y==0){
            System.out.println("Entrez x");
            Scanner scan = new Scanner(System.in);
            x = scan.nextInt();
            System.out.println("Entrez y");
            Scanner scan2 = new Scanner(System.in);
            y = scan2.nextInt();
            System.out.println("x="+x+";y="+y);

        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //public static void main(String[] args){
        //new Coordonnees();
    //}
}
