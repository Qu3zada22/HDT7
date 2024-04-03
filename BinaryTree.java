import java.util.*;

// Clase para representar un árbol binario
class BinaryTree<E extends Comparable<E>> {
    private E element;
    private BinaryTree<E> left;
    private BinaryTree<E> right;

    // Constructor sin argumentos
    public BinaryTree() {
        this.element = null;
        this.left = null;
        this.right = null;
    }

    public BinaryTree(E element) {
        this.element = element;
        this.left = null;
        this.right = null;
    }

    // Insertar un elemento en el árbol
    public void insert(E element) {
        if (element == null) {
            return; // No se permite insertar elementos nulos
        }
        if (element.compareTo(this.element) < 0) {
            if (left == null) {
                left = new BinaryTree<>(element);
            } else {
                left.insert(element);
            }
        } else if (element.compareTo(this.element) > 0) {
            if (right == null) {
                right = new BinaryTree<>(element);
            } else {
                right.insert(element);
            }
        }
    }

    // Buscar un elemento en el árbol
    public boolean search(E element) {
        if (element == null) {
            return false; // No se permite buscar elementos nulos
        }
        if (element.compareTo(this.element) == 0) {
            return true; // Se encontró el elemento en el nodo actual
        } else if (element.compareTo(this.element) < 0) {
            if (left == null) {
                return false; // No se encontró el elemento y no hay hijos izquierdos
            }
            return left.search(element); // Buscar en el subárbol izquierdo
        } else {
            if (right == null) {
                return false; // No se encontró el elemento y no hay hijos derechos
            }
            return right.search(element); // Buscar en el subárbol derecho
        }
    }

    // Recorrido In-Order
    public void inOrderTraversal() {
        if (left != null)
            left.inOrderTraversal();
        System.out.print(element + " ");
        if (right != null)
            right.inOrderTraversal();
    }
}
