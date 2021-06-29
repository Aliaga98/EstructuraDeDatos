package PRESENTACION;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import NEGOCIO.MatrizDispersa;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TablaGrafica extends JPanel 
{
	private JTable tabla;
	private JScrollPane scrollPane;
	
	public int Filas= 1;
	public int Columnas= 1;
	public MatrizDispersa mtzDispersa;
	
	public TablaGrafica(MatrizDispersa mtzDispersa) 
	{
		this.mtzDispersa= mtzDispersa;
		
		setBackground(Color.CYAN);
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 32, 265, 146);
		add(scrollPane);
		
		tabla = new JTable(Filas, Columnas);
		scrollPane.setViewportView(tabla);
		construirTabla(Filas, Columnas);
		
		
		
		JButton btnMasColum = new JButton("MAS COLUM");
		btnMasColum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Columnas++;
				construirTabla(Filas, Columnas);
			}
		});
		btnMasColum.setBounds(318, 32, 91, 23);
		add(btnMasColum);
		
		JButton btnMasFilas = new JButton("MAS FILAS");
		btnMasFilas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Filas++;
				construirTabla(Filas, Columnas);
			}
		});
		btnMasFilas.setBounds(43, 189, 89, 23);
		add(btnMasFilas);
		
		JButton btnCargarAMtz = new JButton("CARGAR A MTZ");
		btnCargarAMtz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				mtzDispersa.asignarTam(Filas, Columnas);
				for (int f = 0; f < Filas; f++) {
					for (int c = 0; c < Columnas; c++) {
						int valor= Integer.parseInt(tabla.getValueAt(f, c).toString());
						if(valor!=0)
							mtzDispersa.agregarEle(valor, f, c);
					}
				}
			}
		});
		btnCargarAMtz.setBounds(302, 189, 107, 23);
		add(btnCargarAMtz);
		
		JButton btnMostrarMtz = new JButton("MOSTRAR MTZ");
		btnMostrarMtz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				for (int f = 0; f < mtzDispersa.Filas; f++) {
					for (int c = 0; c < mtzDispersa.Columnas; c++) {
						int valor= mtzDispersa.obtenerEle(f, c);
						tabla.setValueAt(valor, f, c);
					}
				}
			}
		});
		btnMostrarMtz.setBounds(302, 223, 107, 23);
		add(btnMostrarMtz);
	}
	
	public void construirTabla(int filas, int columnas)
	{
		tabla= new JTable(filas, columnas); // CONSTRUYE NUEVA TABLA
		tabla.setTableHeader(null); // NO MUESTRA ENCABEZADO DE COLUMNAS
		tabla.setRowHeight(30); // ALTO DE LAS FILAS
		tabla.setAutoResizeMode(0); // PERMITE MOSTRAR LA BARRA DESPLAZ HORIZONTAL
		for (int c = 0; c < columnas; c++) {
			tabla.getColumnModel().getColumn(c).setMaxWidth(30); // ANCHO DE LAS COLUMNAS
		}
		
		scrollPane.setViewportView(tabla); // ASIGNA LA TABLA AL SCROLLPANE
	}
}
