package src;
import java.util.*;
public class Array {
    static public void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        int a = arr[0];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
    }
}
