/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decaromanos;

/**
 *
 * @author SENA
 */
public class Convertidora {
    
    
    public String dec_a_roman( String cadena_numero )
    {   
        String[][] g_arreglo = {    { "1000", "M", "1" },
                                    { "500", "D", "1" }, 
                                    { "100", "C", "2" }, 
                                    { "50", "L", "1" },
                                    { "10", "X", "2" },
                                    { "5", "V", "1" },
                                    { "1", "I", "0" } 
                                };
        
        int i = 0, j = 0;  //j es para un segundo ciclo.
        int k = 0;
        Double numero = Double.parseDouble( cadena_numero );
        String salida = "";
        Double tmp_num = 0.0;
        int tmp_num_adelanto = 0;
        int contador = 0;
        //String tmp_cadena = "";
        
        for( j = 0; j < 10; j ++ )
        {
            
            for( i = 0; i < g_arreglo.length; i ++ )
            {
                tmp_num = ( numero / ( Double.parseDouble( g_arreglo[ i ][ 0 ] ) ) );
                //tmp_cadena = numero + "";                
                //salida = salida.replace(g_arreglo[ i ][ 0 ], g_arreglo[ i ][ 1 ]);
        
                //Parece ser que un buen candidato de número es el que está entre 0.8 y 1.
                //Ojo, los que empiezan con 8 han causado muchos problemas.
               //System.out.println( "->  " + ( numero + "" ).substring( 0, 1 ) );
                
                if( tmp_num >= 0.8 && tmp_num < 1 && !(( numero + "" ).substring( 0, 1 )).equals( "8" )  )
                {   //Aquí el número que importa es el anterior o anteriores a la cifra encontrada.
                    tmp_num_adelanto = Integer.parseInt( g_arreglo[ i ][ 2 ] );
                    salida += g_arreglo[ i + tmp_num_adelanto ][ 1 ] + g_arreglo[ i ][ 1 ];
                    numero = numero - (( Double.parseDouble( g_arreglo[ i ][ 0 ] )  ) - ( Double.parseDouble( g_arreglo[ i + tmp_num_adelanto ][ 0 ] )));
                    System.out.println( "1... " + numero );
                    break; 
                }
                
                if( tmp_num == 1 ) //Ojo, encontró el número exacto.
                {
                    salida += g_arreglo[ i ][ 1 ];
                    numero = numero - ( Double.parseDouble( g_arreglo[ i ][ 0 ] ) );
                    System.out.println( "2... " + numero );
                    break; //Hay que detener el ciclo porque encontró el número exacto.
                }
                
                if( tmp_num >= 1 && tmp_num < 2 )
                {                   
                    salida += g_arreglo[ i ][ 1 ];
                    numero = numero - ( Double.parseDouble( g_arreglo[ i ][ 0 ] ) );
                    System.out.println( "3... " + numero );
                    break; 
                }
                
                //Estos son los números de 2 o 3 cifras que no están en el vector. II III XX XXX CC CCC 
                if( tmp_num >= 2 && tmp_num < 4 )
                { 
                    for( k = 1; k <= tmp_num; k ++ ) 
                    {
                        salida += g_arreglo[ i ][ 1 ]; 
                        numero = numero - ( Double.parseDouble( g_arreglo[ i ][ 0 ] ) );
                    }
                    
                    System.out.println( "4... " + numero );
                    
                    break;
                }
            }
        }
        
        return salida;   
    }  
    
    
}
