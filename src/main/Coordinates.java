package main;

import java.util.Objects;

public class Coordinates {
    public final File FILE; //Горизонталь, от A до H
    public final Integer RANK; //Вертикаль, от 1 до 8

    public Coordinates(File FILE, Integer RANK) {
        this.FILE = FILE;
        this.RANK = RANK;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return FILE == that.FILE && Objects.equals(RANK, that.RANK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(FILE, RANK);
    }
}