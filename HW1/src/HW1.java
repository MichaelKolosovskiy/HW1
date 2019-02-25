
public class HW1{ 

    public static void main(String[] args) {

        System.out.println(game(0, 0, 1, 1));
        diamond(3);
        System.out.println(square(3));
        System.out.println(cube(3));
        extent(2, 2);
        System.out.println(factorial(4));
        System.out.println(fibonacci(4));

        int ArrSise = 100;
        int[] list = new int[ArrSise];
        for (int i = 0; i < ArrSise; i++) {
            int n = (int) (Math.random() * ArrSise);
            list[i] = n;
        }
        long tB_Bbl = System.currentTimeMillis();
        bubbleSort(list);
        long tA_Bbl = System.currentTimeMillis();
        System.out.println("Bubble time = " + (tA_Bbl - tB_Bbl) + " ms;");

        long tB_Slctn = System.currentTimeMillis();
        selectionSort(list);
        long tA_Slctn = System.currentTimeMillis();
        System.out.println("Selection time = " + (tA_Slctn - tB_Slctn) + " ms;");

        long tB_Insrtn = System.currentTimeMillis();
        insertionSort(list);
        long tA_Insrtn = System.currentTimeMillis();
        System.out.println("Insertion time = " + (tA_Insrtn - tB_Insrtn) + " ms;");

        long tB_Shell = System.currentTimeMillis();
        shellSort(list, ArrSise);
        long tA_Shell = System.currentTimeMillis();
        System.out.println("Shell time = " + (tA_Shell - tB_Shell) + " ms;");

    }

    // 1.1

    public static int game(int result_1, int result_2, int bet_1, int bet_2) {
        return ((result_1 == bet_1) && (result_2 == bet_2)) ? 2 : ((result_1 != bet_1) && (result_2 != bet_2) ? 0 : 1);
    }

    // 1.2

    public static void diamond(int number) {

        int space = number - 1;

        for (int line = 0; line < number; line++) {
            for (int y = 0; y < space; y++) {
                System.out.print(" ");
            }
            for (int star = 0; star <= line; star++) {
                System.out.print("* ");
            }
            System.out.println();
            space--;
        }

        space = 1;
        number -= 1;

        for (int line = number; line > 0; line--) {
            for (int y = 0; y < space; y++) {
                System.out.print(" ");
            }
            for (int star = 0; star < line; star++) {
                System.out.print("* ");
            }
            space++;
            System.out.println(" ");
        }
    }

    // 1.3

    public static double square(double i) {
        return i * i;
    }

    public static double cube(double x) {
        return x * x * x;
    }

    public static void extent(double number, int extent) {
        if (extent < 0) {
            System.out.println("Степінь має бути додатнім.");
        } else {
            int sum = 1;
            for (int i = 0; i < extent; i++) {
                sum *= number;
            }
            System.out.println(sum);
        }

    }

    // 1.4.1

    public static int factorial(int number) {
        return (number < 0) ? 0 : (number == 0 || number == 1) ? 1 : factorial(number - 1) * number;
    }

    // 1.4.2

    public static int fibonacci(int number) {
        if (number == 0) {
            return 0;
        }
        if (number == 1) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    // 1.5

    public static void insertionSort(int[] arr) {
        int buf;
        for (int i = 1; i < arr.length; i++) {
            buf = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] < buf) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = buf;
        }
    }

    public static void shellSort(int[] arr, int length) {
        int x = length / 2;
        while (x > 0) {
            int j = 0;
            for (int i = x; i < length; i++) {
                int buf = arr[i];
                for (j = i; j >= x && arr[j - x] > buf; j -= x) {
                    arr[j] = arr[j - x];
                }
                arr[j] = buf;
            }
            x = x / 2;
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int element = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[element]) {
                    element = j;
                }
            }
            int buf = arr[i];
            arr[i] = arr[element];
            arr[element] = buf;
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i < arr.length - j; i++) {
                if (arr[i] < arr[i - 1]) {
                    int tmp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
    }
}
