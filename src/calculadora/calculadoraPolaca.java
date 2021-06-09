package calculadora;

public class calculadoraPolaca {
	//VARIABLES
	private String commando;
	private NodoPila arriba;

	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	public double establecerValorPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	public calculadoraPolaca(String commando) {
		arriba = null;
		this.commando = commando;
	}
	public double resultado( ) {
		double valor1, valor2;
		int j;
		for(int i = 0; i < commando.length( ); i++) {
			// si es un digito
			if(Character.isDigit(commando.charAt(i))) {
				double numero;
				// obtener un string valor1 partir del numero
				String temp = "";
				for(j = 0; (j < 100) && (Character.isDigit(
						commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
					temp = temp + String.valueOf(commando.
							charAt(i));
				}
				// convertir valor1 double y añadir valor1 la pila
				numero = Double.parseDouble(temp);
				pushPila(numero);
			} else if(commando.charAt(i) == '+') {
				valor2 = establecerValorPila( );
				valor1 = establecerValorPila( );
				pushPila(valor1 + valor2);
			} else if(commando.charAt(i) == '-') {
				valor2 = establecerValorPila( );
				valor1 = establecerValorPila( );
				pushPila(valor1 - valor2);
			} else if(commando.charAt(i) == '*') {
				valor2 = establecerValorPila( );
				valor1 = establecerValorPila( );
				pushPila(valor1 * valor2);
			} else if(commando.charAt(i) == '/') {
				valor2 = establecerValorPila( );
				valor1 = establecerValorPila( );
				pushPila(valor1 / valor2);
			}
			else if(commando.charAt(i) == '^') {
				valor2 = establecerValorPila( );
				valor1 = establecerValorPila( );
				pushPila(Math.pow(valor1, valor2));}
			else if(commando.charAt(i) == '%') {
				valor2 = establecerValorPila( );
				valor1 = establecerValorPila( );
				pushPila(valor1%valor2);
			} else if(commando.charAt(i) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
		double val = establecerValorPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
}