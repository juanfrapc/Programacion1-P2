package practica1;

import org.junit.*;
import static org.junit.Assert.*;

public class ConjuntoTest{
 
 /**
  * Declaramos los vectores y conjunto utilizados ne todas las pruebas e
  * inicializamos los vectores, ya que no serán modificados en las pruebas.
  */
    
    private final int[] vectorVacio = {};
    
    private final int[] vectorOrdenado = {2,4,6,8};
    private final int[] vectorOrdenado1 = {4,5,6,7};
    private final int[] vector1 = {2};
    private final int[] vectorOrdenado9;
    private final int[] vectorDesordenado = {4,2,8,6};
    private final int[] vectorRepetido = {2,4,4,6,6,8,2};
    
    private final int[] vectorMax = {1,2,3,4,5,6,7,8,9,10};
    private final int[] vectorMayor = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    
    private ConjuntoDeEnteros conjuntoVectorVacio;
    private ConjuntoDeEnteros conjuntoVacio;
    
    private ConjuntoDeEnteros conjuntoOrdenado;
    private ConjuntoDeEnteros conjuntoOrdenado1;
    private ConjuntoDeEnteros conjunto1;
    private ConjuntoDeEnteros conjuntoOrdenado9;
    private ConjuntoDeEnteros conjuntoDesordenado;
    private ConjuntoDeEnteros conjuntoRepetido;
    
    private ConjuntoDeEnteros conjuntoMax;
    private ConjuntoDeEnteros conjuntoMayor;

    public ConjuntoTest() {
        this.vectorOrdenado9 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }
    
    /**
     * Se inicializan los conjuntos antes de cada prueba.
     */
    @Before
    public void inicializa(){
        conjuntoVectorVacio = new ConjuntoDeEnteros(vectorVacio);
        conjuntoVacio = new ConjuntoDeEnteros();
        
        conjuntoOrdenado = new ConjuntoDeEnteros(vectorOrdenado);
        conjuntoOrdenado1 = new ConjuntoDeEnteros(vectorOrdenado1);
        conjunto1 = new ConjuntoDeEnteros(vector1);
        conjuntoOrdenado9 = new ConjuntoDeEnteros(vectorOrdenado9);
        conjuntoDesordenado = new ConjuntoDeEnteros(vectorDesordenado);
        conjuntoRepetido = new ConjuntoDeEnteros(vectorRepetido);
       
        conjuntoMax = new ConjuntoDeEnteros(vectorMax);
        conjuntoMayor = new ConjuntoDeEnteros(vectorMayor);
    }
    
    // test de prueba de los constructores
    @Test
    public void pruebaConstructores(){
     
        assertEquals("Comprobamos el constructor del conjunto vacío"
            ,conjuntoVectorVacio, conjuntoVacio);
         
        assertEquals("Comprobamos el constructor, sin importancia de orden",
            conjuntoOrdenado,conjuntoDesordenado);
             
        assertEquals("Comprobamos el constructor, elementos repetidos",
            conjuntoOrdenado,conjuntoRepetido);
        
        assertEquals("Comprobamos el constructor, tamaño excedido",conjuntoMax,
            conjuntoMayor);
         
    }
    
    // test de prueba de la funcion cardinal
    @Test
    public void pruebaCardinal(){
     
        assertTrue("Comprobamos el cardinal de un conjunto vacio", 
            0== conjuntoVacio.cardinal());
        
        assertTrue("Comprobamos el cardinal de un conjunto unitario", 
            1== conjunto1.cardinal());
        
        assertTrue("Comprobamos el cardinal de un conjunto", 
            4== conjuntoOrdenado.cardinal());
        
        assertTrue("Comprobamos el cardinal de un vector repetido",
            4== conjuntoRepetido.cardinal());
        
        assertTrue("Comprobamos el cardinal de un conjunto (9)", 
            9== conjuntoOrdenado9.cardinal());
        
        assertTrue("Comprobamos el cardinal de un vector grande", 
            10== conjuntoMax.cardinal());
        
        assertTrue("Comprobamos el cardinal de un vector muy grande",
            10== conjuntoMayor.cardinal());
         
        assertFalse("Comprobamos el cardinal, conjuntos de distintos tamaños", 
            conjuntoMax.cardinal() == conjuntoOrdenado.cardinal());
    }
     
    //Test de prueba del metodo está vacio
    @Test
    public void pruebaEstaVacio(){
         
        assertTrue("Comprobación de conjunto vacío", conjuntoVacio.estáVacío());
         
        assertFalse("Comprobación de conjunto  unitario", conjunto1.estáVacío());
         
        assertFalse("Comprobación de conjunto (9 elementos)", 
            conjuntoOrdenado9.estáVacío());
         
        assertFalse("Comprobación de conjunto  no vacío", 
            conjuntoOrdenado.estáVacío() );
         
        assertFalse("Comprobación de conjunto  lleno", conjuntoMax.estáVacío());
         
    }
     
