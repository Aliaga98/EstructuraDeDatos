package PRESENTACION;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import NEGOCIO.ListaDoble;
import NEGOCIO.NodoDoble;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormListaDoble extends JInternalFrame {
	
	private JTextField tfElemento;

	ListaDoble lis= new ListaDoble();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormListaDoble frame = new FormListaDoble();
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
	public FormListaDoble() {
		setClosable(true);
		getContentPane().setBackground(new Color(0, 0, 128));
		getContentPane().setLayout(null);
		
		GrafListaDoble grafListaDoble = new GrafListaDoble(lis);
		
		grafListaDoble.setBounds(24, 50, 588, 133);
		getContentPane().add(grafListaDoble);
		
		JLabel lblElemento = new JLabel("ELEMENTO");
		lblElemento.setBounds(24, 25, 69, 14);
		lblElemento.setForeground(new Color(255, 255, 0));
		getContentPane().add(lblElemento);
		
		tfElemento = new JTextField();
		tfElemento.setBounds(93, 22, 45, 20);
		getContentPane().add(tfElemento);
		tfElemento.setColumns(10);
		
		JButton btnAgregarUltimo = new JButton("AGREGAR ULTIMO");
		btnAgregarUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String ele= tfElemento.getText();
				NodoDoble nd= new NodoDoble(ele);
				lis.agregarUltimo(nd);
				
				grafListaDoble.repaint();
			}
		});
		btnAgregarUltimo.setBounds(491, 21, 121, 23);
		getContentPane().add(btnAgregarUltimo);
		setTitle("LISTA DOBLE");
		setBounds(100, 100, 700, 300);

	}
}
