package PRESENTACION;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormPrincipal extends JFrame {

	private JPanel contentPane;

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
	public FormPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 701, 318);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("ARCHIVO");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnEstructuras = new JMenu("ESTRUCTURAS");
		menuBar.add(mnEstructuras);
		
		JMenuItem mntmPila = new JMenuItem("PILA");
		mnEstructuras.add(mntmPila);
		
		JMenuItem mntmCola = new JMenuItem("COLA");
		mnEstructuras.add(mntmCola);
		
		JMenuItem mntmListaDoble = new JMenuItem("LISTA DOBLE");
		mntmListaDoble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				FormListaDoble f= new FormListaDoble();
				getContentPane().add(f);
				f.setVisible(true);
			}
		});
		mnEstructuras.add(mntmListaDoble);
		
		JMenuItem mntmRonda = new JMenuItem("RONDA");
		mnEstructuras.add(mntmRonda);
		
		JMenuItem mntmMatrizEsparcida = new JMenuItem("MATRIZ ESPARCIDA");
		mnEstructuras.add(mntmMatrizEsparcida);
		
		JMenuItem mntmBitwise = new JMenuItem("BITWISE");
		mnEstructuras.add(mntmBitwise);
		
		JMenuItem mntmArbolBin = new JMenuItem("ARBOL BIN");
		mnEstructuras.add(mntmArbolBin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.setExtendedState(MAXIMIZED_BOTH);
	}

}
