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
    
    public boolean pertenece(int elemento){
        for (int i = 0; i < this.cardinal(); i++) {
            if (this.vectorElementos[i]==elemento){
                return true;
            }
        }
        return false;
    }
    
    public boolean añade(int elemento){
        if ((this.cardinal() == 10)||(this.pertenece(elemento))){
            return false;
        }
        this.vectorElementos[this.cardinal()]=elemento;
        return true;
    }
    
    public ConjuntoDeEnteros unión(ConjuntoDeEnteros conjunto){
        int[] vectorResultadoParcial = new int[10];
        System.arraycopy(this.vectorElementos, 0, vectorResultadoParcial, 0, this.cardinal());
        int k=0;
        for (int i = 0; i < 10-this.cardinal(); i++) {
            if (!this.pertenece(conjunto.vectorElementos[i])){
                vectorResultadoParcial[k+this.cardinal()]=conjunto.vectorElementos[i];
                k++;
            }
        }
        int[] vectorResultado = new int[this.cardinal()+k];
        System.arraycopy(vectorResultadoParcial, 0, vectorResultado, 0, this.cardinal()+k);
        return new ConjuntoDeEnteros(vectorResultado);
    }
    
    
    
}
