package ar.edu.untref.dyasc;

public class Program {

    public static void main(String[] args) {

    	String resultado = generarSerieFibo(Integer.parseInt(args[0]));
    	System.out.println(resultado);
    
    }
    
	// Maximo valor valido 91
    public static String generarSerieFibo(int cantidadDeElementos) {
    	long a = 0;
    	long b = 1;
    	long temp = 0;
    	StringBuilder resultado = new StringBuilder();
    	resultado.append("Fibo<" + Integer.toString(cantidadDeElementos) + ">");
        
    	for(int i = 0; i < cantidadDeElementos; i++) {
    		resultado.append(" " + Long.toString(a));
    		temp = a + b;
    		a = b;
    		b = temp;
    	}
    	
    	return resultado.toString();
    }

}
