package org.jesperancinha.math;


import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.util.Arrays;

@Data
@Builder
public class MagicSquare {

    @NonNull
    private final int[][] square;

    public MagicSquare(int [][] square){
        this.square = square;
        validate(square);
    }

    private void validate(int[][] square) throws NotMagicNumberException {
        int sumRowOne = sum(getRowByIndex(0));
        for(int i = 1; i < square.length; i++){
            if(sum(getRowByIndex(i)) != sumRowOne){
                throw NotMagicNumberException.createByRow(i);
            }
        }
        for (int j = 0; j < square.length; j++) {
            if(sum(getColumnByIndex(j)) != sumRowOne){
                throw NotMagicNumberException.createByColumn(j);
            }
        }
    }

    private int sum(int[] arrayInt) {
        return Arrays.stream(arrayInt).sum();
    }

    public int[] getRowByIndex(int index) {
        return square[index];
    }

    public int[] getColumnByIndex(int index) {

        int[] columns = new int[square.length];
        for (int i = 0; i < square.length; i++) {
            columns[i] = square[i][index];
        }
        return columns;
    }
}
