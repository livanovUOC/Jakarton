package com.proyecto.Jakarton.sopa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Common 
{
	// CAMPOS
	private static Scanner entrada = new Scanner(System.in);
	
	/**
	 * Metodo de clase que se usa para pedir al usuario un int por consola
	 * Se espera el valor dentro de un rango de valores
	 * 
	 * @param mensaje cabecera de solicitud
	 * @param minimo Valor mínimo admitido
	 * @param maximo Valor máximo admitido
	 * 
	 * @return Nos devuelve un entero 
	 */
	public static int pedirInt(String mensaje, int minimo, int maximo)
	{
        Scanner entrada = new Scanner(System.in);
           
		int numero;
		do {
                        entrada.reset();
                    
                        System.out.print(mensaje+" :");
			try {
				
				numero = Integer.parseInt(entrada.nextLine());
			} catch (Exception e)
			{
				System.out.println("Valor incorrecto");
				numero=-1;
			}
		}while(numero==-1 || numero < minimo || numero > maximo);
		
		return numero;
	}
	
	/**
	 * Metodo de clase que se usa para pedir al usuario un int por consola
	 * No existe rango de valores en la respuesta
	 * 
	 * @param mensaje cabecera de solicitud

	 * 
	 * @return Nos devuelve un entero 
	 */
    public static int pedirInt(String mensaje)
	{
        Scanner entrada = new Scanner(System.in);
           
		int numero;
		do {
                        entrada.reset();
                    
                        System.out.print(mensaje+" :");
			try {
				
				numero = Integer.parseInt(entrada.nextLine());
			} catch (Exception e)
			{
				System.out.println("Valor incorrecto");
				numero=-1;
			}
		}while(numero < 0);
		
		return numero;
	}
        
    /**
	 * Metodo de clase que se usa para pedir al usuario un String por consola
	 * 
	 * @param mensaje cabecera de solicitud

	 * 
	 * @return Nos devuelve un String
	 */    
	public static String pedirString(String mensaje)
	{
		String cadena="";
		boolean error;
		
		do {
			error=false;
			try {
				System.out.println(mensaje);
				cadena = entrada.nextLine();
			
			} catch(Exception e)
			{
				System.out.println("Cadena incorrecta, introduce de nuevo");
				error= true;
			}
		} while(error);
		return cadena;
	}
	
	/**
	 * Metodo de clase que se usa para pedir al usuario un valor de tipo CHAR por consola
	 * 
	 * 
	 * @return Nos devuelve un CHAR introducido por el usuario
	 */     
	public static char pedirChar()
	{
		
		char resultado = entrada.next().charAt(0);
		
		return resultado;
	}
        
		/**
		 * Metodo de clase que se usa para pedir al usuario una fecha
		 * 
		 * 
		 * @return Nos devuelve una fecha determinada
		 */ 
        public static Date pedirFecha()
        {
        	Date testDate;
        	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        	@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
        	String f = "";
            boolean error=true;
            
            do {
            	System.out.println("Introduzca la fecha con formato dd/mm/yyyy");
                
                f = sc.nextLine();
                testDate = null;
                try{
                	testDate = df.parse(f);
                } catch (Exception e){ System.out.println("invalid format");}
                
                if(testDate != null) {
	                if (df.format(testDate).equals(f)){
	                	error=false;
	                }
                }
            }while(error);
            
            return testDate;
        }

}
