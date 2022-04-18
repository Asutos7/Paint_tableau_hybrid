import java.awt.*;

public class Circle2 extends Ellipse{
    public Circle2(int px, int py, Color c){
        super(px, py, c);
    }

    //on fixe les demi-axes de l'ellipse pour avoir des cercles de dimensions fixes
    public void setBoundingBox(int heightBB, int widthBB) {
        super.semiAxisX = 5;
        super.semiAxisY = 5;
    }
}
