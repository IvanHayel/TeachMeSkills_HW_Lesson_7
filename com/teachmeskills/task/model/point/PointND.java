package com.teachmeskills.task.model.point;

import java.util.Arrays;

public class PointND {
    private final double[] COORDINATES;

    public PointND(double... coordinates){
        COORDINATES = coordinates;
    }

    public double[] getCoordinates() {
        return COORDINATES;
    }

    public int getDimension() {
        return COORDINATES.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PointND pointND = (PointND) o;

        return Arrays.equals(COORDINATES, pointND.COORDINATES);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(COORDINATES);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for(int counter = 0; counter < COORDINATES.length - 1; counter++){
            builder.append(COORDINATES[counter]);
            builder.append(',');
        }
        builder.append(COORDINATES[COORDINATES.length-1]);
        builder.append(']');
        return builder.toString();
    }
}