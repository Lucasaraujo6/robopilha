public class Pilha<T> {
    public T item[];
    private int topo;

    // Operações
    @SuppressWarnings("unchecked")
    public Pilha(int maxTam) { // Cria uma Pilha vazia
        item = (T[]) new Object[maxTam];
        topo = 0;

    }

    public void empilha(T item) throws Exception {
        // System.out.println("empilhei");
        if (item == null)
            throw new NullPointerException();
        if (topo == this.item.length)
            throw new Exception("Erro: A pilha esta cheia");
        else {

            this.item[topo++] = item;
            // System.out.println("Topo " + topo);
        }
    }

    public T desempilha() throws Exception {
        if (vazia())
            throw new Exception("Erro: A pilha esta vazia");
        T safe = item[topo - 1];
        item[topo - 1] = null;
        topo--;
        return safe;
    }

    public T getTopo() {
        return item[topo - 1];
    }

    public boolean vazia() {
        return (topo == 0);
    }

    public int tamanho() {
        return topo;
    }

    public void print() {
        for (int i = 0; i < 70; i++) {
            System.out.print(item[i] + "-" + i + "\t");
        }
    }

}