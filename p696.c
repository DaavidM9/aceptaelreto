/*
ENUNCIADO PROBLEMA 696

De pinchos por la Laurel

Si le preguntas a cualquier persona de Logroño (ciudad al norte de España, capital de La Rioja) que te recomiende una zona para ir de pinchos, seguro que te habla de la calle Laurel. Los pinchos son una pequeña rebanada de pan sobre la que se coloca algún tipo de comida: un trozo de pescado, como bacalao o merluza; tortilla de patatas; pimientos con anchoas, etc.

Hay numerosas guías con la relación de bares que te puedes encontrar en la zona y las especialidades de cada uno de ellos. Estos bares suelen venir numerados, desde el 1 en adelante, así que el otro día cuando unos amigos me preguntaron a qué bares podrían ir, yo les di la guía y como no tenía muchas ganas de elegir, les dije que fueran a todos entre el 10 y el 20. Ellos, muy obedientes, con la guía en la mano, fueron recorriendo, sin ningún orden, todos los bares que encontraron entre esos dos números.

A la mañana siguiente no paraban de alabar todo lo que habían tomado y me dijeron los bares a los que habían ido (habían tenido la precaución de ir apuntándolos). En la lista ponía 11, 13, 19, 14, 18, 10, 12, 15, 20 y 16. Se habían dejado uno, el 17, ¡el mejor de todos! ¿Qué hicimos entonces? Por supuesto, fuimos al 17.
Entrada

La entrada consta de una serie de casos de prueba. Cada caso es una línea en la que aparecen, separados por espacios, los bares a los que fueron mis amigos. La relación de bares termina con un 0.

La lista no tiene por qué empezar siempre en el 1 y, desde luego, los bares pueden haber sido recorridos en cualquier orden. Lo que sí se asegura es que solo falta un bar y que este nunca es ni el primero ni el último.

Cada vez hay más gente en la calle Laurel, y cada vez ponen más bares. La última vez que los contaron había 500.000 bares.
Salida

Para cada caso de prueba se escribirá el bar que les faltó por visitar a mis amigos.
Entrada de ejemplo

11 13 19 14 18 10 12 15 20 16 0
20 21 22 24 26 25 0
6 5 4 2 0

Salida de ejemplo

17
23
3
*/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int cmpfunc (const void * a, const void * b) {
		return ( *(int*)a - *(int*)b );
}

int casoDePrueba() {
	int i, res, lista[500000], j;
	i = 0;
	if(scanf("%u ", &lista[i]) == EOF)
		return 0;
	else {
		while(lista[i] != 0) {
			i++;
			scanf("%u", &lista[i]);
		}
		

		qsort(lista, i, sizeof(int), cmpfunc);
		
		
		int listaOrdenada[i];
		for(j = 0; j < i; j++) {
			listaOrdenada[j]=lista[j];
		}
		
for(j = 0; j < (i-1); j++) {
				if((listaOrdenada[j]+1) != listaOrdenada[j+1]) {
						res = listaOrdenada[j]+1;
				}
		}
		
		printf("%d\n", res);
		
	}
}

int main(int argc, char * argv[]) {
	
	while(casoDePrueba()){}
		
	return 0;
}
