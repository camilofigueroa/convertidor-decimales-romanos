/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package decaromanos;

import java.util.Scanner; //Para leer por teclado hay que importar esto

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
        
        Scanner leyendo = new Scanner( System.in );
        
        System.out.println( "Digite el número a convertir: " );
        System.out.println( "Debe escribir el número abajo en la consola Output debajo de etse mensaje... " );
        String numero_para_convertir = leyendo.next();
        
        //Se ha creado la clase en otro archivo, ya es momento de organizar esto.
        Convertidora obj_convert = new Convertidora();
        System.out.println( "El número convertido es " + obj_convert.dec_a_roman( numero_para_convertir ) ); 
        
    }
    
}
