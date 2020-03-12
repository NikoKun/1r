package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import java.awt.event.*;



public class Events extends JFrame{

    private static final long serialVersionUID = 1L;

    
    JPanel panellGestio, panellClient, panellBack;
    JLabel titleGestio, titleClient, titleBack;

    
    JLabel dniL, nomL, cogL, numPersonesL, numNitsL, calendariL, nomHotelL, registreNovaHabL, numRegistreL, persRegistreL, consultaReserva, nomClientReservaL, reservaPendentL, reservaConfL;
    //   Imatges
    JLabel nomIMG, cogIMG;
    
    
    JTextField dni, nom, cog, numPersones, numNits, nomHotel, numRegistre, persRegistre, nomClientReserva;

    JList llistaNomClients, llistaReserves;
    
    JTable reservaPendent, reservaConf, taulaReservaPendent, taulaReservaConfirmada;
    
    JCalendar calendari;
    JDateChooser dataAEscollir;
    
    JButton reserva, botoGuarda1, botoGuarda2, botoElimina;
    
    JPasswordField jtfEntrada1;
    JPasswordField jtfEntrada2;
    JTextField jtfEntrada;
    JCheckBox mostra;

    public Events() {
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);                      
//        this.setResizable(false);
        this.setMinimumSize(new Dimension(1200, 700));
        this.getContentPane().setBackground(Color.black);
        this.setTitle("Título del programucho...");

        
        posarPanells();
        posarTitle();
        
