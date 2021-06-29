package NEGOCIO;

public class Hora {
	int H;
	public Hora()
	{
		H= 0;
	}
	public void asignarMes(int M) {
	int K=7;
	K=K<<7;
	K =K;
	H=H & K;
	M=M<<7;
	H=H|M;}
	public void asignarHora (int A) 
	{
	    H = H << 20;
		H= H>>> 20;
		A = A << 12;
		H= H |A;
		//System.out.print("Bits de hora:" +Integer.toBinaryString(A));
	}
	
		private int obtenerSegundos()
		{
		  return 0;
		}
		private int obtenerMinutos()
		{
			return 0;
		}
		private int obtenerHora()
		{
			int A= H;
			A=A>>>12;
		 	return A;
		}
		public static void main(String[]args)
		{
			Hora bt = new Hora();
			bt.asignarHora(15);
			System.out.print("Bits de hora:" +Integer.toBinaryString(bt.H));
		}
}
