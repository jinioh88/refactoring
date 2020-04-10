package ch3;

import java.util.Arrays;

public class SortSample {
    private final int[] data;

    public SortSample(int[] data) {
        this.data = new int[data.length];
        System.arraycopy(data, 0, this.data, 0, data.length);
    }

    public void sort() {
        for(int x = 0; x < data.length -1; x++) {
            int m = x;
            for(int y = x+1; y < data.length; y++) {
                if(data[m] > data[y]) {
                    m = y;
                }
            }
            int v = data[m];  // data[m]은 최솟값이어야 함.
            data[m] = data[x];
            data[x] = v;
            // 여기선 정렬되 있어야 함
        }
    }

    @Override
    public String toString() {
        return "SortSample{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}
