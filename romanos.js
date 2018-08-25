/**
 * Autor: Camilo Figueroa ( Crivera )
 * Fecha: 28/08/2018
 * 
 */

var g_contenedor_salida = "";
var g_texto_original = "";

//Ojo, de primera mano el órden importa.
//La tercera columna me indica cuantas casillas debo ir adelante en el orden del vector
//para convertir un numero que en romano usará cifras anteriores.
var g_arreglo = [   [ "1000", "M", 1 ],
                    [ "500",  "D", 1 ],
                    [ "100",  "C", 2 ],                    
                    [ "50",   "L", 1 ],
                    [ "10",   "X", 2 ],
                    [ "5",    "V", 1 ],
                    [ "1",    "I", 0 ]                    
                ];

/**
 * Esta función se deja lo más corta posible, pues es solo el cargue.
 */
window.onload = function()
{
    g_contenedor_salida = document.getElementById( "salida" );
    g_texto_original = document.getElementById( "texto_entrada" );
}

/**
 * En esta función solo se van a encontrar funciones.
 */
function al_dar_clic()
{
    console.log( "El número a convertir es: " + g_texto_original.value )
    salida.innerHTML = "Su n&uacute;mero en romano es: " + operar();
}

/**
 * Esta función se encarga de realizar las operaciones.
 */
function operar()
{
    var i = 0, j = 0;  //j es para un segundo ciclo.
    var k = 0;
    var numero = g_texto_original.value * 1;
    var salida = "";
    var tmp_num = 0;
    var tmp_num_adelanto = 0;

    //console.log( "Salida " + salida );

    //Este ciclo es tentativo, que haga las cosas algunas veces. Cuando se ataquen todas las cifras...
    //...del número y quede en cero, este ciclo será un while.
    for( j = 0; j < 10; j ++ ) 
    {
        console.log( "Ini ciclo ---- " + numero + " ------ " );

        for( i = 0; i < g_arreglo.length; i ++ )
        {
            tmp_num = ( numero / ( g_arreglo[ i ][ 0 ] * 1 ) );
            console.log( tmp_num + " " + g_arreglo[ i ][ 1 ] ); //Análisis.
            
            //Parece ser que un buen candidato de número es el que está entre 0.8 y 1.
            if( tmp_num >= 0.8 && tmp_num < 1 && ( numero == 4 || numero % 4 != 0 ) )
            {   //Aquí el número que importa es el anterior o anteriores a la cifra encontrada.
                tmp_num_adelanto = g_arreglo[ i ][ 2 ];
                salida += g_arreglo[ i + tmp_num_adelanto ][ 1 ] + g_arreglo[ i ][ 1 ];
                numero = numero - (( g_arreglo[ i ][ 0 ] * 1 ) - ( g_arreglo[ i + tmp_num_adelanto ][ 0 ] * 1 ));
                console.log("   -> " + numero );
                break; 
            }

            if( tmp_num == 1 ) //Ojo, encontró el número exacto.
            {
                salida += g_arreglo[ i ][ 1 ];
                numero = numero - ( g_arreglo[ i ][ 0 ] * 1 );
                console.log("   -> " + numero );
                break; //Hay que detener el ciclo porque encontró el número exacto.
            }

            if( tmp_num >= 1 && tmp_num < 2 )
            {                   
                salida += g_arreglo[ i ][ 1 ];
                numero = numero - ( g_arreglo[ i ][ 0 ] * 1 );
                console.log("   -> " + numero );
                break; 
            }

            //Estos son los números de 2 o 3 cifras que no están en el vector. II III XX XXX CC CCC 
            if( tmp_num >= 2 && tmp_num <= 3.4 )
            { 
                for( k = 1; k <= tmp_num; k ++ ) 
                {
                    salida += g_arreglo[ i ][ 1 ]; 
                    numero = numero - ( g_arreglo[ i ][ 0 ] * 1 );
                }
                
                break;
            }

            //salida = salida.replace( g_arreglo[ i ][ 0 ], g_arreglo[ i ][ 1 ] );   
        }
    }

    console.log( "----------------" );

    return salida;
}
