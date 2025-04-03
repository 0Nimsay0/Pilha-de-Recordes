package pilhajava;

public class Pilha<T>
{
    private T[] elementos;
    private int topo;

    public Pilha(int tamanho){
        elementos = (T[])new Object[tamanho];
        this.topo = -1;
    }
    
    public boolean isEmpty(){
        return this.topo == -1;
        
        /*if(this.topo == -1)
        return true;
        else
        returne false;
        */
    }
    
    public boolean isFull(){
        return this.topo == this.elementos.length - 1;
    }
    
    public boolean push(T dado){
        if(!this.isFull()){
            this.topo++;
            this.elementos[this.topo] = dado;
            return true;
        }
        return false;
    }
    
    public T pop(){
        return this.elementos[this.topo--];
    }
    
    public T peek(){
        return this.elementos[this.topo];
    }
    
    @Override
    public String toString(){
        StringBuilder retorno = new StringBuilder("Topo\n");
        for(int i = this.topo; i >= 0; i--){
            retorno.append(this.elementos[i] + "\n");
            return retorno.toString();
        }
        return null;
    }

    public void resize() {
        int novoTamanho = this.elementos.length *2;
        T[] novoArray = (T[]) new Object[novoTamanho];
        
        for (int i = 0; i < this.elementos.length; i++){
            novoArray[i] = this.elementos[i];
        }
        this.elementos = novoArray;
    }
    
}
