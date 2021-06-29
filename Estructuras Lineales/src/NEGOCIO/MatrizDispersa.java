package NEGOCIO;

public class MatrizDispersa 
{
	public Lista list;
	public int Filas;
	public int Columnas;
	
	public MatrizDispersa(int filas, int columnas) 
	{
		this.list= new Lista();
		this.Filas= filas;
		this.Columnas= columnas;
	}

	public int obtenerEle(int f, int c) 
	{
		NodoDoble ndAux= list.Vista;
		while(ndAux!=null)
		{
			int vec[]= (int [])ndAux.Ele;
			if(vec[1]==f && vec[2]==c)
			{
				return vec[0];
			}
			ndAux= ndAux.RefSgte;
		}
		return 0;
	}
	
	public void agregarEle(int valor, int f, int c)
	{
		int vec[]= {valor, f, c};
		NodoDoble nd= new NodoDoble(vec);
		list.agregarUltimo(nd);
	}

	public void asignarTam(int filas, int columnas) 
	{
		this.Filas= filas;
		this.Columnas= columnas;
	}

}
