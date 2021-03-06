package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

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

import objects.Client;
import objects.Habitacio;
import objects.Hotel;
import objects.Reserva;

import java.awt.event.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;



public class Events extends JFrame{

    private static final long serialVersionUID = 1L;

    
    JPanel panellGestio, panellClient, panellBack;
    JLabel titleGestio, titleClient, titleBack;

    
    JLabel dniL, nomL, cogL, numPersonesL, numNitsL, calendariL, nomHotelL, registreNovaHabL, numRegistreL, persRegistreL, consultaReserva, nomClientReservaL, reservaPendentL, reservaConfL;
    //   Imatges
    JLabel nomIMG, cogIMG, dniIMG, numNitsIMG, numPersonesIMG, nomClientReservaIMG;
    
    
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

    DefaultTableModel model1, model2;
    JScrollPane scroll1, scroll2;
    
	boolean nomB = false, cogB = false, dniB = false, numNitsB = false, numPersB = false;

	
    public Events() {
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200, 700);
        this.setLocationRelativeTo(null);                      
//        this.setResizable(false);
        this.setMinimumSize(new Dimension(1200, 700));
        this.getContentPane().setBackground(Color.black);
        this.setTitle("T�tulo del programucho...");

        
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
        
        
        listenerTexts();

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
    	titleGestio.setText("Gesti�");
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
        dni.setName("dni");
        panellClient.add(dni);
        
        dniIMG = new JLabel();
        dniIMG.setBounds(360,79,200,50);
    	panellClient.add(dniIMG);
    	
        
    	nomL = new JLabel();
    	nomL.setBounds(20,110,200,50);
    	nomL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	nomL.setText("Nom:");
    	panellClient.add(nomL);
    	
        nom = new JTextField("");
        nom.setBounds(170,125,175,20);
        nom.setName("nom");
        panellClient.add(nom);
        
        nomIMG = new JLabel();
        nomIMG.setBounds(360,110,200,50);
    	panellClient.add(nomIMG);
        
        
        
        
    	
    	cogL = new JLabel();
    	cogL.setBounds(20,140,200,50);
    	cogL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	cogL.setText("Cognoms:");
    	panellClient.add(cogL);
    	
        cog = new JTextField("");
        cog.setBounds(170,155,175,20);
        cog.setName("cog");
        panellClient.add(cog);
        
        cogIMG = new JLabel();
        cogIMG.setBounds(360,140,200,50);
    	panellClient.add(cogIMG);
        
     

        
    	numPersonesL = new JLabel();
    	numPersonesL.setBounds(20,170,200,50);
    	numPersonesL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	numPersonesL.setText("Num.Persones:");
        panellClient.add(numPersonesL);
        
        numPersones = new JTextField("");
        numPersones.setBounds(170,185,50,20);
        numPersones.setName("numPersones");
        panellClient.add(numPersones);
        
        numPersonesIMG = new JLabel();
        numPersonesIMG.setBounds(250,170,200,50);
    	panellClient.add(numPersonesIMG);
        
        
    	
    	
    	numNitsL = new JLabel();
    	numNitsL.setBounds(20,200,200,50);
    	numNitsL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	numNitsL.setText("Num. Nits:");
    	panellClient.add(numNitsL);
    	
    	numNits = new JTextField("");
    	numNits.setBounds(170,215,50,20);
    	numNits.setName("numNits");
        panellClient.add(numNits);
        
