/*
ENUNCIADO PROBLEMA 651 

Alineación de fútbol

Si dejamos de lado los partidos de fútbol en los patios de colegio donde todos los niños corren sin control detrás del balón, nos encontramos normalmente equipos organizados en donde cada jugador ocupa un puesto concreto. Aunque existen combinaciones imaginativas, lo habitual es hablar de tres líneas de jugadores (además del portero): defensas, medios y delanteros. Una de las labores del entrenador antes del partido es decidir cuántos irán a cada línea. Así, por ejemplo, se puede ver la distribución 4 4 2 en la que hay 4 defensas, 4 medios y 2 delanteros.

Los jugadores, por su parte, se sienten cómodos solo en algunas demarcaciones. Existen jugadores que son buenos solo cuando juegan como defensas, otros que valen como medios o delanteros y algunos que pueden colocarse en cualquiera de las tres líneas.

Teniendo en cuenta las habilidades de la plantilla, el entrenador podrá (o no) utilizar ciertas distribuciones concretas.
Entrada

La entrada está compuesta de distintos casos de prueba, cada uno ocupando tres líneas.

La primera contiene tres números: el número de jugadores que se colocarán como defensas, como medios y como delanteros respectivamente. Algunos de esos números pueden ser cero pero la suma de todos ellos no excederá 10.

A continuación aparece una línea con el número de jugadores que hay en la plantilla (como mucho 25). La última línea contiene la descripción de cada uno de los jugadores, entendiendo ésta como las posiciones en las que ese jugador puede colocarse. La descripción consiste en una o más letras seguidas con el siguiente significado: F para defensa, C para centro y D para delantero.

Se garantiza que el número de jugadores en plantilla es mayor o igual que el número de jugadores que deben saltar al campo.

La entrada termina con una línea con tres ceros que no debe procesarse.
Salida

Por cada caso de prueba se escribirá una línea independiente en la que SI indicará que existe al menos una asignación de jugadores a puestos en la que todos tengan una demarcación favorable y NO en caso contrario.
Entrada de ejemplo

4 3 3
10
F C D FC DF DCF CD DC DC FD
3 3 3
11
F F F F C C C C D D F
0 0 0

Salida de ejemplo

SI
NO
*/


package aop;
// Esquema de la entrada: caso de prueba que marca el final
import java.util.*;



public class p651 {
	static class Posicion{
		boolean puedeF, puedeC, puedeD;

		public Posicion() {
			puedeF = false;
			puedeC = false;
			puedeD= false;
		}

		public void setPuedeF(boolean F) {
			puedeF = F;
		}

		public void setPuedeC(boolean C) {
			puedeC = C;
		}

		public void setPuedeD(boolean D) {
			puedeD = D;
		}
	}
	
	static boolean posibleAlineacion(int currentF, int currentC, int currentD, int F, int C, int D, int n_jug, ArrayList<Posicion> posiciones) {
		
		
		if (currentF >= F && currentC >= C && currentD >= D) return true;
		int jug_rest = posiciones.size() - n_jug;
		
		if (jug_rest == 0 || ( F - currentF ) > jug_rest || ( C - currentC ) > jug_rest || ( D - currentD ) > jug_rest) return false;
		boolean pos_f, pos_c, pos_d;
		
		pos_f = ( currentF < F ) && posiciones.get(n_jug).puedeF;
		pos_c = ( currentC < C ) && posiciones.get(n_jug).puedeC;
		pos_d = ( currentD < D ) && posiciones.get(n_jug).puedeD;
		
		if (pos_f) {
			if(posibleAlineacion(currentF + 1, currentC, currentD, F, C, D, n_jug + 1, posiciones)) 
				return true;
		}
		
		if (pos_c) {
			if(posibleAlineacion(currentF, currentC + 1, currentD, F, C, D, n_jug + 1, posiciones)) 
				return true;
		}
		
		if (pos_d) {
			if(posibleAlineacion(currentF, currentC, currentD + 1, F, C, D, n_jug + 1, posiciones)) 
				return true;
		}
		
		
		
		if(!pos_f && !pos_c && !pos_d) return posibleAlineacion(currentF, currentC, currentD, F, C, D, n_jug + 1, posiciones);
		return false;
	}
	static Scanner in;
	
	public static boolean casoDePrueba() {

		// LEER CASO DE PRUEBA
		int F, C, D, njugadores;
		F = in.nextInt();
		C = in.nextInt();
		D = in.nextInt();

		if (F == 0 && C == 0 && D == 0)
			return false;
		else {
			// CÓDIGO PRINCIPAL AQUÍ
			njugadores = in.nextInt();
			ArrayList<Posicion> posiciones = new ArrayList<>();

			for(int i = 0; i < njugadores; i++) {
				String strPos = in.next();
				Posicion pos = new Posicion();
				if(strPos.contains("F")) pos.setPuedeF(true);
				if(strPos.contains("C")) pos.setPuedeC(true);
				if(strPos.contains("D")) pos.setPuedeD(true);
				posiciones.add(pos);
			}
			if(posibleAlineacion(0, 0, 0, F, C, D, 0, posiciones))
				System.out.println("SI");
			else
				System.out.println("NO");

			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);

		while(casoDePrueba());

	} // main


}
