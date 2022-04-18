import java.io.Serializable;

public class Point implements Serializable {

    private int x;
    private int y;


    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString(){
        return "(X,Y) = "+"("+this.x+","+this.y+")";
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
