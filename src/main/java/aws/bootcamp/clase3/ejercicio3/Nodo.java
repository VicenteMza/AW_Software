package aws.bootcamp.clase3.ejercicio3;

class Nodo<T> {
    T valor;
    Nodo<T> next;

    public Nodo(T valor) {
        this.valor = valor;
        this.next = null;
    }
}