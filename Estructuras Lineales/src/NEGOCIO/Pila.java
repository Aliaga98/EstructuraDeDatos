/**
 * 
 */
package NEGOCIO;

/**
 * @author LABD-DOCENTE
 *
 */
public class Pila {

	public Nodo Primero;
	/**
	 * 
	 */
	public Pila() 
	{
		Primero= null;
	}
	
	public boolean estaVacia()
	{
		return (Primero==null);
	}
	
	public void apilar(Nodo nd)
	{
		if (estaVacia()) 
		{
			Primero= nd;
		} 
		else 
		{
			nd.Ref= Primero;
			Primero= nd;
		}
	}
	
	public Nodo retirar()
	{
		if(!estaVacia())
		{
			Nodo nd= Primero;
			if(Primero.Ref==null)
			{
				Primero=null;
			}
			else
			{
				Primero= Primero.Ref;
			}
			return nd;
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		/*Pila pl= new Pila();
		
		Nodo n1= new Nodo("DAYANA");
		pl.apilar(n1);

		Nodo n2= new Nodo("LUIS");
		pl.apilar(n2);

		Nodo n3= new Nodo("HERNAN"); 
		pl.apilar(n3);
		
		pl.retirar();
		
		pl.retirar();
		
		pl.retirar();*/
		
		int A=18;
		int B=6;
		System.out.println("A:"+Integer.toBinaryString(A));
		System.out.println("B:"+Integer.toBinaryString(B));
		
		int R=A<<3;
		System.out.println(Integer.toBinaryString(R));
		
		int S=A>>3;
		System.out.println(Integer.toBinaryString(S));
		
		int T=A>>>3;
		System.out.println(Integer.toBinaryString(T));
		
		int U=A & B;
		System.out.println("AND:"+Integer.toBinaryString(U));
		
		int W=A | B;
		System.out.println("OR:"+Integer.toBinaryString(W));
		
		int X= A ^ B;
		System.out.println(Integer.toBinaryString(X));
		
		int Y= ~A;
		System.out.println(Integer.toBinaryString(Y));
	}

}
