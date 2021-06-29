package NEGOCIO;

public class Cola 
{
	public Nodo primero;
	public Nodo ultimo;

	public Cola() 
	{
		
	}
	
	public void encolar(Nodo nd)
	{
		if(estaVacia())
		{
			primero= nd;
			ultimo= nd;
		}
		else
		{
			ultimo.ref= nd;
			ultimo= nd;
		}
	}
	
	public boolean estaVacia()
	{
		return (primero==null);
	}
	
	public void mostrarElementos()
	{
		Nodo sgte= primero;
		while(sgte!=null)
		{
			String ele= sgte.ele.toString();
			System.out.println(ele);
			sgte= sgte.ref;
		}
	}

	public static void main(String[] args) 
	{
		Cola c= new Cola();
		
		Nodo nd1= new Nodo(8);
		Nodo nd2= new Nodo(2);
		Nodo nd3= new Nodo(5);
		
		c.encolar(nd1);
		c.encolar(nd2);
		c.encolar(nd3);
		
		c.mostrarElementos();
	}

}
