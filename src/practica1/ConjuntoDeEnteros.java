package practica1;

import java.util.ArrayList;

public class ConjuntoDeEnteros {

    private ArrayList<Integer> elementos;

    public ConjuntoDeEnteros() {
        this.elementos = new ArrayList<>();
    }

    public ConjuntoDeEnteros(int[] vector) {
        this();
        int k=0;
        for (int i = 0; (i < vector.length)&&(k<10); i++) {
            if (!elementos.contains(vector[i])) {
                elementos.add(vector[i]);
                k++;
            }
        }
    }
    
     public ConjuntoDeEnteros(ArrayList<Integer> elementos) {
        this.elementos = elementos;
    }
    
    @Override
    public boolean equals(Object conjunto){
        return this.elementos.equals(conjunto);
    } 
     
    public int cardinal(){
        return this.elementos.size();
    }
    
    public boolean estáVacio(){
        return (this.elementos.isEmpty());
    }
    
    public boolean pertenece(int elemento){
        return this.elementos.contains(elemento);
    }
    
    public boolean añade(int elemento){
        if ((this.cardinal() == 10)||(this.pertenece(elemento))){
            return false;
        }
        this.elementos.add(elemento);
        return true;
    }
    
    public ConjuntoDeEnteros unión(ConjuntoDeEnteros conjunto){
        ConjuntoDeEnteros conjuntoUnion = new ConjuntoDeEnteros(this.elementos);
        for (int i = 0; (i < conjunto.cardinal()) && (conjuntoUnion.cardinal()<10) ; i++) {
            if (!this.pertenece(conjunto.elementos.get(i))){
                conjuntoUnion.elementos.add(conjunto.elementos.get(i));
            }
        }
        return conjuntoUnion;
    } 
    
    
}