     // Test de prueba del método añade
    @Test
    public void pruebaAñade(){
         
        int[] oraculo={2,4};
        ConjuntoDeEnteros conjuntoOraculo = new ConjuntoDeEnteros(oraculo);
         
        assertTrue("Comprobamos la adicion conjunto unitario (TRUE)", 
            conjunto1.añade(4));
        assertEquals("Comprobamos la adicion conjunto unitario", 
            conjuntoOraculo, conjunto1);
         
        int[] oraculo1={2,4,6,8,10};
        ConjuntoDeEnteros conjuntoOraculo1 = new ConjuntoDeEnteros(oraculo1);
         
        assertTrue("Comprobamos la adicion de un elemento (TRUE)",
            conjuntoOrdenado.añade(10));
        assertEquals("Comprobamos la adicion de un elemento", conjuntoOraculo1, 
            conjuntoOrdenado);
         
        assertFalse("Comprobamos la no adicion de un elemento (por estar lleno)",
            conjuntoMax.añade(10));
         
        assertFalse("Comprobamos la no adicion de un elemento (por ya existir)",
            conjuntoOrdenado.añade(2));
         
        assertTrue("Comprobamos la adicion (9 elementos) (TRUE)",
            conjuntoOrdenado9.añade(10));
        assertEquals("Comprobamos la adicion (9 elementos)", conjuntoMax, 
            conjuntoOrdenado9);
         
        int[] oraculo2={2};
        ConjuntoDeEnteros conjuntoOraculo2 = new ConjuntoDeEnteros(oraculo2);
         
        assertTrue("Comprobamos la adicion de un elemento en el vacio(TRUE)", 
            conjuntoVacio.añade(2));
        assertEquals("Comprobamos la adicion de un elemento en el vacio",
            conjuntoOraculo2, conjuntoVacio);
    }
     
    //Test de prueba del metodo Pertenece
    @Test
    public void pruebaPertenece(){
         
        assertTrue("comprobamos la pertenencia conjunto unitario",
            conjunto1.pertenece(2));
         
        assertTrue("comprobamos la pertenencia", conjuntoOrdenado.pertenece(4));
     
        assertFalse("comprobamos la no pertenencia", 
            conjuntoOrdenado.pertenece(5));
     
        assertFalse("comprobamos la no pertenencia al vacío", 
            conjuntoVacio.pertenece(4));
         
        assertTrue("comprobamos la pertenencia (9 elementos)", 
            conjuntoOrdenado9.pertenece(4));
         
        assertTrue("comprobamos la pertenencia conjunto lleno", 
            conjuntoMax.pertenece(4));
    }
     
    //Test de prueba del metodo Unión
    @Test
    public void pruebaUnion(){
         
        int[] vectorUnion = {2,4,5,6,7,8};
        ConjuntoDeEnteros conjuntoUnion = new ConjuntoDeEnteros(vectorUnion);
         
        assertEquals("comprobamos la union conjunto unitario", conjuntoOrdenado,
            conjunto1.unión(conjuntoOrdenado));
         
        assertEquals("comprobamos la union", conjuntoUnion, 
            conjuntoOrdenado.unión(conjuntoOrdenado1));
         
        assertEquals("comprobamos la union (9 elementos)", conjuntoMax, 
            conjuntoOrdenado9.unión(conjuntoMax));
         
        assertEquals("comprobamos la union con el vacio", conjuntoOrdenado, 
            conjuntoVacio.unión(conjuntoOrdenado));
         
        assertEquals("comprobamos la union con uno mismo", conjuntoOrdenado, 
            conjuntoOrdenado.unión(conjuntoOrdenado));
     
        assertEquals("comprobamos la union conjunto max", conjuntoMax, 
            conjuntoMax.unión(conjuntoMax));
    }
     
