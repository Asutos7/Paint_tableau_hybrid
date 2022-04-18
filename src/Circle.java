import java.awt.*;

public class Circle extends Ellipse{
    public Circle(int px, int py, Color c){
        super(px, py, c);
    }

    public void setBoundingBox(int heightBB, int widthBB) {
        int max = Math.max(heightBB, widthBB);
        int min = Math.min(heightBB, widthBB);
        int signheight = (int) Math.signum(heightBB);
        int signwidth = (int) Math.signum(widthBB);
        if (Math.abs(min) > Math.abs(max)) {
            super.semiAxisX = signwidth*Math.abs(min);
            super.semiAxisY = signheight*Math.abs(min);
        } else {
            super.semiAxisX = signwidth*Math.abs(max);
            super.semiAxisY = signheight*Math.abs(max);
        }
    }
}
