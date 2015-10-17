package practica1;

public class ConjuntoDeEnteros {

    private int[] vectorElementos;

    public ConjuntoDeEnteros() {
        this.vectorElementos = new int[0];
    }

    public ConjuntoDeEnteros(int[] vectorElementos) {
        int [] result = new int[10];
        int k=0;
        for (int i = 0; (i < vectorElementos.length)&&(k<10); i++) {
            int j;
            for (j = i; j < vectorElementos.length; j++) {
                if ((vectorElementos[i]==vectorElementos[j])&&(i!=j)){
                    break;
                }
            }
            if (j==vectorElementos.length) {
                result[k]=vectorElementos[i];
                k++;
            }
        }
        this.vectorElementos= new int[k];
        System.arraycopy(result, 0, this.vectorElementos, 0, k);
    }
    
    @Override
    public boolean equals(Object conjunto){
        if(!(conjunto instanceof ConjuntoDeEnteros)){
            return false;
        }
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
    
    public boolean estáVacío(){
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
        int[] result= new int[this.vectorElementos.length +1];
        System.arraycopy(this.vectorElementos, 0, result, 0, this.vectorElementos.length);
        result[this.vectorElementos.length] = elemento;
        this.vectorElementos=result;
        return true;
    }
    
    public ConjuntoDeEnteros unión(ConjuntoDeEnteros conjunto){
        int[] vectorResultadoParcial = new int[10];
        System.arraycopy(this.vectorElementos, 0, vectorResultadoParcial, 0, this.cardinal());
        int k=this.cardinal();
        for (int i = 0; (i < conjunto.cardinal()) && (k < 10); i++) {
            if (!this.pertenece(conjunto.vectorElementos[i])){
                vectorResultadoParcial[k]=conjunto.vectorElementos[i];
                k++;
            }
        }
        int[] vectorResultado = new int[k];
        System.arraycopy(vectorResultadoParcial, 0, vectorResultado, 0, +k);
        return new ConjuntoDeEnteros(vectorResultado);
    }
    
    
    
}
