package PRESENTACION;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import NEGOCIO.ListaDoble;
import NEGOCIO.NodoDoble;

public class GrafListaDoble extends JPanel 
{

	public ListaDoble lis; 
	
	public GrafListaDoble(ListaDoble lis) 
	{
		this.lis= lis;
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		
		int px= 20;
		NodoDoble ndAux= lis.primero; 
		while(ndAux!=null)
		{
			//GRAFICA EL NODO
			g2.setStroke(new BasicStroke(2)); //ESPESOR DEL MARCADOR
			g2.setColor(Color.blue); // COLOR DEL MARCADOR
			
			g2.drawRect(px, 20, 20, 40); 
			g2.drawRect(px, 20, 40, 40);
			g2.drawRect(px, 20, 60, 40);
			
			g2.drawLine(px+50, 30, px+80, 30); //DIBUJA REF SGTE
			g2.drawLine(px-20, 50, px+10, 50); //DIBUJA REF ANTERIOR
			
			g2.drawString(ndAux.ele.toString(), px+3, 40); // PINTA EL ELEMENTO			
			px= px + 80;

			ndAux= ndAux.refSgte;
		}
	}

}
