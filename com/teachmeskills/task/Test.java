package com.teachmeskills.task;

import com.teachmeskills.task.model.interfaces.TestableVector;
import com.teachmeskills.task.model.vector.Vector2D;
import com.teachmeskills.task.model.vector.Vector3D;
import com.teachmeskills.task.model.vector.VectorND;

import java.util.Arrays;

/**
 * Main task:
 * Create a class that describes a vector in a 2D coordinate system.
 * Create a class that describes a vector in a 3D coordinate system.
 * Each class must have:
 * constructor with parameters in the form of a list of coordinates (for example, x, y, z);
 * a method that calculates the length of a vector. The root can be calculated using Math.sqrt ();
 * method that calculates the dot product;
 * vector addition method;
 * vector difference method;
 * a static method that takes an integer N and returns an array of random vectors of size N.
 * Provide comparison of vectors using the equals method.
 * Print information about the vector using the toString method.
 *
 * Additional task:
 * The previous assignment to generalize and write one Vector class for an arbitrary dimension.
 * To do this, use an array in the vector class to store coordinates.
 */

public class Test {
    public static void main(String[] args) {
        // Vector2D test
        Vector2D firstVector2D = new Vector2D(1, 2);
        Vector2D secondVector2D = new Vector2D(4, 8);
        Vector2D thirdVector2D = new Vector2D(1, 2);
        Vector2D[] randomVectors2D = Vector2D.getRandomVectors(3);
        test(firstVector2D, secondVector2D, thirdVector2D, randomVectors2D);

        //VectorND test ~ equal to test for Vector2D ~
        VectorND firstVectorND2 = new VectorND(1, 2);
        VectorND secondVectorND2 = new VectorND(4, 8);
        VectorND thirdVectorND2 = new VectorND(1, 2);
        VectorND[] randomVectorsND2 = VectorND.getRandomVectors(1);
        test(firstVectorND2, secondVectorND2, thirdVectorND2, randomVectorsND2);

        // Vector3D test
        Vector3D firstVector3D = new Vector3D(2, 4, 4);
        Vector3D secondVector3D = new Vector3D(3, 3, 3);
        Vector3D thirdVector3D = new Vector3D(2, 4, 4);
        Vector3D[] randomVectors3D = Vector3D.getRandomVectors(3);
        test(firstVector3D, secondVector3D, thirdVector3D, randomVectors3D);

        // VectorND test  ~ equal to test for Vector3D ~
        VectorND firstVectorND3 = new VectorND(2, 4, 4);
        VectorND secondVectorND3 = new VectorND(3, 3, 3);
        VectorND thirdVectorND3 = new VectorND(2, 4, 4);
        VectorND[] randomVectorsND3 = VectorND.getRandomVectors(2);
        test(firstVectorND3, secondVectorND3, thirdVectorND3, randomVectorsND3);
    }

    private static void test(
            TestableVector firstVector,
            TestableVector secondVector,
            TestableVector thirdVector,
            TestableVector[] randomVectors
    ) {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~VECTOR TEST~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Vector class: " + firstVector.getClass().getName());
        System.out.println("First vector: " + firstVector);
        System.out.println("Second vector: " + secondVector);
        System.out.println("Third vector: " + thirdVector);
        System.out.println();
        System.out.println("First vector absolute value = " + firstVector.getAbsoluteValue());
        System.out.println();
        System.out.println("Scalar product of vectors 1 and 2 = " + firstVector.multiply(secondVector));
        System.out.println();
        System.out.println("Sum of vectors 1 and 2: " + firstVector.sumUp(secondVector));
        System.out.println();
        System.out.println("Vector difference 1 and 2: " + firstVector.subtract(secondVector));
        System.out.println();
        System.out.println("Is third equals first: " + thirdVector.equals(firstVector));
        System.out.println("Is third equals second: " + thirdVector.equals(secondVector));
        System.out.println();
        System.out.println("Random vectors: ");
        System.out.println(Arrays.toString(randomVectors));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
    }
}