/*
ENUNCIADO PROBLEMA 298

¿Es un árbol binario de búsqueda?

Un árbol binario de búsqueda es un árbol binario cuyos nodos almacenan claves (y valores asociados a esas claves) que se mantienen ordenadas de la siguiente manera: la raíz del árbol contiene una clave que es estrictamente mayor que todas las claves almacenadas en el hijo izquierdo y estrictamente menor que todas las claves almacenadas en el hijo derecho; además, ambos hijos son árboles binarios de búsqueda.

De los siguientes árboles (con números enteros como claves) solamente el de la derecha es un árbol binario de búsqueda.

Un árbol que no es de búsqueda y otro que sí lo es

Dado un árbol binario, el problema consiste en decidir si es o no un árbol binario de búsqueda.
Entrada

La entrada comienza con el número de casos que vienen a continuación. Cada caso de prueba consiste en una línea con la descripción de un árbol binario: primero aparece su raíz (un entero no negativo), y a continuación la descripción del hijo izquierdo y después la del hijo derecho. El número −1 indica el árbol vacío. Los árboles nunca contendrán más de 4.000 nodos.
Salida

Para cada árbol se escribirá SI si el árbol es un árbol binario de búsqueda y NO si no lo es.
Entrada de ejemplo

4
1 2 4 -1 -1 5 -1 -1 3 -1 6 -1 -1
5 4 1 -1 -1 -1 8 6 -1 -1 9 -1 -1
-1
2 2 -1 -1 -1

Salida de ejemplo

NO
SI
SI
NO

*/


package aop;

import java.io.IOException;
import java.io.InputStream;
//Esquema de la entrada: número de casos

public class ej298 {

	public static class Nodo{
		int valor;
		Nodo izq, dch;

		public Nodo(int valor) {
			this.valor = valor;
		}

		public void setIzq(Nodo izq) {
			this.izq= izq;
		}

		public void setDch(Nodo dch) {
			this.dch = dch;
		}

	}
	
	static MyScanner in = new MyScanner(System.in);
	static boolean  error;
	
	public static void casoDePrueba() {

		error = false;
		int valor = in.nextInt();

		if(valor != -1) {
			Nodo raiz = new Nodo(valor);
			rellenarArbol(raiz);
			recorrerArbol(raiz, null, null);
		}


		if(error) 
			System.out.println("NO");
		else
			System.out.println("SI");


	} // casoDePrueba

	public static void main(String[] args) {


		int numCasos = in.nextInt();
		for (int i = 0; i < numCasos; i++)
			casoDePrueba();

	} // main

	public static void rellenarArbol(Nodo nodo) {

		Nodo aux = null;
		int valor = in.nextInt();
		if(valor != -1) {
			aux = new Nodo(valor);
			nodo.setIzq(aux);
			rellenarArbol(aux);
		}

		valor = in.nextInt();
		if(valor != -1) {
			aux = new Nodo(valor);
			nodo.setDch(aux);
			rellenarArbol(aux);
		}
	}

	public static void recorrerArbol(Nodo nodo, Integer min, Integer max) {
		if(error == false) {
			if((max != null &&  nodo.valor >= max ) ||  (min != null && nodo.valor <= min ))
				error = true;
			else {
				if(nodo.izq !=null)
					recorrerArbol(nodo.izq, min, nodo.valor);
				if(nodo.dch !=null)
					recorrerArbol(nodo.dch, nodo.valor, max);
			}


		}
	}

} // class Solution

class MyScanner {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;

    public MyScanner(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1)
            throw new RuntimeException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new RuntimeException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }


    public boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
}
