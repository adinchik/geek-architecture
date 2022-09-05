package iterator;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        int n = 5;
        Iterable<Integer> array = new Iterable<>() {

            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<>() {

                    int[] arr = new int[n];
                    int current = 0;

                    @Override
                    public boolean hasNext() {
                        return current < arr.length;
                    }

                    @Override
                    public Integer next() {
                        arr[current] = (int) (Math.random() * (200 + 1)) - 100;;
                        return arr[current++];
                    }
                };
            }
        };

        for (Integer i : array) {
            System.out.println(i);
        }

    }
}
