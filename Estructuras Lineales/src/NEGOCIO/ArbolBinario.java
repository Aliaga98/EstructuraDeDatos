package NEGOCIO;

public class ArbolBinario 
{

	public NodoBin Raiz;
	
	public ArbolBinario() 
	{
		Raiz= null;
	}
	
	public void insertar(NodoBin nd)
	{
		if(Raiz==null)
		{
			Raiz= nd;
		}
		else
		{
			NodoBin padre=Raiz;
			boolean insertado= false;
			while(!insertado)
			{
				if(nd.Ele >= padre.Ele)
				{
					if(padre.RefDer==null)
					{
						padre.RefDer= nd;
						insertado= true;
					}
					else
						padre= padre.RefDer;
				}
				else
				{
					if(padre.RefIzq==null)
					{
						padre.RefIzq= nd;
						insertado= true;
					}
					else
						padre= padre.RefIzq;
					
				}
			}
		}
	}
	
	public void agregar(NodoBin nd)
	{
		Raiz= agregarRecursivo(nd, Raiz);
	}

	private NodoBin agregarRecursivo(NodoBin nd, NodoBin rz) 
	{
		return null;
	}
	
	public Lista recorridoInOrden()
	{
		Lista lis= new Lista();
		recorridoInOrdenRec(lis, Raiz);
		return lis;
	}
	
	public void recorridoInOrdenRec(Lista lis, NodoBin padre)
	{
		if(padre!=null)
		{
			recorridoInOrdenRec(lis, padre.RefIzq);
			
			NodoDoble nd= new NodoDoble(padre.Ele);
			lis.agregarUltimo(nd);
			
			recorridoInOrdenRec(lis, padre.RefDer);
		}
	}
	
	public Lista recorridoPreOrden()
	{
		Lista lis= new Lista();
		recorridoPreOrdenRec(lis, Raiz);
		return lis;
	}
	
	public void recorridoPreOrdenRec(Lista lis, NodoBin padre)
	{
		if(padre!=null)
		{
			NodoDoble nd= new NodoDoble(padre.Ele);
			lis.agregarUltimo(nd);
			
			recorridoPreOrdenRec(lis, padre.RefIzq);
			recorridoPreOrdenRec(lis, padre.RefDer);
		}
	}
	
	public Lista recorridoPostOrden()
	{
		Lista lis= new Lista();
		recorridoPostOrdenRec(lis, Raiz);
		return lis;
	}
	
	public void recorridoPostOrdenRec(Lista lis, NodoBin padre)
	{
		if(padre!=null)
		{
			recorridoPostOrdenRec(lis, padre.RefIzq);
			recorridoPostOrdenRec(lis, padre.RefDer);
			
			NodoDoble nd= new NodoDoble(padre.Ele);
			lis.agregarUltimo(nd);
		}
	}
	
	//METODO MASCARA QUE LLAMA A RECURSIVO
	public int cantElementos()
	{
		//MAS UNO POR LA RAIZ
		int cant=0;
		return cantElementosRec(Raiz, cant) + 1;
	}
	
	//METODO RECURSIVO QUE SE LLAMA SI MISMO DOS VECES
	private int cantElementosRec(NodoBin padre, int cant)
	{
		if(padre!=null)
		{
			if(padre.RefDer!=null)
			{
				cant++;
				cant= cantElementosRec(padre.RefDer, cant);
			}
			if(padre.RefIzq!=null)
			{
				cant++;
				cant= cantElementosRec(padre.RefIzq, cant);				
			}
		}
		return cant;
	}
	
	public int sumaElementos()
	{
		int sum= 0;
		return sumaElementosRec(Raiz, sum) + Raiz.Ele;
	}
	
	private int sumaElementosRec(NodoBin padre, int sum) 
	{
		if(padre!=null)
		{
			if(padre.RefDer!=null)
			{
				sum= sum + padre.RefDer.Ele;
				sum= sumaElementosRec(padre.RefDer, sum);
			}
			if(padre.RefIzq!=null)
			{
				sum= sum + padre.RefIzq.Ele;
				sum= sumaElementosRec(padre.RefIzq, sum);
			}
		}
		return sum;
	}
	
	public int cantHojas()
	{
		return cantHojasRec(Raiz);
	}
	
	private int cantHojasRec(NodoBin padre) 
	{
		int cont=0;
		if(padre!=null)
		{
			if(padre.RefDer==null && padre.RefIzq==null)
			{
				cont++;
			}
			cont= cont + cantHojasRec(padre.RefDer);
			cont= cont + cantHojasRec(padre.RefIzq);
		}
		return cont;
	}
	
	public int cantPadres()
	{
		return cantPadresRec(Raiz);
	}

	private int cantPadresRec(NodoBin padre) 
	{
		int cont=0;
		if(padre!=null)
		{
			if(padre.RefDer!=null || padre.RefIzq!=null)
			{
				cont++;
			}
			cont= cont + cantPadresRec(padre.RefDer);
			cont= cont + cantPadresRec(padre.RefIzq);
		}
		return cont;
	}
	
