import java.awt.*;

public class Eraser extends Figure {

    public Eraser(int px, int py){
        super(Color.WHITE,new Point(px,py));
    }

    protected int semiAxisX = 20;
    protected int semiAxisY = 20;

    @Override
    public void setBoundingBox(int length, int width){
        this.semiAxisX = length;
        this.semiAxisY = width;
    }

    public void draw(Graphics g) {
        int px = this.getP().getX();
        int py = this.getP().getY();
        g.setColor(Color.WHITE);
        g.fillOval(px, py, this.semiAxisX, this.semiAxisY);
    }
}
