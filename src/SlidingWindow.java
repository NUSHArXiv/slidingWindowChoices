import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    static void printMax(int arr[], int N, int k) {
        Deque<Integer> Qi = new LinkedList<Integer>();
        int n = N - k + 1;

        for(int i = 0; i < N; i++) {
            if(i >= n) {
                while (!Qi.isEmpty() && Qi.peek() <= i - n) Qi.removeFirst();
            }
            while (!Qi.isEmpty() && arr[i] >= arr[Qi.peekLast()]) Qi.removeLast();
            Qi.addLast(i);
            if(i >= n-1) {
                System.out.println(arr[Qi.peek()]);
            }
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 12, 1, 78, 90, 57, 89, 56 };
        int k = 5;
        printMax(arr, arr.length, k);
    }
}