/*
ENUNCIADO PROBLEMA 620

Juegos en cintas

 La mayoría de los ordenadores de 8 bits utilizaban cintas de cassette como almacenamiento de sus programas y juegos. Las cintas, usadas como soporte de audio para música, guardaban la información binaria a través de sonidos. Su capacidad se medía en tiempo (normalmente minutos) y tenían dos caras de la misma capacidad. Se utilizaba una u otra dependiendo de cómo se insertara la cinta en la unidad lectora. Las cintas eran lentas, de acceso serie (tenían que rebobinarse para colocarlas en el punto donde comenzara el programa que se quería leer) y con el uso se estropeaban y fallaban.

Como los juegos se guardaban, literalmente, como audio, era fácil copiarlos de una cinta a otra con aparatos de doble pletina.

Bárbara Surada es aficionada a los juegos antiguos de Spectrum y Amstrad pero teme que las cintas de los juegos originales se le estropeen y los pierda. Quiere hacer copias en cintas vírgenes como copia de seguridad. Para no tener que andar rebobinando mucho para encontrar el juego que quiere, como mucho meterá 8 juegos en cada cinta (entre las dos caras). Lo que no sabe es si, dado lo que dura cada juego, podrá o no meterlos en la misma cinta.
Entrada

El programa deberá leer múltiples casos de prueba de la entrada estándar.

Cada caso de prueba comienza con una línea con dos números. El primero indica el tamaño de cada una de las dos caras de la cinta virgen donde se quiere hacer la copia de los juegos (entre 1 y 108). El segundo indica el número de juegos que se quieren copiar (entre 1 y 8).

A continuación aparece una segunda línea con la duración de cada uno de los juegos (entre 1 y 108).
Salida

Por cada caso de prueba el programa escribirá "SI" si es posible grabar los juegos en la cinta, y "NO" en otro caso. Los juegos no pueden cortarse, de modo que cada uno debe estar completo en una única cara.

No es necesario dejar separación entre dos juegos consecutivos en la cinta.
Entrada de ejemplo

10 4
7 7 3 3
10 3
4 7 7

Salida de ejemplo

SI
NO


*/

package aop;
import java.util.*;

public class ej620 {

	static Scanner in;

	public static boolean asignarJuegos(int cara1, int cara2, int[] juegos, int juegoActual) {
		if(juegoActual == juegos.length)
			return cara1 >= 0 && cara2 >= 0;
		
		if(cara1 >=0 && cara1 >= juegos[juegoActual]) {
			if(asignarJuegos(cara1 - juegos[juegoActual], cara2, juegos, juegoActual + 1))
				return true;
		}
		
		if(cara2 >= 0 && cara2 >= juegos[juegoActual]) {
			return asignarJuegos(cara1, cara2 - juegos[juegoActual], juegos, juegoActual + 1);
		}
		
		return false;
		
	}
	
	public static boolean casoDePrueba() {

		if (!in.hasNext())
			return false;
		else {
			int tamCara, nJuegos;
			tamCara = in.nextInt();
			nJuegos = in.nextInt();
			
			int[] juegos = new int[nJuegos];
			
			for(int i = 0; i < nJuegos; i++)
				juegos[i] = in.nextInt();
			
			System.out.println(asignarJuegos(tamCara, tamCara, juegos, 0)? "SI":"NO");

			return true;
		}

	} // casoDePrueba

	public static void main(String[] args) {

		in = new java.util.Scanner(System.in);
		while(casoDePrueba())
			;

	} // main

}
