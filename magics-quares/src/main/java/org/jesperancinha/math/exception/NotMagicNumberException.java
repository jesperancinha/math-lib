package org.jesperancinha.math.exception;

public class NotMagicNumberException extends RuntimeException {

    private NotMagicNumberException(final String message) {
        super(message);
    }

    public static NotMagicNumberException createByRow(int i) {
        return new NotMagicNumberException(String.format("Sum of row 0 does not match sum of row %d", i));
    }

    public static NotMagicNumberException createByColumn(int j) {
        return new NotMagicNumberException(String.format("Sum of row 0 does not match sum of column %d", j));
    }
}
