package practica1;

public class ConjuntoDeEnteros {

    private int[] vectorElementos;

    public ConjuntoDeEnteros() {
        this.vectorElementos = new int[0];
    }

    public ConjuntoDeEnteros(int[] vectorElementos) {
        if (vectorElementos.length ==0){
            this.vectorElementos = new int[0];
        }else{
            int [] result = new int[10];
            int k=0;
            for (int i = 0; (i < vectorElementos.length)&&(k<10); i++) {
                int j;
                for (j = i+1; j < vectorElementos.length; j++) {
                    if ((vectorElementos[i]==vectorElementos[j])&&(i!=j)){
                        break;
                    }
                }
                if (j==vectorElementos.length) {
                    result[k]=vectorElementos.length;
                    k++;
                }
            }
            System.arraycopy(this.vectorElementos, 0, result, 0, k);
        }
    }
    
    @Override
    public boolean equals(Object conjunto){
        int j;
        if (this.cardinal()!= ((ConjuntoDeEnteros) conjunto).cardinal() ){
            return false;
        }        
        for (int i = 0; i< this.cardinal(); i++){
            for (j = 0; j<this.cardinal();j++){
                if (this.vectorElementos[i] == ((ConjuntoDeEnteros) conjunto).vectorElementos[j]){
                    break;
                }
            }
            if (j == this.cardinal()){
                return false;
            }
        }
        return true;
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