        numNitsIMG = new JLabel();
        numNitsIMG.setBounds(250,200,200,50);
    	panellClient.add(numNitsIMG);
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
    	reserva.setEnabled(false);
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
    	botoGuarda1.setName("botoGuarda1");
    	panellBack.add(botoGuarda1);
    }
    
    
    
    public void posarRegistreNovaHabitacio() {	
    	registreNovaHabL = new JLabel();
    	registreNovaHabL.setBounds(20,175,250,50);
    	registreNovaHabL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	registreNovaHabL.setText("Registre nova habitaci�");
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
    	
    	nomClientReservaIMG = new JLabel();
    	nomClientReservaIMG.setBounds(360,140,200,50);
    	panellClient.add(nomClientReservaIMG);
    	

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
    	
    	
    	model1 = new DefaultTableModel();
    	model1.addColumn("Dia");
    	model1.addColumn("Dni");
    	model1.addColumn("Persones");
    	model1.addColumn("Habitaci�");
    	reservaPendent = new JTable(model1);
    	reservaPendent.setBounds(30,125,340,225);
    	reservaPendent.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	panellGestio.add(reservaPendent);
    	scroll1 = new JScrollPane(reservaPendent, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll1.setBounds(30,125,340,215);
    	panellGestio.add(scroll1);
    	
    	

    	reservaConfL = new JLabel();
    	reservaConfL.setBounds(30,350,200,50);
    	reservaConfL.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	reservaConfL.setText("Reserves confirmades");
    	panellGestio.add(reservaConfL);
    	
    	
    	dataAEscollir = new JDateChooser();
    	dataAEscollir.setBounds(200,365,170,25);
    	dataAEscollir.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	panellGestio.add(dataAEscollir);
    	
    	
    	model2 = new DefaultTableModel();
    	model2.addColumn("Nom");
    	model2.addColumn("Date In");
    	model2.addColumn("Date Out");
    	model2.addColumn("Habitaci�");
    	reservaConf = new JTable(model2);
    	reservaConf.setBounds(30,400,340,225);
    	reservaConf.setFont(new Font("Liberation Serif", Font.BOLD, 17));
    	panellGestio.add(reservaConf);
    	scroll2 = new JScrollPane(reservaConf, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	scroll2.setBounds(30,400,340,215);
    	panellGestio.add(scroll2);
    }
    
    
    

    
    
    
    
    
    
    
    
    
    
    
    
    
    

    private void listenerTexts() {
        ImageIcon iconCorrecte = new ImageIcon("BienIcons.png");
        ImageIcon iconCorrecteReduit = new ImageIcon(iconCorrecte.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
        ImageIcon iconIncorrecte = new ImageIcon("MalIcons.png");
        ImageIcon iconIncorrecteReduit = new ImageIcon(iconIncorrecte.getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));

        
    	ArrayList<Hotel> hotels = new ArrayList<Hotel>();                      // NO SE NO SE EHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH
    	ArrayList<Client> clients = new ArrayList<Client>();
    	ArrayList<Habitacio> rooms = new ArrayList<Habitacio>();
    	ArrayList<Reserva> pendingReservation = new ArrayList<Reserva>();
    	ArrayList<Reserva> confirmedReservation = new ArrayList<Reserva>();
    	
        
        KeyListener listener = new KeyListener(){
//            JTextField  numNits, numRegistre;

			@Override
			public void keyReleased(KeyEvent e) {
				
				if (e.getComponent().getName().equalsIgnoreCase("nom")) {
					if (Functions.matchesOnlyChar(nom.getText())) {
						nomIMG.setIcon(iconCorrecteReduit);
						panellClient.add(nomIMG);
						nomB = true;
					}
					else {
						nomIMG.setIcon(iconIncorrecteReduit);
						panellClient.add(nomIMG);
						nomB = false;
					}
					
					if (Functions.comprovaClientValid(nomB, cogB, dniB, numNitsB, numPersB)) {
						reserva.setEnabled(true);
				        panellClient.add(reserva);
					}
					else {
						reserva.setEnabled(false);
				        panellClient.add(reserva);
					}
				}
				else if (e.getComponent().getName().equalsIgnoreCase("cog")) {
					if (Functions.matchesOnlyChar(cog.getText())) {
						cogIMG.setIcon(iconCorrecteReduit);
						panellClient.add(cogIMG);
						cogB = true;
					}
					else {
						cogIMG.setIcon(iconIncorrecteReduit);
						panellClient.add(cogIMG);
						cogB = false;
					}
					
					if (Functions.comprovaClientValid(nomB, cogB, dniB, numNitsB, numPersB)) {
						reserva.setEnabled(true);
				        panellClient.add(reserva);
					}
					else {
						reserva.setEnabled(false);
				        panellClient.add(reserva);
					}
				}
				else if (e.getComponent().getName().equalsIgnoreCase("dni")) {
					if (Functions.validar(dni.getText())) {
						dniIMG.setIcon(iconCorrecteReduit);
						panellClient.add(dniIMG);
						dniB = true;
					}
					else {
						dniIMG.setIcon(iconIncorrecteReduit);
						panellClient.add(dniIMG);
						dniB = false;
					}
					
					if (Functions.comprovaClientValid(nomB, cogB, dniB, numNitsB, numPersB)) {
						reserva.setEnabled(true);
				        panellClient.add(reserva);
					}
					else {
						reserva.setEnabled(false);
				        panellClient.add(reserva);
					}
				}
				else if (e.getComponent().getName().equalsIgnoreCase("numNits")) {
					if (Functions.matchesOnlyNumbers40(numNits.getText())) {
						numNitsIMG.setIcon(iconCorrecteReduit);
						panellClient.add(numNitsIMG);
						numNitsB = true;
					}
					else {
						numNitsIMG.setIcon(iconIncorrecteReduit);
						panellClient.add(numNitsIMG);
						numNitsB = false;
					}
					
					if (Functions.comprovaClientValid(nomB, cogB, dniB, numNitsB, numPersB)) {
						reserva.setEnabled(true);
				        panellClient.add(reserva);
					}
					else {
						reserva.setEnabled(false);
				        panellClient.add(reserva);
					}
				}
				else if (e.getComponent().getName().equalsIgnoreCase("numPersones")) {
					if (Functions.matchesOnlyNumbers6(numPersones.getText())) {
						numPersonesIMG.setIcon(iconCorrecteReduit);
						panellClient.add(numPersonesIMG);
						numPersB = true;
					}
					else {
						numPersonesIMG.setIcon(iconIncorrecteReduit);
						panellClient.add(numPersonesIMG);
						numPersB = false;
					}
					
					if (Functions.comprovaClientValid(nomB, cogB, dniB, numNitsB, numPersB)) {
						reserva.setEnabled(true);
				        panellClient.add(reserva);
					}
					else {
						reserva.setEnabled(false);
				        panellClient.add(reserva);
					}
				}
				
				
				
				
				else if (e.getComponent().getName().equalsIgnoreCase("numRegistre")) {
						
				}
				else if (e.getComponent().getName().equalsIgnoreCase("persRegistre")) {
						
				}	
				else if (e.getComponent().getName().equalsIgnoreCase("nomClientReserva")) {   // POR HACER -----------------------------------
					if (Functions.matchesOnlyChar(nomClientReserva.getText())) {
						nomClientReservaIMG.setIcon(iconCorrecteReduit);
						panellClient.add(nomClientReservaIMG);
					}
					else {
						nomClientReservaIMG.setIcon(iconIncorrecteReduit);
						panellClient.add(nomClientReservaIMG);
					}
					

				}
				
			}

            @Override
            public void keyPressed(KeyEvent e) {
            }
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
        };

        dni.addKeyListener(listener);
        nom.addKeyListener(listener);
        cog.addKeyListener(listener);
        numNits.addKeyListener(listener);
        numPersones.addKeyListener(listener);

        
        ActionListener actionSetTitle = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				setTitle(nomHotel.getText());									// REVISAR
				Hotel newHotel = new Hotel(nomHotel.getText());
				hotels.add(newHotel);
			}
        };
        botoGuarda1.addActionListener(actionSetTitle);

        
        
        ActionListener actrionSetReservaPendent = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				String data = Functions.dataString(calendari);
		    	
		    	// A�ADIR LOS DATOS A LOS OBJETOS --------------------------------------------------------------------------
		    	Client newClient = new Client(dni.getText(), nom.getText(), cog.getText());
		    	if (Functions.comprovaClient(dni.getText(), clients)) {
		    		Reserva newReserva = new Reserva(newClient, Integer.parseInt(numPersones.getText()), Integer.parseInt(numNits.getText()), Functions.dataString(calendari));
		    		pendingReservation.add(newReserva);
		    		
			    	String[] infoReservaPendent = {newReserva.getDate(), newReserva.getReservationGuy().getDni(), String.valueOf((newReserva.getNumPeople())), "2"};  // FALTA PONER LA HABITACI�N ----------------------------
			    	model1.addRow(infoReservaPendent);
			    	panellGestio.add(scroll1);
		    	}
		    	else {
		    		clients.add(newClient);
		    		Reserva newReserva = new Reserva(newClient, Integer.parseInt(numPersones.getText()), Integer.parseInt(numNits.getText()), Functions.dataString(calendari));
		    		pendingReservation.add(newReserva);
		    		
			    	String[] infoReservaPendent = {newReserva.getDate(), newReserva.getReservationGuy().getDni(), String.valueOf((newReserva.getNumPeople())), "2"};  // FALTA PONER LA HABITACI�N ----------------------------
			    	model1.addRow(infoReservaPendent);
			    	panellGestio.add(scroll1);
		    	}
		    	

		    	
		    	dni.setText("");
		    	dniIMG.setIcon(null);
		    	nom.setText("");
		    	nomIMG.setIcon(null);
		    	cog.setText("");
		    	cogIMG.setIcon(null);
		    	numPersones.setText("");
		    	numPersonesIMG.setIcon(null);
		    	numNits.setText("");
		    	numNitsIMG.setIcon(null);
		    	
//		    	calendari = new JCalendar();
//		    	calendari.setBounds(50,325,300,250);
//		        panellClient.add(calendari);
		        
		    	calendari = new JCalendar();
		    	calendari.setBounds(50,325,300,250);
		    	panellClient.add(calendari);
		    	
		    	nomB = false;
		    	cogB = false;
		    	dniB = false;
		    	numNitsB = false;
		    	numPersB = false;
		    	
				if (Functions.comprovaClientValid(nomB, cogB, dniB, numNitsB, numPersB)) {
					reserva.setEnabled(true);
			        panellClient.add(reserva);
				}
				else {
					reserva.setEnabled(false);
			        panellClient.add(reserva);
				}
			}
        };
        reserva.addActionListener(actrionSetReservaPendent);

        
        
        
        
        
        
        
        
        
        
        

    
        
        
        
        
        
        
        
        
        
        
        

    }
    
}
