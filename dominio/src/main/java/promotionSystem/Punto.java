package promotionSystem;

	public class Punto implements Comparable<Punto>{

		private int x;
		private int y;
		
		public Punto(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public double distanciaCon(Punto punto) {
			return Math.sqrt( Math.pow(this.x - punto.x, 2)
					+ Math.pow(this.y - punto.y, 2));
		}

		public int  getX() {
			return x;
		}
		public int  getY() {
			return y;
		}

		public int compareTo( Punto otroPunto){              //es necesario definir un comparador para el correcto funcionamiento del PriorityQueue
			if( y > otroPunto.y ) return 1;
			if( x == otroPunto.x ) return 0;
			return -1;
		}
}
