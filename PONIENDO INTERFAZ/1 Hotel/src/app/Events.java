package app;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.*;



public class Events extends JFrame{

    private static final long serialVersionUID = 1L;

    JPanel panellGestio;
    JPanel panellClient;
    JPanel panellBack;


    JLabel jlEtiqueta;

    JPasswordField jtfEntrada1;
    JPasswordField jtfEntrada2;
    JTextField jtfEntrada;
    JCheckBox mostra;

    public Events() {
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);                      
        this.setMinimumSize(new Dimension(1200,700));
        this.setMaximumSize(new Dimension(1200, 700));
        this.getContentPane().setBackground(Color.GRAY);
        this.setBackground(Color.black);
        this.setTitle("Título del programucho...");

        posarPanells();
        entraText1();
        entraText();
        entraText2();
        mostraText();
        mostra();
        listenerAccio();
    }

    public void posarPanells(){
        panellGestio = new JPanel();
        panellGestio.setLayout(null);
        panellGestio.setBackground(Color.white);
        this.getContentPane().add(panellGestio);

        panellClient = new JPanel();
        panellClient.setLayout(null);
        panellClient.setBackground(Color.white);
        this.getContentPane().add(panellClient);

        panellBack = new JPanel();
        panellBack.setLayout(null);
        panellBack.setBackground(Color.white);
        this.getContentPane().add(panellBack);
    }

    private void entraText() {
        jtfEntrada = new JTextField("Nom d'suari");
        jtfEntrada.setBounds(20,20,200,30);
		panell.add(jtfEntrada);
    }
    private void entraText1() {
        jtfEntrada1 = new JPasswordField("");
        jtfEntrada1.setBounds(20,80,200,30);
		panell.add(jtfEntrada1);
    }
    private void entraText2() {
        jtfEntrada2 = new JPasswordField("");
        jtfEntrada2.setBounds(20,120,200,30);
		panell.add(jtfEntrada2);
    }
    private void mostraText() {
        jlEtiqueta = new JLabel();
        jlEtiqueta.setBounds(20,140,400,40);
        panell.add(jlEtiqueta);
    
    }
    private void mostra() {
        mostra = new JCheckBox("Mostra");
        mostra.setBounds(225,78,80,30);
        panell.add(mostra);
    
    }

    private void listenerAccio() {
        KeyListener listener = new KeyListener(){

			@Override
			public void keyReleased(KeyEvent e) {
                String contraUno = "";
                String contraDos = "";

                for (char carac : jtfEntrada1.getPassword()){
                    contraUno = contraUno + carac;
                }
                for (char carac : jtfEntrada2.getPassword()){
                    contraDos = contraDos + carac;
                }

                if (contraUno.equals(contraDos) && contraUno.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")){
                    jlEtiqueta.setText("Contrasenyes iguals i segures");
                }
                else if (contraUno.matches("^.*(?=.{8,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$")) {
                    jlEtiqueta.setText("La contrasenya és segures pero no corresponen...");
                }
                else if (contraUno.equals(contraDos)) {
                    jlEtiqueta.setText("Les contrasenyes son iguals pero poc segures...");
                }
                else {
                    jlEtiqueta.setText("Contrasenyes diferents i poc segures...");
                }
			}

            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
        };


        ItemListener mostraa = new ItemListener(){
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    jtfEntrada2.setEchoChar((char) 0);
                    jtfEntrada1.setEchoChar((char) 0);
                } else {
                    jtfEntrada2.setEchoChar('•');
                    jtfEntrada1.setEchoChar('•');
                }            
            }

        };


        mostra.addItemListener(mostraa);
        jtfEntrada1.addKeyListener(listener);
        jtfEntrada2.addKeyListener(listener);
    }
}
