package com.teachmeskills.task.model.vector;

import com.teachmeskills.task.model.interfaces.TestableVector;
import com.teachmeskills.task.model.point.PointND;

import java.util.Random;

import static java.lang.Math.sqrt;

public class VectorND implements TestableVector<VectorND> {
    private PointND point;

    public VectorND(double... coordinates) {
        point = new PointND(coordinates);
    }

    public VectorND(PointND point) {
        this.point = point;
    }

    @Override
    public double getAbsoluteValue() {
        double[] coordinates = point.getCoordinates();
        double sumOfSquares = 0;
        for (double coordinate : coordinates) {
            sumOfSquares += coordinate * coordinate;
        }
        return sqrt(sumOfSquares);
    }

    public double multiply(VectorND vector) {
        double product = 0;
        double[] firstCoordinates = point.getCoordinates();
        double[] secondCoordinates = vector.point.getCoordinates();
        for (int counter = 0; counter < point.getDimension(); counter++) {
            product += firstCoordinates[counter] * secondCoordinates[counter];
        }
        return product;
    }

    public VectorND sumUp(VectorND vector) {
        double[] firstCoordinates = point.getCoordinates();
        double[] secondCoordinates = vector.point.getCoordinates();
        double[] newCoordinates = new double[point.getDimension()];
        for (int counter = 0; counter < point.getDimension(); counter++) {
            newCoordinates[counter] = firstCoordinates[counter] + secondCoordinates[counter];
        }
        return new VectorND(newCoordinates);
    }

    public VectorND subtract(VectorND vector) {
        double[] firstCoordinates = point.getCoordinates();
        double[] secondCoordinates = vector.point.getCoordinates();
        double[] newCoordinates = new double[point.getDimension()];
        for (int counter = 0; counter < point.getDimension(); counter++) {
            newCoordinates[counter] = firstCoordinates[counter] - secondCoordinates[counter];
        }
        return new VectorND(newCoordinates);
    }

    public static VectorND[] getRandomVectors(int quantity) {
        VectorND[] randomVectors = new VectorND[quantity];
        int dimension = new Random().nextInt(10) + 1;
        for (int counter = 0; counter < quantity; counter++) {
            randomVectors[counter] = getRandomVector(dimension);
        }
        return randomVectors;
    }

    public static VectorND getRandomVector(int dimension) {
        Random generator = new Random();
        double[] randomCoordinates = new double[dimension];
        for (int counter = 0; counter < randomCoordinates.length; counter++) {
            randomCoordinates[counter] = generator.nextGaussian() * 100;
        }
        return new VectorND(randomCoordinates);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VectorND vectorND = (VectorND) o;

        return point.equals(vectorND.point);
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }

    @Override
    public String toString() {
        return point.toString();
    }
}