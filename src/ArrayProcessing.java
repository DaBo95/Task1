import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dasha on 28.02.2018.
 */
public class ArrayProcessing {
    public static void main(String[] args) {
        ArrayProcessing arr = new ArrayProcessing();
        arr.startProcessing();
    }

    public void startProcessing() {
        int[] a = genArray(20);

        Scanner in = new Scanner(System.in);
        int task = in.nextInt();
        switch (task) {
            case 1: {
                int maxMinus = findPosOfMaxMinus(a);
                int minPlus = findPosOfMinPlus(a);
                printArr(a);
                int tmp = a[maxMinus];
                a[maxMinus] = a[minPlus];
                a[minPlus] = tmp;
                //System.out.println(maxMinus + " " + minPlus);
                printArr(a);
            }
            break;
            case 2: {
                int sum = 0;
                int n = a.length;

                for (int i = 0; i < n; i += 2) {
                    sum += a[i];
                }
                printArr(a);
                System.out.println(sum);
            }
            break;
            case 3: {
                int[] newa = new int[a.length];
                for (int i = 0; i < a.length; i++) {
                    if (a[i] < 0)
                        newa[i] = 0;
                    else newa[i] = a[i];

                }
                printArr(a);
                printArr(newa);
            }
            break;
            case 4: {
                printArr(a);
                int[] newa = new int[a.length];
                for (int i = 0; i < a.length - 1; i++) {

                    if (a[i] > 0 && a[i + 1] < 0)
                        newa[i] = a[i] * 3;
                    else newa[i] = a[i];

                }
                newa[a.length - 1] = a[a.length - 1];
                printArr(newa);

            }
            break;
            case 5: {
                int min = a[findPosOfMaxMinus(a)];
                printArr(a);
                float avg = avgOfArr(a);
                //System.out.println(avg + " " + min);
                System.out.println(avg - min);

            }
            break;
            case 6: {
                int n = a.length;
                printArr(a);
                for (int i = 1; i + 2 < n; i += 2) {
                    for (int j = 0; j < n; j++) {
                        if (a[i] == a[j] && i != j) {
                            System.out.println(a[i]);
                            break;
                        }
                    }
                }
            }
            break;
            default: {
                System.out.println("Enter the number of task");
            }
        }
    }

    public int[] genArray(int n) {
        Random rnd = new Random(System.currentTimeMillis());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = rnd.nextInt(21) - 10;
            ;
        }
        return arr;
    }

    private int findPosOfMaxMinus(int[] a) {
        int idx = -1;
        int max = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                if (idx < 0) {
                    max = a[i];
                    idx = i;
                } else {
                    if (a[i] > max) {
                        max = a[i];
                        idx = i;
                    }
                }
            }
        }
        return idx;
    }

    private int findPosOfMinPlus(int[] a) {
        int idx = -1;
        int min = -1;
        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                if (idx < 0) {
                    min = a[i];
                    idx = i;
                } else {
                    if (a[i] < min) {
                        min = a[i];
                        idx = i;
                    }
                }
            }
        }
        return idx;
    }

    public void printArr(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    private float avgOfArr(int[] a) {
        float avg = 0;
        for (int i = 0; i < a.length; i++) {
            avg += a[i];
        }
        return avg / a.length;
    }
}
