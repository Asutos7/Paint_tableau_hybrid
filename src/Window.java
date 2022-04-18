import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Cette classe sert à l'affichage d'une fenêtre
public class Window extends JFrame implements ActionListener{
    Drawing draw  = new Drawing();
    public Window(String Title, int x, int y){
        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container contentPanel = this.getContentPane();
        Container contentPanel2 = this.getContentPane();

        JMenuBar m = new JMenuBar();

        //Création des boutons du menu
        JMenu menu1 = new JMenu("File");
        JMenuItem nouveau = new JMenuItem("New");
        JMenuItem save = new JMenuItem("Save");
        JMenuItem quit = new JMenuItem("Exit");
        JMenuItem open = new JMenuItem("Open");
        JMenuItem readcsv = new JMenuItem("ReadCsv");

        nouveau.addActionListener(this);
        open.addActionListener(this);
        save.addActionListener(this);
        quit.addActionListener(this);
        readcsv.addActionListener(this);

        //Ajouter les boutons dans le menu
        menu1.add(nouveau);
        menu1.add(save);
        menu1.add(quit);
        menu1.add(open);
        menu1.add(readcsv);
        m.add(menu1);

        //Barre de tâche en bas de l'écran
        JPanel SouthPanel = new JPanel();
        SouthPanel.setLayout(new GridLayout(2,6));

        // Création des boutons dans la barre de tâche en bas
        JButton noir = new JButton("Noir");
        noir.addActionListener(this);
        JButton rouge = new JButton("Rouge");
        rouge.addActionListener(this);
        JButton line = new JButton("LineVertical");
        line.addActionListener(this);
        JButton lineH = new JButton("LineHorizontal");
        lineH.addActionListener(this);
        JButton cercle = new JButton("Circle");
        cercle.addActionListener(this);
        JButton cercle2 = new JButton("Circle2");
        cercle2.addActionListener(this);
        JButton coordonnees = new JButton("Trace");
        coordonnees.addActionListener(this);
        noir.setBackground(Color.BLACK);
        rouge.setBackground(Color.RED);

        //Affichage des boutons sur le bas de l'écran
        SouthPanel.add(noir);
        SouthPanel.add(rouge);
        SouthPanel.add(line);
        SouthPanel.add(lineH);
        SouthPanel.add(cercle);
        SouthPanel.add(cercle2);
        SouthPanel.add(coordonnees);
        SouthPanel.add(quit);
        contentPanel.add(SouthPanel,"South");

        //Affichage  des boutons sur le haut
        JPanel NorthPanel = new JPanel();
        JButton gomme = new JButton("Eraser");
        gomme.addActionListener(this);
        NorthPanel.add(gomme);
        contentPanel2.add(NorthPanel, "North");

        setJMenuBar(m);

        //affichage des barres de tâhes
        SouthPanel.setVisible(true);
        NorthPanel.setVisible(true);

        //surface pour dessiner
        contentPanel.add(draw,"Center");
        this.setVisible(true);

    }

    // Réalisation des actions des différents boutons créés
    @Override
    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Noir":
                System.out.println("La couleur noire est sélectionnée !");
                draw.setColor(Color.black);
                break;
            case "Rouge":
                System.out.println("La couleur rouge est sélectionnée !");
                draw.setColor(Color.red);
                break;
            case "Eraser":
                System.out.println("La gomme est sélectionnée !");
                draw.setNameFigure("Eraser");
                break;
            case "New":
                this.draw.nouveau();
                break;
            case "Open":
                this.draw.open();
                break;
            case "Save":
                this.draw.save();
                break;
            case "ReadCsv":
                System.out.println("ReadCsv est sélectionnée !");
                draw.setNameFigure("ReadCsv");
                break;
            case "Exit":
                System.out.println("Exit est sélectionnée !");
                this.dispose();
                break;
            case "Point":
                System.out.println("Point est sélectionnée !");
            case "LineVertical":
                System.out.println("La figure line est sélectionnée !");
                draw.setNameFigure("LineVertical");
                break;
            case "LineHorizontal":
                System.out.println("La figure lineHorizontal est sélectionnée !");
                draw.setNameFigure("LineHorizontal");
                break;
            case "Circle":
                System.out.println("La figure cercle est sélectionnée !");
                draw.setNameFigure("Circle");
                break;
            case "Circle2":
                System.out.println("La figure cercle2 est sélectionnée !");
                draw.setNameFigure("Circle2");
                break;
            case "Trace":
                System.out.println("Trace est sélectionnée !");
                draw.setNameFigure("Trace");
                break;
        }


    }

    public static void main(String args[]){
        Window win = new Window("Paint",800,600);
    }
}