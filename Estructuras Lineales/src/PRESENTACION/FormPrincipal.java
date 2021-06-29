package PRESENTACION;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import NEGOCIO.ArbolBinario;
import NEGOCIO.Cola;
import NEGOCIO.Lista;
import NEGOCIO.MatrizDispersa;
import NEGOCIO.Nodo;
import NEGOCIO.NodoBin;
import NEGOCIO.NodoDoble;
import NEGOCIO.Pila;
import NEGOCIO.Ronda;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField tfElementoCola;
	
	public Cola cl= new Cola();
	public Pila pl= new Pila();
	public Lista lt= new Lista(); 
	public Ronda rond= new Ronda();
	public MatrizDispersa mtzDispersa= new MatrizDispersa(1, 1);
	public ArbolBinario arbBin= new ArbolBinario();
	
	private JTextField tfElementoPila;
	private JTextField tfElementoLista;
	private JComboBox cbMetodos;
	private JTextField tfPosicion;
	private JTextField tfElementoRonda;
	private JTextField tfElementoArbol;
	private JTextField tfSalidaArbol;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormPrincipal frame = new FormPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormPrincipal() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 735, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		GraficadorCola grafCola = new GraficadorCola(cl);
		grafCola.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "COLA", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		grafCola.setBackground(Color.CYAN);
		grafCola.setBounds(21, 43, 676, 94);
		contentPane.add(grafCola);
		
		JLabel lblElemento = new JLabel("ELEMENTO");
		lblElemento.setBounds(250, 18, 62, 14);
		contentPane.add(lblElemento);
		
		tfElementoCola = new JTextField();
		tfElementoCola.setBounds(310, 15, 86, 20);
		contentPane.add(tfElementoCola);
		tfElementoCola.setColumns(10);
		
		JButton btnEncolar = new JButton("ENCOLAR");
		btnEncolar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String ele= tfElementoCola.getText();
				Nodo nd= new Nodo(ele);
				cl.agregar(nd);
				
				grafCola.repaint();
			}
		});
		btnEncolar.setBounds(608, 14, 89, 23);
		contentPane.add(btnEncolar);
		
		JButton btnSacar = new JButton("SACAR");
		btnSacar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Nodo nd= cl.sacar();
				tfElementoCola.setText(nd.Ele.toString());
				
				grafCola.repaint();
			}
		});
		btnSacar.setBounds(21, 14, 89, 23);
		contentPane.add(btnSacar);
		
		GraficadorPila grafPila = new GraficadorPila(pl);
		grafPila.setBackground(Color.GREEN);
		grafPila.setBorder(new TitledBorder(null, "PILA", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		grafPila.setBounds(89, 173, 127, 273);
		contentPane.add(grafPila);
		
		tfElementoPila = new JTextField();
		tfElementoPila.setBounds(112, 142, 86, 20);
		contentPane.add(tfElementoPila);
		tfElementoPila.setColumns(10);
		
		JButton btnApilar = new JButton("APILAR");
		btnApilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String ele= tfElementoPila.getText();
				Nodo nd= new Nodo(ele);
				pl.apilar(nd);
				
				grafPila.repaint();
			}
		});
		btnApilar.setBounds(21, 141, 89, 23);
		contentPane.add(btnApilar);
		
		JButton btnRetirar = new JButton("RETIRAR");
		btnRetirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Nodo nd= pl.retirar();
				tfElementoPila.setText(nd.Ele.toString());
				
				grafPila.repaint();
			}
		});
		btnRetirar.setBounds(200, 141, 89, 23);
		contentPane.add(btnRetirar);
		
		GraficadorLista grafLista = new GraficadorLista(lt);
		grafLista.setBackground(SystemColor.activeCaption);
		grafLista.setBorder(new TitledBorder(null, "LISTA DOBLE ENLACE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		grafLista.setBounds(253, 331, 444, 115);
		contentPane.add(grafLista);
		
		JButton btnEjecutar = new JButton("EJECUTAR");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String item= cbMetodos.getSelectedItem().toString();
				switch (item) {
				case "AGREGAR PRIMERO":
					int ele= Integer.parseInt(tfElementoLista.getText());
					NodoDoble nd= new NodoDoble(ele);
					lt.agregarPrimero(nd);
					grafLista.repaint();
					break;
					
				case "REMOVER POSICION":
					int pos= Integer.parseInt(tfPosicion.getText());
					NodoDoble n2= lt.remover(pos);
					tfElementoLista.setText(n2.Ele.toString());
					grafLista.repaint();
					break;
				default:
					break;
				}
			}
		});
		btnEjecutar.setBounds(608, 299, 89, 23);
		contentPane.add(btnEjecutar);
		
		tfElementoLista = new JTextField();
		tfElementoLista.setBounds(310, 300, 86, 20);
		contentPane.add(tfElementoLista);
		tfElementoLista.setColumns(10);
		
		cbMetodos = new JComboBox();
		cbMetodos.setModel(new DefaultComboBoxModel(new String[] {"AGREGAR PRIMERO", "AGREGAR ULTIMO", "AGREGAR POSICION", "REMOVER PRIMERO", "REMOVER ULTIMO", "REMOVER POSICION", "OBTENER PRIMERO", "OBTENER ULTIMO", "OBTENER POSICION", "REEMPLAZAR"}));
		cbMetodos.setBounds(466, 300, 132, 20);
		contentPane.add(cbMetodos);
		
		JLabel lblElemento_1 = new JLabel("Elemento :");
		lblElemento_1.setBounds(253, 306, 62, 14);
		contentPane.add(lblElemento_1);
		
		JLabel lblPosicion = new JLabel("Posicion :");
		lblPosicion.setBounds(254, 269, 46, 14);
		contentPane.add(lblPosicion);
		
		tfPosicion = new JTextField();
		tfPosicion.setBounds(310, 266, 46, 20);
		contentPane.add(tfPosicion);
		tfPosicion.setColumns(10);
		
		GraficadorRonda grafRonda = new GraficadorRonda(rond);
		grafRonda.setBounds(707, 15, 536, 385);
		contentPane.add(grafRonda);
		
		tfElementoRonda = new JTextField();
		tfElementoRonda.setBounds(1253, 170, 86, 20);
		contentPane.add(tfElementoRonda);
		tfElementoRonda.setColumns(10);
		
		JButton btnInsertarRonda = new JButton("INSERTAR");
		btnInsertarRonda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int ele= Integer.parseInt(tfElementoRonda.getText());
				NodoDoble nd= new NodoDoble(ele);
				rond.insertar(nd);
				grafRonda.repaint();
			}
		});
		btnInsertarRonda.setBounds(1253, 201, 89, 23);
		contentPane.add(btnInsertarRonda);
		
		JButton btnRemoverRonda = new JButton("REMOVER");
		btnRemoverRonda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				NodoDoble nd= rond.remover();
				if(nd!=null)
				{
					tfElementoRonda.setText("");
					tfElementoRonda.setText(nd.Ele.toString());
					grafRonda.repaint();
				}
				else
					JOptionPane.showMessageDialog(new JLabel(), "LA RONDA ESTA VACIA");
			}
		});
		btnRemoverRonda.setBounds(1253, 235, 89, 23);
		contentPane.add(btnRemoverRonda);
		
		JButton btnRotar = new JButton("ROTAR");
		btnRotar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int cantPosiciones= Integer.parseInt(tfElementoRonda.getText());
				rond.rotar(cantPosiciones);
				
				grafRonda.repaint();
			}
		});
		btnRotar.setBounds(1253, 265, 89, 23);
		contentPane.add(btnRotar);
		
		//int datos[][]=new int [4][3];
		/*int datos[][]= { {1,2,3}, 
				         {5,5,5}, 
				         {9,9,9}, 
				         {8,8,8} };*/
		TablaGrafica tablaGraf = new TablaGrafica(mtzDispersa);
		tablaGraf.setBounds(938, 411, 414, 284);
		contentPane.add(tablaGraf);
		
		GraficadorArbol grafArbolBin = new GraficadorArbol(arbBin);
		grafArbolBin.setBounds(184, 457, 744, 238);
		contentPane.add(grafArbolBin);
		
		tfElementoArbol = new JTextField();
		tfElementoArbol.setBounds(97, 534, 86, 20);
		contentPane.add(tfElementoArbol);
		tfElementoArbol.setColumns(10);
		
		JButton btnIngresarArbol = new JButton("INGRESAR");
		btnIngresarArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				int ele= Integer.parseInt(tfElementoArbol.getText());
				NodoBin nd= new NodoBin(ele);
				arbBin.insertar(nd);
				grafArbolBin.repaint();
			}
		});
		btnIngresarArbol.setHorizontalAlignment(SwingConstants.RIGHT);
		btnIngresarArbol.setBounds(97, 565, 86, 23);
		contentPane.add(btnIngresarArbol);
		
		JLabel lblElemento_2 = new JLabel("ELEMENTO:");
		lblElemento_2.setBounds(32, 537, 67, 14);
		contentPane.add(lblElemento_2);
		
		JComboBox comboBoxArbol = new JComboBox();
		comboBoxArbol.setModel(new DefaultComboBoxModel(new String[] {"CANT ELEMENTOS", "SUMA ELEMENTOS", "CANT HOJAS", "CANT PADRES", "ES COMPLETO", "MAYOR ELEMENTO", "MENOR ELEMENTO", "REMOVER ELEMENTO", "CANT NIVEL"}));
		comboBoxArbol.setBounds(57, 618, 126, 20);
		contentPane.add(comboBoxArbol);
		
		JLabel lblMetodos = new JLabel("METODOS:");
		lblMetodos.setBounds(0, 621, 53, 14);
		contentPane.add(lblMetodos);
		
		JButton btnEjecutarArbol = new JButton("EJECUTAR");
		btnEjecutarArbol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String item= comboBoxArbol.getSelectedItem().toString();
				switch (item) {
				case "CANT ELEMENTOS":
					tfSalidaArbol.setText(""+arbBin.cantElementos());
					break;
				case "SUMA ELEMENTOS":
					tfSalidaArbol.setText(""+arbBin.sumaElementos());
					break;
				case "CANT HOJAS":
					tfSalidaArbol.setText(""+arbBin.cantHojas());
					break;
				case "CANT PADRES":
					tfSalidaArbol.setText(""+arbBin.cantPadres());
					break;
				case "ES COMPLETO":
					if(arbBin.completo())
						tfSalidaArbol.setText("COMPLETO");
					else
						tfSalidaArbol.setText("incompleto");
					break;
				case "MAYOR ELEMENTO":
					tfSalidaArbol.setText(""+arbBin.mayorElemento());
					break;
				case "REMOVER ELEMENTO":
					int ele= Integer.parseInt(tfElementoArbol.getText());
					arbBin.eliminar(ele);
					grafArbolBin.repaint();
					break;
				default:
					break;
				case "CANT NIVEL":
					tfSalidaArbol.setText(""+arbBin.cantNivel());
					break;
				}
			}
		});
		btnEjecutarArbol.setBounds(94, 644, 89, 20);
		contentPane.add(btnEjecutarArbol);
		
		tfSalidaArbol = new JTextField();
		tfSalidaArbol.setBounds(97, 675, 86, 20);
		contentPane.add(tfSalidaArbol);
		tfSalidaArbol.setColumns(10);
		
		JLabel lblSalida = new JLabel("SALIDA:");
		lblSalida.setBounds(53, 678, 46, 14);
		contentPane.add(lblSalida);
		
		this.setExtendedState(MAXIMIZED_BOTH);
		
	}
}
