package NEGOCIO;

public class Ronda 
{
	public NodoDoble Vista;
	
	public Ronda() 
	{
		this.Vista= null;
	}
	
	public void insertar(NodoDoble nd)
	{
		if(estaVacia())
		{
			Vista= nd;
		}
		else
		{
			if(existeUnElemento())
			{
				Vista.RefSgte= nd;
				Vista.RefAnt= nd;
				nd.RefSgte= Vista;
				nd.RefAnt= Vista;
			}
			else
			{
				Vista.RefAnt.RefSgte= nd;
				nd.RefAnt= Vista.RefAnt;
				Vista.RefAnt= nd;
				nd.RefSgte= Vista;
			}
		}
	}
	
	public boolean estaVacia()
	{
		return (Vista==null);
	}
	
	public boolean existeUnElemento()
	{
		return (Vista.RefSgte==null);
	}
	
	public int cantElementos()
	{
		if(Vista==null)
		{
			return 0;
		}
		else
		{
			if(Vista.RefSgte==null)
			{
				return 1;
			}
			else
			{
				NodoDoble ndAux= Vista.RefSgte;
				int cont=1;
				while(ndAux!=Vista)
				{
					cont++;
					ndAux= ndAux.RefSgte;
				}
				return cont;
			}
		}
	}
	
	public NodoDoble remover()
	{
		NodoDoble nd= null;
		if(!estaVacia())
		{
			if(existeUnElemento())
			{
				nd= Vista;
				Vista=null;
			}
			else
			{
				if(existeDosElementos())
				{
					nd= Vista.RefAnt;
					Vista.RefAnt= null;
					Vista.RefSgte= null;
				}
				else
				{
					/*NodoDoble ubic= Vista.RefAnt;
					ubic.RefAnt.RefSgte= Vista;
					Vista.RefAnt= ubic.RefAnt;*/
					
					nd= Vista.RefAnt;
					Vista.RefAnt.RefAnt.RefSgte= Vista;
					Vista.RefAnt= Vista.RefAnt.RefAnt;					
				}
			}
		}
		return nd;
	}

	public boolean existeDosElementos() 
	{
		return (Vista.RefSgte.RefSgte==Vista);
	}
	
	public void rotar(int cantPosiciones)
	{
		for (int i = 1; i <= cantPosiciones; i++) 
		{
			Vista= Vista.RefAnt;
		}
	}

}
