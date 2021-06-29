package NEGOCIO;

public class NodoDoble 
{
	public Object Ele;
	public NodoDoble RefSgte;
	public NodoDoble RefAnt;
	
	public NodoDoble(Object ele) 
	{
		this.Ele= ele;
		this.RefSgte= null;
		this.RefAnt= null;
	}

}
