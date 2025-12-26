public class GenericArray<T> {

    private final T[] array;

    public GenericArray(int size) {
        // Creating a generic array using reflection
        array = (T[]) new Object[size];
    }

    public void setElement(int index, T value) {
        array[index] = value;
    }

    public T getElement(int index) {
        return array[index];
    }

    public void print() {
        for (T element : array) {
            System.out.print(element + ", ");
        }
    }

}