	public boolean completo()
	{
		boolean completo= true;
		return completoRec(Raiz, completo);
	}

	private boolean completoRec(NodoBin padre, boolean completo) 
	{
		if(padre!=null)
		{
			if( (padre.RefDer!=null && padre.RefIzq==null) || (padre.RefDer==null && padre.RefIzq!=null) )
			{
				completo= false;
			}
			completo= completoRec(padre.RefDer, completo);
			completo= completoRec(padre.RefIzq, completo);
		}
		return completo;
	}
	
	public int mayorElemento()
	{
		int may=Raiz.Ele;
		return mayorElementoRec(Raiz, may);
	}
	
	private int mayorElementoRec(NodoBin padre, int may)
	{
		if(padre!=null)
		{
			if(padre.RefDer!=null)
			{
				may= padre.RefDer.Ele;
			}
			may= mayorElementoRec(padre.RefDer, may);
		}
		return may;
	}
	
	public int  mayEle(NodoBin nd)
	{
		NodoBin padre= nd;
		while (padre.RefDer!=null) 
		{
			padre= padre.RefDer;
		}
		return padre.Ele;
	}
	
	public void eliminar(int ele)
	{
		Raiz=eliminarRec(Raiz, ele);
	}
	public NodoBin eliminarRec(NodoBin padre,int ele)
	{
		if(padre!=null)
		{
			if(ele==padre.Ele)
			{
				if(esHoja(padre))
				{
					padre=null;
					return padre;
				}
				else
				{
					if(padre.RefIzq==null)
					{
					    return padre.RefDer;	
					}
					else
					{
						if(padre.RefDer==null)
						{
							return padre.RefIzq;
						}
						else
						{
							int mI=mayEle(padre.RefIzq);
							padre.Ele= mI;
							padre.RefIzq= eliminarRec(padre.RefIzq,mI);
							return padre;
						}
						
					}
				}
			}
			else
			{
				if(padre.Ele>ele)
					padre.RefIzq= eliminarRec(padre.RefIzq,ele);
				else
					padre.RefDer= eliminarRec(padre.RefDer,ele);
			}
		}
		return padre;
	}

	public int cantNivel()
	{
		return cantNivelRec(Raiz);
	}

	private int cantNivelRec(NodoBin nivel) 
	{
		int contNivel=0;
		if(nivel!=null)
		{
			if(nivel.RefDer!=null || nivel.RefIzq!=null)
			{
				contNivel++;
			}
			contNivel= contNivel + cantNivelRec(nivel.RefDer);
			contNivel= contNivel + cantNivelRec(nivel.RefIzq);
		}
		return contNivel;
	}
	
	public void remover(int ele)
	{
		NodoBin padre= Raiz;
		
		if(ele==Raiz.Ele)
			Raiz=null;
			
		while (padre!=null) 
		{
			if(ele >= padre.Ele)
			{
				if(padre.RefDer!=null && ele==padre.RefDer.Ele)
				{
					if(tieneHijoDer(padre))
						padre.RefDer= padre.RefDer.RefDer;
					else
						if(tieneDosHijos(padre))
						{
							padre.RefDer= padre.RefDer.RefDer;
							padre.RefDer= padre.RefDer.RefDer;
						}
						else
							padre.RefDer= null;
				}
				else
					padre= padre.RefDer;
			}
			else
			{
				if(padre.RefIzq!=null && ele==padre.RefIzq.Ele)
				{
					if(tieneHijoIzq(padre))
						padre.RefIzq= padre.RefIzq.RefIzq;
					else
						padre.RefIzq= null;
				}
				else
					padre= padre.RefIzq;
				
			}
		}
	}
	
	private boolean esHoja(NodoBin nd)
	{
		return (nd.RefDer==null && nd.RefIzq==null);
	}
	
	private boolean tieneDosHijos(NodoBin nd)
	{
		return (nd.RefDer!=null && nd.RefIzq!=null);
	}
	
	private boolean tieneHijoIzq(NodoBin nd)
	{
		return (nd.RefDer==null && nd.RefIzq!=null);
	}
	
	private boolean tieneHijoDer(NodoBin nd)
	{
		return (nd.RefDer!=null && nd.RefIzq==null);
	}

	public static void main(String[] args) {
		ArbolBinario arb= new ArbolBinario();
		arb.insertar(new NodoBin(10));
		arb.insertar(new NodoBin(5));
		arb.insertar(new NodoBin(15));
		arb.insertar(new NodoBin(20));
		arb.insertar(new NodoBin(13));
		arb.insertar(new NodoBin(8));
		arb.insertar(new NodoBin(2));
		
		Lista lis= arb.recorridoPostOrden();
		for (int i = 0; i < lis.cantElementos(); i++) {
			System.out.println(""+lis.obtenerElemento(i).Ele.toString());
		}
		
		System.out.println("CANTIDAD:"+arb.cantElementos());
		
	}


}
