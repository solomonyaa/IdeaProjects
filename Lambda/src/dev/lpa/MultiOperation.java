package dev.lpa;

// * This is a generic interface, because it includes a type parameter (T).
// * This is a functional interface, meaning it includes a single abstract method.

import java.util.List;

@FunctionalInterface
public interface MultiOperation<T>{

    T operate(List<T> list);
}
