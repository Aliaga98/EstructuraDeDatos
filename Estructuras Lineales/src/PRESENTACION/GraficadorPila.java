package PRESENTACION;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import NEGOCIO.Nodo;
import NEGOCIO.Pila;

public class GraficadorPila extends JPanel 
{
	public Pila pl;
	/**
	 * Create the panel.
	 */
	public GraficadorPila(Pila pl) 
	{
		this.pl= pl;
	}
	
	@Override
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		
		int py= 20;
		Nodo vista= pl.Primero;
		while(vista!=null)
		{
			g2.drawRect(20, py, 40, 40);
			g2.drawRect(20, py, 40, 60);
			g2.drawString(vista.Ele.toString(), 22, py+20);
			g2.drawLine(40, py+50, 40, py+80);

			py= py + 80;
			vista=  vista.Ref;
		}
	}

}
