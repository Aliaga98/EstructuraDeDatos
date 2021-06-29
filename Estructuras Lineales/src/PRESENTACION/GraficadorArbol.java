package PRESENTACION;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Point2D;

import javax.swing.JPanel;

import com.sun.corba.se.impl.interceptors.PINoOpHandlerImpl;

import NEGOCIO.ArbolBinario;
import NEGOCIO.NodoBin;

public class GraficadorArbol extends JPanel {

	public ArbolBinario ArbBin;
	
	public GraficadorArbol(ArbolBinario arbolBin) 
	{
		ArbBin=arbolBin;
	}
	
	public void paint(Graphics g) 
	{
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		g2.setStroke(new BasicStroke(3));

		GradientPaint rojoazul= new GradientPaint(0, 0, Color.RED, this.getWidth(), this.getHeight(), Color.BLUE);
		g2.setPaint(rojoazul);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		graficarArbolRec(140, 380, 20, g2, ArbBin.Raiz);
	}
	
	public void graficarArbolRec(int dp, int x, int y, Graphics2D g2, NodoBin padre) 
	{
		if(padre!=null)
		{
			g2.setColor(Color.ORANGE);
			g2.fillOval(x-15, y-15, 30, 30);
			g2.setColor(Color.BLACK);
			g2.drawOval(x-15, y-15, 30, 30);

			g2.drawString(padre.Ele+"", x, y);
			
			if(padre.RefIzq!=null)
			{
				g2.drawLine(x-dp, y+50, x, y);
			}
			graficarArbolRec(dp-40, x-dp, y+50, g2, padre.RefIzq); //RECURSIVO
			
			if(padre.RefDer!=null)
			{
				g2.drawLine(x+dp, y+50, x, y);
			}
			graficarArbolRec(dp-40, x+dp, y+50, g2, padre.RefDer); //RECURSIVO
		}
	}

}
