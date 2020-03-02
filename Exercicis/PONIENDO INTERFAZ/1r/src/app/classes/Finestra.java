package app.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Finestra extends JFrame {
    JPanel panell;
    
    private static final long serialVersionUID = 1L;


    public Finestra(){
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1200, 900);
        //this.setLocation(400, 100);
        this.setBounds(400, 100, 1200 ,900);                  // LAS DOS ANTERIORES JUNTAS;
        this.setLocationRelativeTo(null);                       // TOTALMENTE CENTRADA
        this.setMinimumSize(new Dimension(800,500));
        this.setMaximumSize(new Dimension(1080,1080));
        //this.setResizable(false); NO USAR JAMAS
        this.getContentPane().setBackground(Color.ORANGE);
        
        this.setTitle("Título del programucho...");


        inizialitzaComponents();

    }

    public void inizialitzaComponents(){
        posarPanells();
        // posarLabels();
        posarBtons();
    }


    public void posarPanells(){
        panell = new JPanel();
        this.getContentPane().add(panell);
        panell.setLayout(null);
        panell.setBackground(Color.white);
    }

    public void posarLabels(){
        JLabel etiqueta = new JLabel("Esto no ezta bien");
        // etiqueta.setText("Esto no ezta bien");
        etiqueta.setBounds(0, 0, 380, 70);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.white);
        etiqueta.setBackground(Color.black);     
        etiqueta.setOpaque(true);
        etiqueta.setFont(new Font("Purisa",Font.BOLD, 25));
        
        ImageIcon imatge = new ImageIcon("AT_Logo.png");
        // JLabel etiqueta2 = new JLabel(new ImageIcon("AT_Logo.png"));
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(0, 100, 290 ,169);

        ImageIcon imgReduida = new ImageIcon(imatge.getImage().getScaledInstance(63, 127, Image.SCALE_AREA_AVERAGING));
        etiqueta2.setIcon(imgReduida);

        this.panell.add(etiqueta2);
        this.panell.add(etiqueta);

    }


    public void posarBtons(){
        JButton boto = new JButton("Click!");
        boto.setBounds(100,100,200,100);
        boto.setEnabled(true);              // PODEMOS DESHABILITARLO HASTA TENER A TODA SU FAMILIA
        boto.setMnemonic('a');              // Alt + a

        boto.setForeground(Color.blue);
        boto.setFont(new Font("Purisa",Font.ITALIC, 25));

        this.panell.add(boto);
    }

}