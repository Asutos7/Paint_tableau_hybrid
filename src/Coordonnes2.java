import java.util.Scanner;

// Classe qui sert à tracer les lignes verticaux ou horizontaux
// Il suffit de rentrer dans la console le point de départ et le point d'arrivée pour tracer
public class Coordonnes2 {

    private int x1=0;
    private int y1=0;
    private int x2=0;
    private int y2=0;


    public Coordonnes2(){
        while(y1==0){
            System.out.println("Entrez x1");
            Scanner scan = new Scanner(System.in);
            x1 = scan.nextInt();
            System.out.println("Entrez y1");
            Scanner scan2 = new Scanner(System.in);
            y1 = scan2.nextInt();
            System.out.println("Entrez x2");
            Scanner scan3 = new Scanner(System.in);
            x2 = scan3.nextInt();
            System.out.println("Entrez y2");
            Scanner scan4 = new Scanner(System.in);
            y2 = scan4.nextInt();
            System.out.println("x="+x1+";y="+y1);

        }
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    //public static void main(String[] args){
    //new Coordonnees();
    //}
}