package PRESENTACION;

import javax.swing.JPanel;

import NEGOCIO.Cola;
import NEGOCIO.Nodo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GraficadorCola extends JPanel {

	public Cola cl;
	/**
	 * Create the panel.
	 */
	public GraficadorCola(Cola cl2) {
		cl= cl2;
	}

	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		
		//GRAFICA TODA LA COLA
		int px=20;
		Nodo vista= cl.Primero;
		while(vista!=null)
		{
			//GRAFICA EL NODO
			g2.setStroke(new BasicStroke(2));
			g2.setColor(Color.blue);
			
			g2.drawRect(px, 20, 40, 40);
			g2.drawRect(px, 20, 60, 40);
			g2.drawLine(px+50, 40, px+80, 40);
			g2.drawString(vista.Ele.toString(), px+3, 40);
			
			px= px + 80;
			vista= vista.Ref;
		}

	}

}
