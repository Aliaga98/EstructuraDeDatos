package PRESENTACION;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import NEGOCIO.NodoDoble;
import NEGOCIO.Ronda;

public class GraficadorRonda extends JPanel 
{
 
	public Ronda rond;
	
	public GraficadorRonda(Ronda rond) 
	{
		this.rond= rond;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2= (Graphics2D)g;
		if(rond.cantElementos()>0)
		{
			int radio= 100;
			int rango_angulo= 360 / rond.cantElementos();
			
			double valor_angulo= 0;
			int xv= 0;
			int yv= 0;
			
			int ang_var= 0;
			NodoDoble ndAux= rond.Vista;
			for (int i = 1; i <= rond.cantElementos(); i++) 
			{
				valor_angulo= Math.toRadians(ang_var);
				xv= (int) (radio * Math.cos(valor_angulo));
				yv= (int) (radio * Math.sin(valor_angulo));

				g2.setStroke(new BasicStroke(5));

				g2.setColor(Color.cyan);
				g2.fillRect(150 + xv, 150 +yv, 40, 40);
				g2.setColor(Color.black);
				g2.drawRect(150 + xv, 150 +yv, 40, 40);
				g2.drawString(""+ndAux.Ele, 150 + xv + 20, 150 + yv +20);
				if(i==1)
				{
					g2.setColor(Color.red);
					g2.fillOval(160, 160, 20, 20);
					g2.setColor(Color.black);
					g2.drawOval(160, 160, 20, 20);
					g2.drawLine(190 + xv, 170 + yv, 250 + xv, 170 + yv);
					g2.drawString("VISTA", 200 + xv, 170 + yv);
				}
				
				ang_var= ang_var + rango_angulo;
				ndAux= ndAux.RefSgte;
			}
		}
			
	}

}
