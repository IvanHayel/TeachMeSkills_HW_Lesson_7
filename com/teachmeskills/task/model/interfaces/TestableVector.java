package com.teachmeskills.task.model.interfaces;

public interface TestableVector<T> {
    double getAbsoluteValue();

    double multiply(T vector);

    T sumUp(T vector);

    T subtract(T vector);
}
