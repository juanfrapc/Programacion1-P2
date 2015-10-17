package practica1;

public class UsaConjunto {

    public static void main(String[] args) {
        // org.junit.runner.JUnitCore.main("ConjuntoTest");
        int[] vectorOrdenado = {2,4,6,8};
        ConjuntoDeEnteros conjunto = new ConjuntoDeEnteros(vectorOrdenado);
         int[] vectorOrdenado1 = {2,3,4,6,8};
        ConjuntoDeEnteros conjunto1 = new ConjuntoDeEnteros(vectorOrdenado1);
        conjunto.añade(3);
        System.out.println(conjunto.equals(conjunto1));
    }
}
