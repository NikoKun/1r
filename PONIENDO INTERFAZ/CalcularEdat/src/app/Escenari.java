package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;


public class Escenari extends JFrame{

    private static final long serialVersionUID = 1L;

    JPanel panell;
    JButton boto;
    JLabel jlEtiqueta;
    JLabel jlEtiqueta2;
    JLabel jlEtiqueta3;

    JTextField jtfEntrada;


    public Escenari() {
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        this.setSize(800, 500);
        this.setBounds(400, 100, 300 ,500);                  // LAS DOS ANTERIORES JUNTAS;
        this.setLocationRelativeTo(null);                       // TOTALMENTE CENTRADA
        this.setMinimumSize(new Dimension(300,500));
        this.setMaximumSize(new Dimension(1080,1080));
        this.getContentPane().setBackground(Color.ORANGE);
        
        this.setTitle("Título del programucho...");
        posarPanells();
        entraText();
        boto();
        mostraText();
        mostraText2();
        mostraText3();
        listenerAccio();
    }

    public void posarPanells(){
        panell = new JPanel();
        this.getContentPane().add(panell);
        panell.setLayout(null);
        panell.setBackground(Color.white);
    }


    private void entraText() {
        jtfEntrada = new JTextField();
        jtfEntrada.setBounds(20,20,200,30);
		panell.add(jtfEntrada);
    }
    private void boto() {
        boto = new JButton("Calcular");
        boto.setBounds(20,60,100,30);
        panell.add(boto);
    }
    private void mostraText() {
        jlEtiqueta = new JLabel();
        jlEtiqueta.setBounds(20,100,200,30);
        panell.add(jlEtiqueta);
    
    }
    private void mostraText2() {
        jlEtiqueta2 = new JLabel();
        jlEtiqueta2.setBounds(20,150,200,30);
        panell.add(jlEtiqueta2);
    
    }
    private void mostraText3() {
        jlEtiqueta3 = new JLabel();
        jlEtiqueta3.setBounds(20,200,200,30);
        panell.add(jlEtiqueta3);
    
    }

    private void listenerAccio() {
        ActionListener listener1 = new ActionListener(){
    
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] dates = jtfEntrada.getText().split("-");
                LocalDate ara = LocalDate.now();
                LocalDate naix = LocalDate.of(Integer.parseInt(dates[2]), Integer.parseInt(dates[1]), Integer.parseInt(dates[0]));
                Period dif = Period.between(naix, ara);

                jlEtiqueta.setText(String.valueOf(dif.getYears()));
            }
            
        };

        MouseListener listener2 = new MouseListener(){
            @Override
            public void mouseClicked(MouseEvent e) {
                jlEtiqueta2.setText("Click");
                if (e.isAltDown()){
                    jlEtiqueta2.setText("Alt+Click");
                }
                if (e.getClickCount() == 2){
                    jlEtiqueta2.setText("Click x 2");
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                jlEtiqueta2.setText("Entra");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                jlEtiqueta2.setText("Surt");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                jlEtiqueta2.setText("Press");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                jlEtiqueta2.setText("Lliverat");
            }
        };


        MouseMotionListener listener3 = new MouseMotionListener(){
            @Override
            public void mouseDragged(MouseEvent e) {
                jlEtiqueta2.setText("Arrastrant ratolí");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                jlEtiqueta2.setText("Moguent ratolí");
            }
        };

        MouseWheelListener listener4 = new MouseWheelListener(){
            @Override
            public void mouseWheelMoved(MouseWheelEvent arg0) {
                if (arg0.getPreciseWheelRotation()<0){
                    jlEtiqueta2.setText("Roda cap adal \n"+arg0.getPreciseWheelRotation());
                }
                else if (arg0.getPreciseWheelRotation()>0){
                    jlEtiqueta2.setText("Roda cap abaix \n"+arg0.getPreciseWheelRotation());
                }
            }

        };

        KeyListener listener5 = new KeyListener(){

			@Override
			public void keyPressed(KeyEvent e) {
                jlEtiqueta3.setText("Tecla presionada '"+e.getKeyChar()+"'");
			}

			@Override
			public void keyReleased(KeyEvent e) {
                if (e.getKeyChar()=='\n'){
                    jlEtiqueta3.setText("Intro deixat");
                }
                else {
                    jlEtiqueta3.setText("Tecla deixada '"+e.getKeyChar()+"'");
                }
			}

			@Override
			public void keyTyped(KeyEvent e) {
                if (e.getKeyChar()=='\n'){
                    jlEtiqueta3.setText("Intro presionat");
                }
                else {
                    jlEtiqueta3.setText("Tecla escrita '"+e.getKeyChar()+"'");
                }
			}
            
        };



        jtfEntrada.addKeyListener(listener5);
        panell.addMouseWheelListener(listener4);
		panell.addMouseMotionListener(listener3);
		boto.addMouseListener(listener2);
		boto.addActionListener(listener1);
    }
}
