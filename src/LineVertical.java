import java.awt.*;

// Création de lignes verticales en rentrant dans la console, ie la position du point de départ et la position du point d'arrivée
public class LineVertical extends Figure{
    private int length=0;
    private int width=0;
    public LineVertical(int px, int py, Color c){
        super(c,new Point (px,py));
    }




    @Override
    public void setBoundingBox(int widthBB, int lengthBB) {
        width=widthBB;
        length=lengthBB;
    }

    @Override
    public void draw(Graphics g){
        Color c = this.getC();
        int px = this.getP().getX();
        int py = this.getP().getY();
        int length = this.getWidth();
        int width = 2;
        g.setColor(c);
        System.out.println(width);
        System.out.println(length);

        if (width > 0 && length > 0) {
            g.fillRect(px, py, width, length);
        } else if (width > 0 && length < 0) {
            g.fillRect(px, py + length, width, -length);
        } else if (width < 0 && length > 0) {
            g.fillRect(px + width, py, -width, length);
        } else {
            g.fillRect(px + width, py + length, -width, -length);
        }

    }

    public int getWidth(){
        return width;
    }

    public int getLength(){
        return length;
    }

    public static void main(String[] args) {
    }

}