        // PanellClients
        posarInfoClient();
        posarCalendari();
        posarBotoReserva();

        
        // PanellBack
        posarNomHotel();
        posarBotoGuarda1();
        posarRegistreNovaHabitacio();
        posarBotoGuarda2();
        posarConsultaReserva();
        posarBotoElimina();
        
        
        // PanellGestió
        posarReservaPendent();

    }

    public void posarPanells(){
        panellGestio = new JPanel();
        panellGestio.setLayout(null);
        panellGestio.setBackground(Color.white);
        panellGestio.setBounds(0, 0, 400, 700);
        this.getContentPane().add(panellGestio);

        
        panellClient = new JPanel();
        panellClient.setLayout(null);
        panellClient.setBackground(Color.white);
        panellClient.setBounds(402, 0, 400, 700);
        this.getContentPane().add(panellClient);

        
        panellBack = new JPanel();
        panellBack.setLayout(null);
        panellBack.setBackground(Color.white);
        panellBack.setBounds(804, 0, 400, 700);
        this.getContentPane().add(panellBack);
    }

    public void posarTitle(){
    	titleGestio = new JLabel();
    	titleGestio.setBounds(0,20, panellGestio.getWidth(),40);
    	titleGestio.setHorizontalAlignment(SwingConstants.CENTER);  // CENTRARRRRR
    	titleGestio.setFont(new Font("Liberation Serif", Font.BOLD, 30));
    	titleGestio.setText("Gestió");
        panellGestio.add(titleGestio);
        
        
        titleClient = new JLabel();
        titleClient.setBounds(0,20, panellClient.getWidth(),40);
        titleClient.setHorizontalAlignment(SwingConstants.CENTER);  // CENTRARRRRR
        titleClient.setFont(new Font("Liberation Serif", Font.BOLD, 30));
        titleClient.setText("Clients");
        panellClient.add(titleClient);
        
        
        titleBack = new JLabel();
        titleBack.setBounds(0,20, panellBack.getWidth(),40);
        titleBack.setHorizontalAlignment(SwingConstants.CENTER);  // CENTRARRRRR
        titleBack.setFont(new Font("Liberation Serif", Font.BOLD, 30));
        titleBack.setText("Back");
        panellBack.add(titleBack);
    }
    
    
    
    public void posarInfoClient(){
    	dniL = new JLabel();
    	dniL.setBounds(20,80,200,50);
    	dniL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	dniL.setText("DNI:");
    	panellClient.add(dniL);
    	
        dni = new JTextField("");
        dni.setBounds(170,95,175,20);
        panellClient.add(dni);
        
        
    	
        
    	nomL = new JLabel();
    	nomL.setBounds(20,110,200,50);
    	nomL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	nomL.setText("Nom:");
    	panellClient.add(nomL);
    	
        nom = new JTextField("");
        nom.setBounds(170,125,175,20);
        panellClient.add(nom);
        
        nomIMG = new JLabel();
        nomIMG.setBounds(360,110,200,50);
        nomIMG.setText("AAA");
    	panellClient.add(nomIMG);
        
        
        
        
    	
    	cogL = new JLabel();
    	cogL.setBounds(20,140,200,50);
    	cogL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	cogL.setText("Cognoms:");
    	panellClient.add(cogL);
    	
        cog = new JTextField("");
        cog.setBounds(170,155,175,20);
        panellClient.add(cog);
        
        cogIMG = new JLabel();
        cogIMG.setBounds(360,140,200,50);
        cogIMG.setText("AAA");
    	panellClient.add(cogIMG);
        
        
        
        
        
    	numPersonesL = new JLabel();
    	numPersonesL.setBounds(20,170,200,50);
    	numPersonesL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	numPersonesL.setText("Num. Persones:");
        panellClient.add(numPersonesL);
        
        numPersones = new JTextField("");
        numPersones.setBounds(170,185,50,20);
        panellClient.add(numPersones);
        
        
    	numNitsL = new JLabel();
    	numNitsL.setBounds(20,200,200,50);
    	numNitsL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	numNitsL.setText("Num. Nits:");
    	panellClient.add(numNitsL);
    	
    	numNits = new JTextField("");
    	numNits.setBounds(170,215,50,20);
        panellClient.add(numNits);
    }
    
    
    
    public void posarCalendari() {
    	calendariL = new JLabel();
    	calendariL.setBounds(20,260,250,50);
    	calendariL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	calendariL.setText("Data d'entrada:");
    	panellClient.add(calendariL);
    	
    	calendari = new JCalendar();
    	calendari.setBounds(50,325,300,250);
        panellClient.add(calendari);
    }
    
    
    
    public void posarBotoReserva() {
    	reserva = new JButton("Reserva");
    	reserva.setBounds(150,610, panellClient.getWidth() -300,30);
    	reserva.setHorizontalAlignment(SwingConstants.CENTER);  // CENTRARRRRR
        panellClient.add(reserva);
    }
    
    
    
    public void posarNomHotel() {
    	nomHotelL = new JLabel();
    	nomHotelL.setBounds(20,80,200,50);
    	nomHotelL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	nomHotelL.setText("Nom Hotel: ");
    	panellBack.add(nomHotelL);
    	
    	nomHotel = new JTextField("");
    	nomHotel.setBounds(170,95,200,20);
    	panellBack.add(nomHotel);
    }
    
    
    
    public void posarBotoGuarda1() {
    	botoGuarda1 = new JButton("Guarda");
    	botoGuarda1.setBounds(150,130, panellBack.getWidth() -300,30);
    	botoGuarda1.setHorizontalAlignment(SwingConstants.CENTER);  // CENTRARRRRR
    	panellBack.add(botoGuarda1);
    }
    
    
    
    public void posarRegistreNovaHabitacio() {	
    	registreNovaHabL = new JLabel();
    	registreNovaHabL.setBounds(20,175,250,50);
    	registreNovaHabL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	registreNovaHabL.setText("Registre nova habitació");
    	panellBack.add(registreNovaHabL);
    	
    	
    	
    	numRegistreL = new JLabel();
    	numRegistreL.setBounds(20,210,250,50);
    	numRegistreL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	numRegistreL.setText("Num.");
    	panellBack.add(numRegistreL);
    	
    	numRegistre = new JTextField("");
    	numRegistre.setBounds(70,225,80,20);
    	panellBack.add(numRegistre);
    	
    	
    	
    	persRegistreL = new JLabel();
    	persRegistreL.setBounds(200,210,250,50);
    	persRegistreL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	persRegistreL.setText("Pers.");
    	panellBack.add(persRegistreL);
    	
    	persRegistre = new JTextField("");
    	persRegistre.setBounds(250,225,80,20);
    	panellBack.add(persRegistre);
    }
    
    
    
    public void posarBotoGuarda2() {
    	botoGuarda2 = new JButton("Guarda");
    	botoGuarda2.setBounds(150,260, panellBack.getWidth() -300,30);
    	botoGuarda2.setHorizontalAlignment(SwingConstants.CENTER);  // CENTRARRRRR
    	panellBack.add(botoGuarda2);
    }
    
    
    
    public void posarConsultaReserva() {
    	consultaReserva = new JLabel();
    	consultaReserva.setBounds(20,310,250,50);
    	consultaReserva.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	consultaReserva.setText("Consulta Reserva");
    	panellBack.add(consultaReserva);
    	
    	
    	
    	nomClientReservaL = new JLabel();
    	nomClientReservaL.setBounds(50,350,250,50);
    	nomClientReservaL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	nomClientReservaL.setText("Nom Client:");
    	panellBack.add(nomClientReservaL);
    	
    	nomClientReserva = new JTextField("");
    	nomClientReserva.setBounds(155,365,150,20);
    	panellBack.add(nomClientReserva);
    	
    	

    	DefaultListModel<String> model = new DefaultListModel<String>();
    	model.addElement("Wala"); // AÑADIR INFOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
    	llistaNomClients = new JList<String>(model);
    	llistaNomClients.setBounds(30,420,150,150);
       	panellBack.add(llistaNomClients);
    	JScrollPane scroll = new JScrollPane(llistaNomClients, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll.setBounds(30,420,150,150);
       	panellBack.add(scroll);
       	
       	
       	
    	DefaultListModel<String> modelR = new DefaultListModel<String>();
    	modelR.addElement("n1"); // AÑADIR INFOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
    	llistaReserves = new JList<String>(modelR);
    	llistaReserves.setBounds(220,420,150,150);
       	panellBack.add(llistaReserves);
    	JScrollPane scrollR = new JScrollPane(llistaReserves, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scrollR.setBounds(220,420,150,150);
       	panellBack.add(scrollR);
    }
    
    
    
    public void posarBotoElimina() {
    	botoElimina = new JButton("Elimina");
    	botoElimina.setBounds(150,610, panellBack.getWidth() -300,30);
    	botoElimina.setHorizontalAlignment(SwingConstants.CENTER);  // CENTRARRRRR
    	panellBack.add(botoElimina);
    }
    
    
    
    public void posarReservaPendent() {
    	reservaPendentL = new JLabel();
    	reservaPendentL.setBounds(30,80,200,50);
    	reservaPendentL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	reservaPendentL.setText("Reserves pendents");
    	panellGestio.add(reservaPendentL);
    	
    	
    	DefaultTableModel model1 = new DefaultTableModel();
    	model1.addColumn("Reserva");
    	model1.addColumn("Dia");
    	model1.addColumn("Persones");
    	model1.addColumn("Habitació");
    	reservaPendent = new JTable(model1);
    	reservaPendent.setBounds(30,125,340,225);
    	reservaPendent.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	panellGestio.add(reservaPendent);
    	JScrollPane scroll1 = new JScrollPane(reservaPendent, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll1.setBounds(30,125,340,215);
    	panellGestio.add(scroll1);
    	

    	
    	reservaConfL = new JLabel();
    	reservaConfL.setBounds(30,350,200,50);
    	reservaConfL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	reservaConfL.setText("Reserves pendents");
    	panellGestio.add(reservaConfL);
    	
    	
    	dataAEscollir = new JDateChooser();
    	dataAEscollir.setBounds(200,365,170,25);
    	dataAEscollir.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	panellGestio.add(dataAEscollir);
    	
    	
    	DefaultTableModel model2 = new DefaultTableModel();
    	model2.addColumn("Nom");
    	model2.addColumn("Date In");
    	model2.addColumn("Date Out");
    	model2.addColumn("Habitació");
    	reservaConf = new JTable(model2);
    	reservaConf.setBounds(30,400,340,225);
    	reservaConf.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	panellGestio.add(reservaConf);
    	JScrollPane scroll2 = new JScrollPane(reservaConf, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll2.setBounds(30,400,340,215);
    	panellGestio.add(scroll2);
    }
    
    
    
    // listeneeeeeeeeeeeeerrrrrrrrrrrrrrrsssssssssss


    private void listenerTexts() {
        ImageIcon iconCorrecte = new ImageIcon("BienIcons.png");

        
        
        KeyListener listener = new KeyListener(){
//            JTextField  numNits, numRegistre;

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.toString().matches("*")) {         // Añadir Matches    Solo caracteres, sin simbolos ni numeros
					if (e.getClass().toString().equals("nom")) {
						nomIMG.setText("");
						nomIMG.setIcon(iconCorrecte);
						panellClient.add(nomIMG);
					}
					
					else if (e.getClass().toString().equals("cog")) {
						
					}
					
					else if (e.getClass().toString().equals("nomClientReserva")) {
							
					}
				}
				else if (e.toString().matches("*")) {         // Añadir Matches
					if (e.getClass().equals(nomHotel)) {
						
					}
				}
				else if (e.toString().matches("*")) {         // Añadir Matches	  8 numeros y una letra

					if (e.getClass().equals(dni)) {
						
					}
				}
				else if (e.toString().matches("*")) {         // Añadir Matches   solo numeros
					if (e.getClass().equals(numNits)) {
						
					}
					else if (e.getClass().equals(numRegistre)) {
						
					}
					else if (e.getClass().equals(numPersones)) {
						
					}
					else if (e.getClass().equals(persRegistre)) {
						
					}
				}

				else {
					
				}
				
				
			}

            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
        };



        jtfEntrada1.addKeyListener(listener);
        jtfEntrada2.addKeyListener(listener);
    }
}
