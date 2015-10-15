package practica1;

public class ConjuntoDeEnteros {

    private int[] vectorElementos;

    public ConjuntoDeEnteros() {
        this.vectorElementos = new int[0];
    }

    public ConjuntoDeEnteros(int[] vectorElementos) {
        if (vectorElementos.length < 11){
            this.vectorElementos = vectorElementos.clone();
        }else{
            int [] result = new int[10];
            System.arraycopy(vectorElementos, 0, result, 0, result.length);
        }
    }
    
    public int cardinal(){
        return this.vectorElementos.length;
    }
    
    public boolean estáVacio(){
        return (this.vectorElementos.length ==0);
    }
    
    public boolean añade(int elemento){
        if (this.cardinal() ==10){
            return false;
        }
        for (int i = 0; i < this.cardinal(); i++) {
            if (this.vectorElementos[i]==elemento){
                return false;
            }
        }
        this.vectorElementos[this.cardinal()]=elemento;
        return true;
    }
    
    
}
