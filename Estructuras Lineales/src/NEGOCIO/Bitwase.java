package NEGOCIO;

public class Bitwase {

	public int F;
	
	public Bitwase() 
	{
		F=0;
	}
	
	public void asignarDia(int D)
	{
		F= F << 21; //DESECHAR LOS BITS DE DIA 
		F= F >>> 21; // Y VUELVO CON CEROS 
		
		D=D << 11; //PREPARANDO DIA PARA INSERTAR
		F=F | D; // INSERTARDO DIA A FECHA
	}
	
	public void asignarMes(int M)
	{
		// LIMPIAR LOS BITS DEL MES EN FECHA 
		int K=7;
		K=K << 7;
		K=~ K;
		F= F & K;
		
		//INSERTA LOS BITS DEL MES
		M= M << 7; 
		F= F | M;    
	}

	public void asignarAnio(int A)
	{
		F= F >>> 7; //BARRIDO
		F= F << 7;  //BARRIDO
		F= F | A;
	}
	
	private int obtenerDia() 
	{
		return 0;
	}

	private int obtenerMes() 
	{
		return 0;
	}
	
	public int obtenerAnio()
	{
		int A=F;
		A=A<<25;
		A=A>>>25;
		return A;
	}
	

	public static void main(String[] args) 
	{
		Bitwase bt= new Bitwase();
		bt.asignarDia(22);
		bt.asignarMes(4);
		bt.asignarAnio(19);
		System.out.println("BITS DE FECHA:"+Integer.toBinaryString(bt.F));
		
		System.out.println(bt.obtenerDia()+"/"+bt.obtenerMes()+"/"+bt.obtenerAnio());
		
		/*int A=18;
		int B=21;
		int C=-3;
		System.out.println("A:"+Integer.toBinaryString(A));
		System.out.println("B:"+Integer.toBinaryString(B));
		System.out.println("C:"+Integer.toBinaryString(C));
		
		int R=A<<3;
		System.out.println("DESP 3 IZQ:"+Integer.toBinaryString(R));

		int S=A>>3;
		System.out.println("DESP 3 DER POSITIVO:"+Integer.toBinaryString(S));

		int T=C>>3;
		System.out.println("DESP 3 DER NEGATIVO:"+Integer.toBinaryString(T));

		int U=A>>>3;
		System.out.println("DESP 3 DER SIN SIGNO:"+Integer.toBinaryString(U));

		int V=A & B;
		System.out.println("AND:"+Integer.toBinaryString(V));

		int W=A | B;
		System.out.println("OR:"+Integer.toBinaryString(W));

		int X=A ^ B;
		System.out.println("XOR:"+Integer.toBinaryString(X));

		int Y=~A; //ALT + 126 = ~
		System.out.println("NEGACION:"+Integer.toBinaryString(Y));
		
		byte M=127;*/

	}



}
