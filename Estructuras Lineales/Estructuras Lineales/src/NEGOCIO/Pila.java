package NEGOCIO;

public class Pila 
{
	public Nodo vista;

	public Pila() 
	{
		
	}
	
	public void apilar(Nodo nd)
	{
		if(estaVacia())
		{
			vista=nd;
		}
		else
		{
			nd.ref= vista;
			vista= nd;
		}
	}
	
	public Nodo desapilar()
	{
		Nodo nd= null;
		if(!estaVacia())
		{
			if(unElemento())
			{
				nd= vista;
				vista=null;
				return nd;
			}
			else
			{
				nd= vista;
				vista= vista.ref;
				return nd;
			}
		}
		return nd;
	}
	
	public boolean estaVacia()
	{
		return (vista==null);
	}
	
	public boolean unElemento()
	{
		return (vista.ref==null);
	}
	
	public void mostrarElementos()
	{
		Nodo stge= vista;
		while (stge!=null) 
		{
			String ele= stge.ele.toString();
			System.out.println(ele);
			stge= stge.ref;
		}
	}

	public static void main(String[] args) 
	{
		Pila p= new Pila();
		Nodo nd1= new Nodo(2);
		Nodo nd2= new Nodo(4);
		Nodo nd3= new Nodo(8);
		Nodo nd4= new Nodo(5);
		
		p.apilar(nd1);
		p.apilar(nd2);
		p.apilar(nd3);
		p.apilar(nd4);
		
		p.mostrarElementos();
	}

}
