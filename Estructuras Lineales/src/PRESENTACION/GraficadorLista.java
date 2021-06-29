package PRESENTACION;

import javax.swing.JPanel;

import NEGOCIO.Cola;
import NEGOCIO.Lista;
import NEGOCIO.Nodo;
import NEGOCIO.NodoDoble;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GraficadorLista extends JPanel {

	public Lista lt;
	/**
	 * Create the panel.
	 */
	public GraficadorLista(Lista lt) 
	{
		this.lt= lt;
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		
		//GRAFICA TODA LA COLA
		int px=20;
		NodoDoble ndAux= lt.Primero;
		while(ndAux!=null)
		{
			//GRAFICA EL NODO
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.blue);
			
			g2.drawRect(px, 20, 20, 40); 
			g2.drawRect(px, 20, 40, 40);
			g2.drawRect(px, 20, 60, 40);
			
			g2.drawLine(px+50, 30, px+80, 30); //DIBUJA REF SGTE
			g2.drawLine(px-20, 50, px+10, 50); //DIBUJA REF ANTERIOR
			
			g2.drawString(ndAux.Ele.toString(), px+3, 40); // PINTA EL ELEMENTO
			
			px= px + 80;
			ndAux= ndAux.RefSgte;
		}

	}

}
