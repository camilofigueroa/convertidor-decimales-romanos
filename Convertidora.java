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
        
        String salida = cadena_numero;
        
        int i = 0;
        
        String[][] g_arreglo = { 
                                    { "500", "D" }, 
                                    { "100", "C" }, 
                                    { "50", "L" },
                                    { "10", "X" },
                                    { "5", "V" },
                                    { "1", "I" } 
                                }; 
        
        for( i = 0; i < g_arreglo.length; i ++ )
        {
            salida = salida.replace(g_arreglo[ i ][ 0 ], g_arreglo[ i ][ 1 ]);
        }
        
        return salida;   
    }  
    
    
}
