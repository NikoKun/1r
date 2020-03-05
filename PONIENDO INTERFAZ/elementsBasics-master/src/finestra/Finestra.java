package finestra;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.Period;

public class Finestra extends JFrame {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public JPanel panell;
    private JLabel jlDemanaDataNaixament, jlResultat;
    private JTextField jtfDataNaixament;
    private JButton jbBotoCalcula;
    private JTextArea jtArea;

    JTextField jtfEntrada;
    JButton jbMostra;
    JLabel jlEtiqueta;

    public Finestra() {
        setVisible(true);
        setSize(400, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Aquest és el títol de la finestra");
        //this.setLocation(175, 175);
        //this.setBounds(100, 100, 300, 300); // posicio x posicio y, amplada, alçada
        setLocationRelativeTo(null); //null -> centre
        //setResizable(false); //establim si es permet el canvi de mida o no.
        setMinimumSize(new Dimension(200,200));
        
        this.getContentPane().setBackground(Color.CYAN);
        //Els panells són com els fulls o divs.. Finestra --> Panell
        //Podirem crear el panell al constructor de finestra pero millor no
        iniciarComponents();



    
    }

    private void iniciarComponents(){
        posarPanells();
        //posarLabels();
        //posarBotons();
        //posarRadioButtons();
        //posarBotonsActivacio();
        //posaTextBox();
        //posarAreesDeText();
        //posarCheckBox();
        //posarLlistesDesplegables();
        //posarPassField();
        //posarTaula();
        //posarLlista();

        //muntarFinestra();
        //listeners();

        muntaEscenari();







    }























    public void posarPanells() {
        panell = new JPanel(); //creo el panell però encara no el tinc a la finestra
        this.getContentPane().add(panell);
        panell.setLayout(null);
        //panell.setBackground(Color.green);
        
    }


    private void posarLabels(){
        JLabel etiqueta = new JLabel("Institut Cirviànum",SwingConstants.CENTER);
        //etiqueta.setHorizontalAlignment(SwingConstants.RIGHT);
        //etiqueta.setText("Hello WOrld");
        //etiqueta.setBounds(20,20,50, 50);
        etiqueta.setBounds(0,0,380, 70);
        etiqueta.setForeground(Color.black);
        //etiqueta.setBackground(Color.yellow); //no xuta  Hay que desactivar el diseño por defecto de las etiquetas
        //etiqueta.setOpaque(true); //
        etiqueta.setFont(new Font("cooper black",Font.PLAIN,24));
        panell.add(etiqueta);

        //JLabel Imatge
        ImageIcon imatge = new ImageIcon("logoCirv.jpg");

        JLabel etiqueta2 = new JLabel();
        etiqueta2.setBounds(127,100,127,83);
        ImageIcon imgIconReduit = new ImageIcon(imatge.getImage().getScaledInstance(etiqueta2.getWidth(), etiqueta2.getHeight(), Image.SCALE_SMOOTH));
        etiqueta2.setIcon(imgIconReduit); //eSCALADO SUAVE
        panell.add(etiqueta2);

    }

    private void posarBotons() {
        JButton boto1 = new JButton("click!");
        
        boto1.setBounds(100,100,100,40);
        boto1.setMnemonic('a');
        panell.add(boto1);
        //boto amb imatge
        JButton boto2 = new JButton();
        boto2.setBounds(100,200,100,40);
        //boto2.setOpaque(true);
        boto2.setBackground(Color.blue);//es posible que no funcioni i que necessiti setOpaque
        ImageIcon click =new ImageIcon("click.jpg");
        boto2.setIcon(new ImageIcon(click.getImage().getScaledInstance(boto2.getWidth(), boto2.getHeight(),Image.SCALE_SMOOTH )));
        
        
        panell.add(boto2);
        //cantonades
        JButton boto3 = new JButton();
        boto3.setBounds(100,300,110,50);
        //boto3.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //boto3.setBorder(BorderFactory.createLineBorder(Color.red,3));
        boto3.setBorder(BorderFactory.createLineBorder(Color.green,4,true));
        panell.add(boto3);




    }

    private void posarRadioButtons() {
        JRadioButton radioButton1 = new JRadioButton("Opció 1",true);
        radioButton1.setBounds(50,100,100,50);

        panell.add(radioButton1);

        JRadioButton radioButton2 = new JRadioButton("Opció 2",false);
        radioButton2.setBounds(50,150,100,50);
        panell.add(radioButton2);

        JRadioButton radioButton3 = new JRadioButton("Opció 3",false);
        radioButton3.setBounds(50,200,100,50);
        radioButton3.setEnabled(false);
        panell.add(radioButton3);

        ButtonGroup grupRadioButtons = new ButtonGroup();
        grupRadioButtons.add(radioButton1);
        grupRadioButtons.add(radioButton2);
        grupRadioButtons.add(radioButton3);
    }

    private void posarBotonsActivacio() {
        JToggleButton botoToggle1 = new JToggleButton("Opció 1",true);
        botoToggle1.setBounds(50,100,100,40);
        panell.add(botoToggle1);
        JToggleButton botoToggle2 = new JToggleButton("Opció 2",false);
        botoToggle2.setBounds(50,150,100,40);
        panell.add(botoToggle2);
        JToggleButton botoToggle3 = new JToggleButton("Opció 3",false);
        botoToggle3.setBounds(50,200,100,40);
        panell.add(botoToggle3);
        ButtonGroup grupBotonsToggle = new ButtonGroup();
        grupBotonsToggle.add(botoToggle1);
        grupBotonsToggle.add(botoToggle2);
        grupBotonsToggle.add(botoToggle3);

    }

    private void posaTextBox() {
        JTextField textBox1 = new JTextField("Primer");
        textBox1.setBounds(50,50,100,30);
        panell.add(textBox1);
        JTextField textBox2 = new JTextField("Segon");
        textBox2.setBounds(50,100,100,30);
        panell.add(textBox2);
        System.out.println("Text: "+textBox1.getText());


        
    }

    private void posarAreesDeText(){
        JTextArea areaText = new JTextArea();
        areaText.setBounds(20,20,300,200);
        areaText.setText("Hello");
        areaText.append(" ");
        areaText.append("Laralarala ");
        areaText.setEditable(true);
        System.out.println("Text: "+areaText.getText());
        panell.add(areaText);

        //Barres de desplaçament
        JScrollPane scrolls = new JScrollPane(areaText);
        scrolls.setBounds(20,20,300,200);//les mateixes que areatext
        scrolls.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrolls.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panell.add(scrolls);
    
    }

    private void posarCheckBox() {
        JCheckBox cBox1 = new JCheckBox("Opcio 1");
        cBox1.setBounds(20,20,100,40);
        panell.add(cBox1);
        JCheckBox cBox2 = new JCheckBox("Opcio 2");
        cBox2.setBounds(20,60,100,40);
        panell.add(cBox2);
        JCheckBox cBox3 = new JCheckBox("Opcio 3");
        cBox3.setBounds(20,100,100,40);
        panell.add(cBox3);

        
    }

    private void posarLlistesDesplegables() {
        /*
        String [] pobles = {"Campdevànol","Vic","Ripoll","Torelló"};
        JComboBox<String> llista1 = new JComboBox<String>(pobles);
        llista1.setBounds(20,20,150,30);
        llista1.addItem("Manlleu");
        llista1.setSelectedItem("Vic");
        
        panell.add(llista1);
        */
        
        Usuari u1 = new Usuari("hortiz","1234");
        Usuari u2 = new Usuari("eperez","0000");
        DefaultComboBoxModel<Usuari> model = new DefaultComboBoxModel<Usuari>();
        JComboBox<Usuari> llista2 = new JComboBox<Usuari>(model);
        model.addElement(u1);
        model.addElement(u2);
        llista2.setBounds(20,20,200,30);
        panell.add(llista2);
        



    }

    private void posarPassField() {
        JPasswordField passField = new JPasswordField();
        passField.setBounds(20,20,150,30);
        passField.setText("hola");


        panell.add(passField);

        //System.out.println("Password: "+passField.getText());
        System.out.println("Password: "+Arrays.toString(passField.getPassword()));
        String pass="";
        for(int i=0; i<passField.getPassword().length;i++){
            pass+=passField.getPassword()[i];
        }
        System.out.println(pass);

    }

    private void posarTaula() {
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nom");
        model.addColumn("Edat");
        model.addColumn("Poblacio");
        String[] persona1 ={"Hector","39","Campdevànol"};
        String[] persona2 ={"Pep","23","Ripoll"};
        model.addRow(persona1);
        model.addRow(persona2);//pilla array
        JTable taula = new JTable(model);
        taula.setBounds(20,20,300,200);
        panell.add(taula);
        //Es necessari crear el scroll pq es vegin les columnes
        JScrollPane scroll = new JScrollPane(taula,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20,20,300,200);
        panell.add(scroll);


    }

    
    private void posarLlista() {
        
        DefaultListModel<Usuari> model = new DefaultListModel<Usuari>();
        model.addElement(new Usuari("hortiz","1234"));
        model.addElement(new Usuari("eperez","0000"));
        model.addElement(new Usuari("alopez","8998"));
        model.addElement(new Usuari("mmas","1234"));
        model.addElement(new Usuari("eboli","0000"));
        model.addElement(new Usuari("apopo","8998"));
        model.addElement(new Usuari("gpetre","1234"));
        model.addElement(new Usuari("sadassd","0000"));
        model.addElement(new Usuari("asdds","8998"));
        model.addElement(new Usuari("fdhgd","1234"));
        model.addElement(new Usuari("fdgsdg","0000"));
        model.addElement(new Usuari("fdgf","8998"));
        JList<Usuari> llista = new JList<Usuari>(model);
        llista.setBounds(20,20,200,150);
        panell.add(llista);
        JScrollPane scroll = new JScrollPane(llista,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(20,20,200,150);
        panell.add(scroll);

    }

    private void muntaEscenari() {
        jtfEntrada = new JTextField();
        jtfEntrada.setBounds(20,20,200,30);
        panell.add(jtfEntrada);
        
        jbMostra = new JButton("Click!");
        jbMostra.setBounds(20,60,100,30);
        panell.add(jbMostra);

        jlEtiqueta = new JLabel();
        jlEtiqueta.setBounds(20,100,200,30);
        panell.add(jlEtiqueta);

        listenerAccio();

    }

    private void listenerAccio() {
        ActionListener listener1 = new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				jlEtiqueta.setText(jtfEntrada.getText());
				
			}
            
        };
        jbMostra.addActionListener(listener1);
    }












}
