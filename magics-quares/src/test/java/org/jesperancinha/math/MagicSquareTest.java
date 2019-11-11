package org.jesperancinha.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MagicSquareTest {

    @Test
    public void build() {
        final var square = new int[2][2];
        square[0][0] = 1;
        square[1][0] = 1;
        square[0][1] = 1;
        square[1][1] = 1;

        assertAll(() -> MagicSquare.builder()
                .square(square).build());
    }

    @Test
    public void buildNull() {
        assertThrows(NullPointerException.class, () -> MagicSquare.builder()
                .build());
    }

    @Test
    public void buildUnevenSquare() {
        final var square = new int[2][2];
        square[0][0] = 2;
        square[1][0] = 1;
        square[0][1] = 1;
        square[1][1] = 1;

        assertThrows(NotMagicNumberException.class, () -> MagicSquare.builder()
                .square(square).build());
    }

}