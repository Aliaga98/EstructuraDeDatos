package NEGOCIO;

public class ListaDoble 
{
	
	public NodoDoble primero;
	public NodoDoble vista;
	public NodoDoble ultimo;

	public ListaDoble() 
	{
		
	}
	
	public void agregarUltimo(NodoDoble nd)
	{
		if(estaVacia())
		{
			primero= nd;
			vista= nd;
			ultimo= nd;
		}
		else
		{
			ultimo.refSgte= nd;
			nd.refAnt= ultimo;
			ultimo= nd;
		}
	}
	
	public void agregarPrimero(NodoDoble nd)
	{
		if(estaVacia())
		{
			primero= nd;
			vista= nd;
			ultimo= nd;
		}
		else
		{
			nd.refSgte= primero;
			primero.refAnt= nd;
			primero= nd;
			vista= nd;
		}
	}
	
	public void agregarPosicion(NodoDoble nd, int pos)
	{
		if(pos==1)
		{
			agregarPrimero(nd);
		}
		else
		{
			int cont=1;
			while (vista!=null) 
			{
				if(cont==pos)
				{
					vista.refAnt.refSgte= nd;
					nd.refAnt= vista.refAnt;
					nd.refSgte= vista;
					vista.refAnt= nd;
					vista= null;
				}
				else
				{
					vista= vista.refSgte;
					cont++;
				}
			}
			vista= primero;
		}
	}
	
	public boolean estaVacia()
	{
		return (primero==null);
	}
	
	public void mostrarElementos()
	{
		NodoDoble aux= primero;
		while (aux!=null) 
		{
			String ele= aux.ele.toString();
			System.out.println(ele);
			aux= aux.refSgte;
		}
	}

	public static void main(String[] args) 
	{
		ListaDoble lis= new ListaDoble();
		
		NodoDoble nd1= new NodoDoble(5); 
		NodoDoble nd2= new NodoDoble(8);
		NodoDoble nd3= new NodoDoble(2);
		NodoDoble nd4= new NodoDoble(3);
		
		lis.agregarUltimo(nd1);
		lis.agregarUltimo(nd2);
		lis.agregarUltimo(nd3);
		lis.agregarUltimo(nd4);
		
		lis.mostrarElementos();
		
		NodoDoble nd= new NodoDoble(6);
		lis.agregarPosicion(nd, 3);
		
		System.out.println("RESULTADO");
		lis.mostrarElementos();

		
	}

}
