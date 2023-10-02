package aws.bootcamp.clase3.ejercicio3;

public class Fila<T> {
    Nodo<T> primero;
    Nodo<T> ultimo;
    Class<T> tipo;

    public Fila(Class<T> tipo) {
        this.primero = null;
        this.ultimo = null;
        this.tipo = tipo;
    }

    public void push(T valor) {
        if (primero == null) {
            primero = new Nodo<>(valor);
            ultimo = primero;
        } else {
            if (!valor.getClass().equals(tipo)) {
                throw new IllegalArgumentException("El tipo de valor no coincide con el tipo inicial.");
            }
            Nodo<T> nuevoNodo = new Nodo<>(valor);
            ultimo.next = nuevoNodo;
            ultimo = nuevoNodo;
        }
    }

    public T pop() {
        if (primero == null) {
            throw new RuntimeException("La fila está vacía");
        }
        T valor = primero.valor;
        primero = primero.next;
        if (primero == null) {
            ultimo = null;
        }
        return valor;
    }

    public boolean isEmpty() {
        return primero == null;
    }
}