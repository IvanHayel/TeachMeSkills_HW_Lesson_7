package com.teachmeskills.task.model.vector;


import com.teachmeskills.task.model.interfaces.TestableVector;

import java.awt.geom.Point2D;
import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector2D implements TestableVector<Vector2D> {
    Point2D point;

    public Vector2D(double coordinateX, double coordinateY) {
        point = new Point2D.Double(coordinateX, coordinateY);
    }

    public Vector2D(Point2D point) {
        this.point = point;
    }

    public double getAbsoluteValue() {
        return sqrt(pow(point.getX(), 2) + pow(point.getY(), 2));
    }

    public double multiply(Vector2D vector) {
        return point.getX() * vector.point.getX() + point.getY() * vector.point.getY();
    }

    public Vector2D sumUp(Vector2D vector) {
        return new Vector2D(
                point.getX() + vector.point.getX(),
                point.getY() + vector.point.getY()
        );
    }

    public Vector2D subtract(Vector2D vector) {
        return new Vector2D(
                point.getX() - vector.point.getX(),
                point.getY() - vector.point.getY()
        );
    }

    public static Vector2D[] getRandomVectors(int quantity) {
        Vector2D[] randomVectors = new Vector2D[quantity];
        for (int counter = 0; counter < quantity; counter++) {
            randomVectors[counter] = getRandomVector();
        }
        return randomVectors;
    }

    public static Vector2D getRandomVector() {
        Random generator = new Random();
        return new Vector2D(
                generator.nextGaussian() * 100,
                generator.nextGaussian() * 100
        );
    }

    @Override
    public String toString() {
        return '[' + Double.toString(point.getX()) + ',' + point.getY() + ']';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector2D vector2D = (Vector2D) o;

        return point.equals(vector2D.point);
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }
}