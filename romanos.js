/**
 * Autor: Camilo Figueroa ( Crivera )
 * Fecha: 28/08/2018
 * 
 */


var g_contenedor_salida = "";
var g_texto_original = "";

//Ojo, de primera mano el órden importa.
var g_arreglo = [   [ "500", "D" ],
                    [ "100", "C" ],                    
                    [ "50", "L" ],
                    [ "10", "X" ],
                    [ "5", "V" ],
                    [ "1", "I" ]                    
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
    var i = 0;
    var numero = g_texto_original.value * 1;
    var salida = g_texto_original.value;
    
    //console.log( "Salida " + salida );

    for( i = 0; i < g_arreglo.length; i ++ )
    {
        console.log( ( numero / ( g_arreglo[ i ][ 0 ] * 1 ) ) + " " + g_arreglo[ i ][ 1 ] );
        salida = salida.replace( g_arreglo[ i ][ 0 ], g_arreglo[ i ][ 1 ] );   
    }

    console.log( "----------------" );

    return salida;
}
