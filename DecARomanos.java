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
public class DecARomanos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int i = 0;
        String salida = "10";
        
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
            
        System.out.println( "El número convertido es " + salida );
        
        
    }
    
}
