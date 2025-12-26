package dev.lpa;

// * This is a generic interface, because it includes a type parameter (T).
// * This is a functional interface, meaning it includes a single abstract method.

@FunctionalInterface
public interface Operation<T>{

    T operate(T value1, T value2);
}
