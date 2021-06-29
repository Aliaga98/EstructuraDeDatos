package NEGOCIO;

public class NodoBin 
{
	public NodoBin RefDer;
	public NodoBin RefIzq;
	public int Ele;

	public NodoBin(int ele) 
	{
		Ele= ele;
		RefDer= null;
		RefIzq= null;
	}

}
