import java.awt.*;
import java.io.Serializable;

public abstract class Figure implements Serializable{
    private Color c;
    private Point p;
    private double width; // y size
    private double length; // x size

    public Figure(Color c, Point p){
        this.c=c;
        this.p=p;
    }

    public abstract void setBoundingBox(int length, int width);

    public abstract void draw(Graphics g);

    @Override
    public String toString(){
        return "width" + this.width + "length" + this.length;
    }

    public Color getC(){
        return this.c;
    }

    public Point getP(){
        return this.p;
    }

}
