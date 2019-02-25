public class Homework1{ 

    public static void main(String[] args) {

        System.out.println(game(0, 0, 1, 1));
        diamond(3);
        System.out.println(square(3));
        System.out.println(cube(3));
        System.out.println(extent(2, 3));
        System.out.println(factorial(4));
        System.out.println(fibonacci(7));

        int[] list = new int[10000];
        for (int i = 0; i < list.length; i++) {
            int n = (int) (Math.random() * list.length);
            list[i] = n;
        }
        
        long timeBefore = System.currentTimeMillis();
        bubbleSort(list);
        long timeAfter = System.currentTimeMillis();
        long time = timeAfter - timeBefore;
        System.out.println("Bubble time = " + (time) + " ms;");

        timeBefore = System.currentTimeMillis();
        selectionSort(list);
        timeAfter = System.currentTimeMillis();
        time = timeAfter - timeBefore;
        System.out.println("Selection time = " + (time) + " ms;");

        timeBefore = System.currentTimeMillis();
        insertionSort(list);
        timeAfter = System.currentTimeMillis();
        time = timeAfter - timeBefore;
        System.out.println("Insertion time = " + (time) + " ms;");

        timeBefore = System.currentTimeMillis();
        shellSort(list);
        timeAfter = System.currentTimeMillis();
        time = timeAfter - timeBefore;
        System.out.println("Shell time = " + (time) + " ms;");
        
    }

    // 1.1

    public static int game(int resOne, int resTwo, int betOne, int betTwo) {
        return ((resOne == betOne) && (resTwo == betTwo)) ? 2 : ((resOne != betOne) && (resTwo != betTwo) ? 0 : 1);
    }

    // 1.2

    public static void diamond(int number) {

        int space = number - 1;
        final char Star = '*';
        final char Space = ' ';

        for (int line = 0; line < number; line++) {
            for (int i = 0; i < space; i++) {
                System.out.print(Space);
            }
            for (int star = 0; star <= line; star++) {
                System.out.print(Star);
                System.out.print(Space);
            }
            System.out.println();
            space--;
        }

        space = 1;
        number -= 1;

        for (int line = number; line > 0; line--) {
            for (int i = 0; i < space; i++) {
                System.out.print(Space);
            }
            for (int star = 0; star < line; star++) {
            	 System.out.print(Star);
            	 System.out.print(Space);
            }
            space++;
            System.out.println(Space);
        }
    }

    // 1.3

    public static double square(double number) {
        return number * number;
    }

    public static double cube(double number) {
        return number * number * number;
    }

    public static double extent(double number, int extent) {
    	
    	double product = 1;
    	
        if (extent == 0) {
         return product;
        }else if(extent < 0) {
    		for (int j = 0; j < extent * (-1); j++) {
    			product *= number;
            }
    		product = 1/product;
        } else {
            for (int i = 0; i < extent; i++) {
            	product *= number;
            }
        }
		return product;
    }

    // 1.4.1

    public static int factorial(int number) {
    	return (number == 0 || number == 1) ? 1 : factorial(number - 1) * number; 
    }

    // 1.4.2

    public static int fibonacci(int number) {
    	return (number == 1||number==0) ? number : fibonacci(number - 1) + fibonacci(number - 2);
    }
    
    // 1.5
    
    private static void swap(int i, int j){
    	int buf = j;
    	j = i;
    	i = buf;
    }

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

    public static void shellSort(int[] arr) {
        int x = arr.length / 2;
        while (x > 0) {
            int j = 0;
            for (int i = x; i < arr.length; i++) {
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
            swap(element, i);
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int j = 0; j < arr.length; j++) {
            for (int i = 1; i < arr.length - j; i++) {
                if (arr[i] < arr[i - 1]) {
                	swap(i, i - 1);
                }
            }
        }
    }
}
