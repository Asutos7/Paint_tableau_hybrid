import java.io.IOException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener{
    public Color c;
    // list sert à garder les figures qui doivent être affichées
    public ArrayList<Figure> list = new ArrayList<>();
    // liste x pour les positions en x des points
    public ArrayList<Integer> listx = new ArrayList<>();
    //liste y pour les positions y des points
    public ArrayList<Integer> listy = new ArrayList<>();

    public String nameFigure;

    // coordonnées pour la souris
    public int x;
    public int y;

    public boolean saveCanceled = false;

    //coordonées utilisées dans Trace
    public int u;
    public int v;

    //coordonées utilisées dans LigneHorizontal et LigneVertical
    public int x1;
    public int x2;
    public int y1;
    public int y2;

    public void setColor(Color c){
        this.c = c;
    }

    public void setNameFigure(String nameFigure) {
        this.nameFigure = nameFigure;
    }


    //Constructeur de la classe
    public Drawing() {
        this.setBackground(Color.white);
        this.x = 0;
        this.y = 0;
        list.add(new Rectangle(0, 0, Color.BLACK));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e){
        //
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();

        //System.out.println("Creation of a new " + nameFigure + " coloured " + c + " and originating from :" + x + " " + y);
        switch (nameFigure) {
            case "Ellipse":
                list.add(new Ellipse(x, y, c));
                break;
            case "Circle":
                list.add(new Circle(x, y, c));
                break;
            case "Circle2":
                list.add(new Circle2(x, y, Color.BLACK));
                ((Figure) this.list.get(this.list.size() - 1)).setBoundingBox(e.getY() - this.y, e.getX() - this.x);
                this.repaint();
                break;
            case "LineVertical":
                Coordonnes2 cd3 = new Coordonnes2();
                x1=cd3.getX1();
                x2=cd3.getX2();
                y1=cd3.getY1();
                y2=cd3.getY2();
                list.add(new LineVertical(x1, y1, c));
                ((Figure) this.list.get(this.list.size() - 1)).setBoundingBox(y2 - y1, x2 - x1);
                this.repaint();
                break;
            case "LineHorizontal":
                Coordonnes2 cd4 = new Coordonnes2();
                x1=cd4.getX1();
                x2=cd4.getX2();
                y1=cd4.getY1();
                y2=cd4.getY2();
                list.add(new LineHorizontal(x1, y1, c));
                ((Figure) this.list.get(this.list.size() - 1)).setBoundingBox(y2 - y1, x2 - x1);
                this.repaint();
                break;
            case "Eraser":
                list.add(new Eraser(x, y));
                break;
            case "Trace":
                Coordonnees cd2 = new Coordonnees();
                u=cd2.getX();
                v=cd2.getY();
                list.add(new Circle2(u, v, c));
                ((Figure) this.list.get(this.list.size() - 1)).setBoundingBox(e.getY() - this.y, e.getX() - this.x);
                this.repaint();
                break;
            case "ReadCsv":
                MyCSVReader read = null;
                try {
                    read = new MyCSVReader();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                ArrayList<Integer> listIntermediaire = read.getList();
                for (int j=0;j<listIntermediaire.size();j++){
                    if(j%2==0){
                        listx.add(listIntermediaire.get(j));
                    }
                    else{
                        listy.add(listIntermediaire.get(j));
                    }
                }
                for (int i=0;i<listx.size();i++) {
                    x=listx.get(i);
                    System.out.println(x);
                    y=listy.get(i);
                    System.out.println(y);
                    list.add(new Circle2(x, y, c));
                    ((Figure) this.list.get(this.list.size() - 1)).setBoundingBox(e.getY() - this.y, e.getX() - this.x);
                    this.repaint();
                }
                break;

        }
    }

    @Override
    public void mouseReleased(MouseEvent e){

    }

    @Override
    public void mouseEntered(MouseEvent e){

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


    // une méthode définie dans la classe MouseEvent
    // en restant appuyer sur la souris, la méthode fait appel à différentes actions en fonction de case choisie précedemment
    @Override
    public void mouseDragged(MouseEvent e) {
        if (nameFigure == "Eraser") {
            list.add(new Eraser(e.getX(), e.getY()));
            this.repaint();
        }
        else if(nameFigure.equals("Circle2")||nameFigure.equals("Trace")||nameFigure.equals("Line")||nameFigure.equals("LineHorizontal")||nameFigure.equals("Dessin")||nameFigure.equals("Read")){
        }
        else {
            ((Figure) this.list.get(this.list.size() - 1)).setBoundingBox(e.getY() - this.y, e.getX() - this.x);
            this.repaint();
        }

    }

    // paintComponent scanne chaque objet de l'ArrayList pour appeler la méthode draw afin de dessiner
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.setBackground(Color.white);
        Iterator nameFigure = this.list.iterator();

        while (nameFigure.hasNext()) {
            Figure f = (Figure) nameFigure.next();
            f.draw(g);
        }
    }

    // save sert à sauvegarder
    public void save() {
        JFileChooser fileChooser = new JFileChooser();
        JOptionPane info = new JOptionPane();
        info.showInternalMessageDialog( info, "Please save only in the Project Directory",
                "Warning",JOptionPane.INFORMATION_MESSAGE);
        int rVal = fileChooser.showOpenDialog(this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            // Creates a file output stream to write to the file represented by the specified File object
            FileOutputStream fos = null;
            try {
                fos = new FileOutputStream(fileChooser.getSelectedFile().getPath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            //An ObjectOutputStream writes primitive data types and graphs of Java objects to an OutputStream
            ObjectOutputStream oos = null;
            try {
                oos = new ObjectOutputStream(fos);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                oos.writeInt(this.list.size());
            } catch (IOException e) {
                e.printStackTrace();
            }

            for(Figure f: this.list) {
                try {
                    oos.writeObject(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.saveCanceled = false;
        } else if (rVal == JFileChooser.APPROVE_OPTION) {
            this.saveCanceled = true;
        }

    }

    // open est  une méthode qui permet d'ouvrir notre projet
    public void open() {
        JFileChooser fileChooser = new JFileChooser();
        int rVal = fileChooser.showOpenDialog(this);
        if (rVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fis = new FileInputStream(fileChooser.getSelectedFile().getName());
                // An ObjectInputStream deserializes primitive data and objects previously written using an ObjectOutputStream
                ObjectInputStream ois = new ObjectInputStream(fis);
                int size = ois.readInt();
                for(int i = 0; i < size; ++i) {
                    //System.out.println("open");
                    list.add((Figure)ois.readObject());
                }
                ois.close();
                // affichage du contenu
                repaint();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("File could not be opened");
            }
        }

    }

    // nouveau est une méthode qui permet de créer une nouvelle page
    public void nouveau() {
        // showConfirmDialog permet de demander à l'utilisateur d'accepter oui ou non ou d'annuler la demande (ici de sauvegarder)
        int result = JOptionPane.showConfirmDialog(this, "Do you want to save the modifications ?", "Save ?", 0, 3);
        // si result=YES_OPTION, cela signifie que result == 0
        // si result=NO_OPTION, cela signifie que result == 1
        if (result == 0) {
            this.save();
            if (!this.saveCanceled) {
                this.list = new ArrayList();
                this.repaint();
            }
        } else if (result == 1) {
            this.list = new ArrayList();
            this.repaint();
        }

    }

    public static void main(String[] args) {
    }
}
