/*
ENUNCIADO PROBLEMA 722

Tú uno y yo dos

 Pese a su ascendencia griega, para su última fiesta de cumpleaños, Tsitsipas Telero se dedicó a hacer macarons, un tipo de galleta tradicional de la gastronomía francesa. Los colocó formando dos largas filas que fueron mermando según transcurría la tarde.

En un momento dado, sus dos hijos se acercaron a la mesa con la intención de dar buena cuenta de los que quedaban. La mayor, de 10 años, le dijo al pequeño, de 5, "como tú tienes la mitad de años que yo, tú coges uno de una fila y yo cojo dos de la otra, y así hasta que se acaben". Afortunadamente el padre les oyó y llegó a tiempo para evitar tanto una indigestión de los pequeños como que el resto de invitados se quedara sin macarons. Sabiendo que era imposible, les dijo que solo les permitiría seguir su plan si de verdad iban a conseguir repartirse todos sin que sobrara ninguno.
Entrada

Cada caso de prueba está compuesto por cuatro números. Los dos primeros indican el número de macarons que quedan en cada una de las dos filas colocadas por Tsitsipas. Los otros dos indican cuántos cogen, simultáneamente, cada uno de los dos niños. Todos los números están entre 1 y 2.000.000.000.

Ten en cuenta que, al coger sus macarons, los niños lo hacen cada uno de una fila. Si, tras hacerlo aún quedan más, la siguiente vez que cogen pueden hacerlo cada uno de la misma fila que antes o de la contraria.

La entrada termina con un caso con cuatro ceros, que no debe procesarse.
Salida

Por cada caso de prueba el programa escribirá "SI" si los niños pueden repartirse, por este mecanismo, todos los macarons que quedan, y "NO" en caso contrario.
Entrada de ejemplo

2 1 1 2
2 2 2 1
4 4 3 1
3 6 4 4
0 0 0 0

Salida de ejemplo

SI
NO
SI
NO

*/


package aop;
import java.util.Scanner;

public class p32_v3 {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			long fila1 = sc.nextLong();
			long fila2 = sc.nextLong();
			long a = sc.nextLong();
			long b = sc.nextLong();
			while (fila1 != 0 || fila2 != 0 || a != 0 || b != 0) {
				/*
				f1 = ax + by
				f2 = ay + bx
				 */
				
				if(a != b) {
					long x = ((fila1*a) - (b*fila2)) / ((a*a) - (b*b));
					long y = ((a*fila2) - (fila1*b)) / ((a*a) - (b*b));
					
					
					boolean b1 = a * x + b * y - fila1 == 0;
	                boolean b2 = a * y + b * x - fila2 == 0;
	                if(x < 0 || y < 0) {
	                	System.out.println("NO");
	                }else {
		                if(b1 && b2)
		                	System.out.println("SI");
		                else
		                	System.out.println("NO");
	                }
	                


				}else {
					System.out.println(
                            (fila1 == fila2 && fila1 % a == 0)
                                    ? "SI" : "NO");
				}
				
				
				fila1 = sc.nextLong();
				fila2 = sc.nextLong();
				a = sc.nextLong();
				b = sc.nextLong();

			}
		}
	}
	
}
