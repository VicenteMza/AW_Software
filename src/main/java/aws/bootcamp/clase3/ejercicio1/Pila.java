package aws.bootcamp.clase3.ejercicio1;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class Pila<T> {

    private List<T> elementos = new LinkedList<>();

    public void apilar(T elemento) {
        elementos.add(elemento);
    }

    public T desapilar() {
        if (estaVacia()) {
            throw new NoSuchElementException();
        }
        return elementos.remove(elementos.size() - 1);
    }

    public T cima() {
        if (estaVacia()) {
            throw new NoSuchElementException();
        }
        return elementos.get(elementos.size() - 1);
    }

    public boolean estaVacia() {
        return elementos.isEmpty();
    }

    public int tamaño() {
        return elementos.size();
    }

    public void vaciar() {
        elementos.clear();
    }

    @Override
    public String toString() {
        return elementos.toString();
    }
}