package aws.bootcamp.clase3.ejercicio3;
public class Pila<T> {
    Nodo<T> cima;
    Class<T> tipo;

    public Pila(Class<T> tipo) {
        this.cima = null;
        this.tipo = tipo;
    }

    public void push(T valor) {
        if (cima == null) {
            cima = new Nodo<>(valor);
        } else {
            if (!valor.getClass().equals(tipo)) {
                throw new IllegalArgumentException("El tipo de valor no coincide con el tipo inicial.");
            }
            Nodo<T> nuevoNodo = new Nodo<>(valor);
            nuevoNodo.next = cima;
            cima = nuevoNodo;
        }
    }

    public T pop() {
        if (cima == null) {
            throw new RuntimeException("La pila está vacía");
        }
        T valor = cima.valor;
        cima = cima.next;
        return valor;
    }

    public T entry() {
        if (cima == null) {
            throw new RuntimeException("La pila está vacía");
        }
        return cima.valor;
    }

    public boolean isEmpty() {
        return cima == null;
    }
}