 //    
 //    // test de prueba del metodo interseccion
 //    @Test
 //    public void pruebaInterseccion(){
 //        
 //        int[] vectorInterseccion = {4,6};
 //        ConjuntoDeEnteros conjuntoInterseccion = new 
 //            ConjuntoDeEnteros(vectorInterseccion);
 //        
 //        assertEquals("comprobamos la interseccion conjunto unitario", conjunto1,
 //            conjunto1.intersección(conjuntoOrdenado));
 //        
 //        assertEquals("comprobamos la interseccion", conjuntoInterseccion, 
 //            conjuntoOrdenado.intersección(conjuntoOrdenado1));
 //        
 //        assertEquals("comprobamos la intersección (9 elementos)", 
 //            conjuntoOrdenado9, conjuntoOrdenado9.intersección(conjuntoMax));
 //        
 //        assertEquals("comprobamos la interseccion con el vacio", conjuntoVacio, 
 //            conjuntoVacio.intersección(conjuntoOrdenado));
 //        
 //        assertEquals("comprobamos la interseccion con uno mismo", 
 //            conjuntoOrdenado, conjuntoOrdenado.intersección(conjuntoOrdenado));
 //    
 //        assertEquals("comprobamos la intersección conjunto max", conjuntoMax, 
 //            conjuntoMax.intersección(conjuntoMax));
 //    }
 //    
 //    //test de prueba del metodo diferencia
 //    @Test
 //    public void pruebaDiferencia(){
 //        
 //        int[] vectorDiferencia = {2,8};
 //        ConjuntoDeEnteros conjuntoDiferencia = new
 //            ConjuntoDeEnteros(vectorDiferencia);
 //        
 //        assertEquals("comprobamos la diferencia conjunto unitario", 
 //            conjuntoVacio, conjunto1.diferencia(conjuntoOrdenado));
 //        
 //        assertEquals("comprobamos la diferencia", conjuntoDiferencia, 
 //            conjuntoOrdenado.diferencia(conjuntoOrdenado1));
 //        
 //        assertEquals("comprobamos la diferencia (9 elementos)", conjuntoVacio, 
 //            conjuntoOrdenado9.diferencia(conjuntoOrdenado9));
 //        
 //        assertEquals("comprobamos la diferencia con el vacio", conjuntoVacio, 
 //            conjuntoVacio.diferencia(conjuntoOrdenado));
 //        
 //        assertEquals("comprobamos la diferencia conjunto Max", conjuntoVacio, 
 //            conjuntoMax.diferencia(conjuntoMax));
 //        
 //    }
 //    
 //    // test de prueba del metodo contenido
 //    @Test
 //    public void pruebaContenido(){
 //        
 //        int[] vectorContenido = {2,4};
 //        ConjuntoDeEnteros conjuntoContenido = new
 //            ConjuntoDeEnteros(vectorContenido);
 //        
 //        assertFalse("comprobamos el estar contenido conjunto unitario",
 //            conjunto1.contenido(conjuntoContenido));
 //        
 //        assertTrue("comprobamos el estar contenido", 
 //            conjuntoOrdenado.contenido(conjuntoContenido));
 //        
 //        assertFalse("comprobamos el no estar contenido", 
 //            conjuntoOrdenado1.contenido(conjuntoContenido));
 //        
 //        assertTrue("comprobamos el estar contenido (9 elementos)", 
 //            conjuntoOrdenado9.contenido(conjuntoContenido));
 //        
 //        assertTrue("comprobamos si el vacío esta contenido",
 //            conjuntoOrdenado.contenido(conjuntoVacio));
 //        
 //        assertFalse("comprobamos si el vacío no contiene", 
 //            conjuntoVacio.contenido(conjuntoOrdenado));
 //        
 //        assertTrue("comprobamos el estar contenido en uno mismo", 
 //            conjuntoOrdenado.contenido(conjuntoOrdenado));
 //        
 //        assertTrue("comprobamos el estar contenido conjunto max", 
 //            conjuntoMax.contenido(conjuntoContenido));
 //    }
 //    
 //    @Test
 //    public void pruebaElementos(){
 //        assertArrayEquals("comprobamos los elementos conjunto vacio", 
 //            conjuntoVacio.elementos(), vectorVacio);
 //        
 //        assertArrayEquals("comprobamos los elementos conjunto unitario",
 //            conjunto1.elementos(), vector1);
 //        
 //        assertTrue("comprobamos los elementos (9 elementos)",
 //            arrayEquals(conjuntoOrdenado9.elementos(), vectorOrdenado9));
 //            /*
 //            int[] v = conjuntoOrdenado9.elementos();
 //            
 //            for (int i =0; i< v.length; i++){
 //                System.out.println(v[i]);    
 //            }*/
 //            
 //        
 //        assertTrue("comprobamos los elementos", 
 //            arrayEquals(conjuntoOrdenado.elementos(),
 //                conjuntoDesordenado.elementos()));
 //        
 //   //       assertFalse("comprobamos los elementos (falso)",
 //   //           arrayEquals(conjuntoOrdenado.elementos(),
 //   //               conjuntoOrdenado1.elementos()));
 //        
 //        assertTrue("comprobamos los elementos para caso de vector completo", 
 //            arrayEquals(conjuntoMax.elementos(), conjuntoMayor.elementos()));
 //    
 //    }
 //    
 //    private boolean arrayEquals( int[] vector1, int[] vector2){
 //        int j;
 //        if (vector1.length != vector2.length){
 //            return false;
 //        }
 //        
 //        for (int i = 0; i< vector1.length; i++){
 //            for (j = 0; j<vector2.length;j++){
 //                if (vector1[i] == vector2[j]){
 //                    break;
 //                }
 //            }
 //            if (j == vector2.length){
 //                fail();
 //                return false;
 //            }
 //        }
 //        return true;
 //    }
 //    
}   