package com.teachmeskills.task.model.vector;

import com.teachmeskills.task.model.interfaces.TestableVector;
import com.teachmeskills.task.model.point.Point3D;

import java.util.Random;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Vector3D implements TestableVector<Vector3D> {
    Point3D point;

    public Vector3D(double coordinateX, double coordinateY, double coordinateZ) {
        point = new Point3D(coordinateX, coordinateY, coordinateZ);
    }

    public Vector3D(Point3D point) {
        this.point = point;
    }

    public double getAbsoluteValue() {
        return sqrt(pow(point.getX(), 2) + pow(point.getY(), 2) + pow(point.getZ(), 2));
    }

    public double multiply(Vector3D vector) {
        return point.getX() * vector.point.getX() +
                point.getY() * vector.point.getY() +
                point.getZ() * vector.point.getZ();
    }

    public Vector3D sumUp(Vector3D vector) {
        return new Vector3D(
                point.getX() + vector.point.getX(),
                point.getY() + vector.point.getY(),
                point.getZ() + vector.point.getZ()
        );
    }

    public Vector3D subtract(Vector3D vector) {
        return new Vector3D(
                point.getX() - vector.point.getX(),
                point.getY() - vector.point.getY(),
                point.getZ() - vector.point.getZ()
        );
    }

    public static Vector3D[] getRandomVectors(int quantity) {
        Vector3D[] randomVectors = new Vector3D[quantity];
        for (int counter = 0; counter < quantity; counter++) {
            randomVectors[counter] = getRandomVector();
        }
        return randomVectors;
    }

    public static Vector3D getRandomVector() {
        Random generator = new Random();
        return new Vector3D(
                generator.nextGaussian() * 100,
                generator.nextGaussian() * 100,
                generator.nextGaussian() * 100
        );
    }

    @Override
    public String toString() {
        return point.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector3D vector3D = (Vector3D) o;

        return point.equals(vector3D.point);
    }

    @Override
    public int hashCode() {
        return point.hashCode();
    }
}