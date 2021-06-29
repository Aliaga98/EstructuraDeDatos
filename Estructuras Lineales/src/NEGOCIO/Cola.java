/**
 * 
 */
package NEGOCIO;

/**
 * @author LABD-DOCENTE
 *
 */
public class Cola 
{
	/**
	 * VARIABLES O ATRIBUTOS GLOBALES DE LA CLASE COLA
	 */
	public Nodo Primero;
	public Nodo Ultimo;
	
	/**
	 * CONSTRUCTOR DE LA CLASE COLA
	 */
	public Cola() 
	{
		Primero= null;
		Ultimo= null;
	}
	
	/**
	 * METODO QUE DEVUELVE VERDADERO SI LA COLA ESTA VACIA, CASO CONTRARIO FALSO
	 * @return
	 */
	public boolean estaVacia()
	{
		return (Primero==null);
	}
	
	/**
	 * METODO QUE AGREGA UN NUEVO NODO CON SU ELEMENTO A LA COLA
	 * @param nd
	 */
	public void agregar(Nodo nd)
	{
		if(estaVacia())
		{
			Primero= nd;
			Ultimo= nd;
		}
		else
		{
			Ultimo.Ref= nd;
			Ultimo= nd;
		}
	}
	
	/**
	 *METODO QUE SACA UN NODO DE LA COLA
	 * @return
	 */
	public Nodo sacar()
	{
		if(!estaVacia())
		{
			Nodo nd= Primero;
			if(Primero==Ultimo)
			{
				Primero= null;
				Ultimo= null;
			}
			else
			{
				Primero= nd.Ref;
			}
			return nd;
		}
		return null;
	}
	
	/**
	 * CONCATENA LOS ELEMENTOS DE LA COLA EN UN STRING 
	 * @return
	 */
	public String mostrar()
	{
		String s="";
		Nodo vista= Primero;
		while(vista!=null)
		{
			s= s + vista.Ele +"-";
			vista= vista.Ref;
		}
		return s;
	}
	
	/**
	 * METODO QUE INSERTA UN NODO EN UNA POSICION CUALQUIERA DENTRO DE LA COLA
	 * @param nd
	 * @param pos
	 */
	public void insertar(Nodo nd, int pos)
	{
		if(pos==1)
		{
			nd.Ref= Primero;
			Primero= nd;
		}
		else
		{
			int cont=1;
			Nodo vista= Primero;
			while (vista!=null) 
			{
				if(cont==pos-1)
				{
					nd.Ref= vista.Ref;
					vista.Ref= nd;
				}
				vista= vista.Ref;
				cont++;
			}
		}
	}
	

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Cola c= new Cola();
		
		Nodo n1= new Nodo("DAYANA");
		c.agregar(n1);
		System.out.println(c.mostrar());
		
		Nodo n2= new Nodo("CARRILLO");
		c.agregar(n2);
		System.out.println(c.mostrar());

		Nodo n3= new Nodo("HERNAN");
		c.agregar(n3);
		System.out.println(c.mostrar());
		
		Nodo n4= new Nodo("LUIS");
		c.insertar(n4, 4);
		System.out.println(c.mostrar());
		
		
		/*Nodo n4= c.sacar();
		System.out.println(c.mostrar());
		
		Nodo n5= c.sacar();
		System.out.println(c.mostrar());
		
		Nodo n6= c.sacar();
		System.out.println(c.mostrar());*/
		
	}

}
