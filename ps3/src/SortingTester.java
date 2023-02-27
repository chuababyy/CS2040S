import java.util.Random;

public class SortingTester {
    public static boolean checkSort(ISort sorter, int size) {
        // create an array of KVP of size "size"
        KeyValuePair[] array = new KeyValuePair[size];

        // initialise the values of key and value in the KVP
        // key is a random number and
        // value is in increasing number to check the stability

        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int randomKey = random.nextInt();
            array[i] = new KeyValuePair(randomKey, i);
        }

        // sort the array (random array)
        long sortedArray = sorter.sort(array);
        System.out.println("Cost for random array: " + sortedArray);

        // test for correctness
        boolean truthValue = true;
        for (int i = 0; i < size - 1; i++) {
            KeyValuePair currentKVP = array[i];
            KeyValuePair nextKVP = array[i + 1];

            if (currentKVP.compareTo(nextKVP) == 1) { // the key > next key
                truthValue = false;
                break;
            }

        }

        // time taken for sorted array
        long sortedArray1 = sorter.sort(array);
        System.out.println("Cost for sorted array: " + sortedArray1);

        // time take for a reversed array
        KeyValuePair[] reverseArray = new KeyValuePair[size];
        for (int i = 0; i < size; i++) {
            reverseArray[i] = array[size -1 - i];
        }
        long sortedArray2 = sorter.sort(reverseArray);
        System.out.println("Cost for reverse array: " + sortedArray2);

        System.out.println("This sorter is correct: " + truthValue);
        return truthValue;

    }

    public static boolean isStable(ISort sorter, int size) {
        // create an array of KVP of size "size"
        KeyValuePair[] array = new KeyValuePair[size];

        // initialise the values of key and value in the KVP
        // key is an number that increases and then decreases
        // value is in increasing number to check the stability
        int number = 0;
        int pointer = 0;
        int mid = size/2;
        while (pointer <= mid - 1) {
            array[pointer] = new KeyValuePair(number, pointer);
            number++;
            pointer++;
        }
        while (pointer < size) {
            array[pointer] = new KeyValuePair(number, pointer);
            number--;
            pointer++;
        }

        // sort the array
        long sortedArray = sorter.sort(array);

        // test for stability
        boolean truthValue = true;
        for (int i = 0; i < size - 1; i++) {
            KeyValuePair currentKVP = array[i];
            KeyValuePair nextKVP = array[i + 1];
            if (currentKVP.compareTo(nextKVP) == 1) {
                truthValue = false;
                break;
            }
            else if (currentKVP.compareTo(nextKVP) == 0) { // the key = next key
                if (currentKVP.getValue() > nextKVP.getValue()) {
                    truthValue = false;
                    break;
                }
            }
        }
        System.out.println("This sorter is stable: " + truthValue);
        return truthValue;
    }


    public static String findDrEvil () {
        boolean truthValue = true;
        int sorterValue = 0;
        String sorterIdentity = "";
        ISort sortingObjectA = new SorterA();
        ISort sortingObjectB = new SorterB();
        ISort sortingObjectC = new SorterC();
        ISort sortingObjectD = new SorterD();
        ISort sortingObjectE = new SorterE();
        ISort sortingObjectF = new SorterF();

        while (truthValue == true) {
            if (sorterValue == 0) {
                truthValue = checkSort(sortingObjectA, 2);
                sorterIdentity = "A";
                sorterValue = 1;
            }
            else if (sorterValue == 1) {
                truthValue = checkSort(sortingObjectB, 2);
                sorterIdentity = "B";
                sorterValue = 2;
            } else if (sorterValue == 2) {
                truthValue = checkSort(sortingObjectC, 2);
                sorterIdentity = "C";
                sorterValue = 3;
            } else if (sorterValue == 3) {
                truthValue = checkSort(sortingObjectD, 2);
                sorterIdentity = "D";
                sorterValue = 4;
            } else if (sorterValue == 4) {
                truthValue = checkSort(sortingObjectE, 2);
                sorterIdentity = "E";
                sorterValue = 5;
            } else if (sorterValue == 5) {
                truthValue = checkSort(sortingObjectF, 2);
                sorterIdentity = "F";
                sorterValue = 0;
            }
        }

        return sorterIdentity;

    }

    public static void main(String[] args) {
        System.out.println("Dr Evil is: " + findDrEvil());

        System.out.println("Sorter A");
        ISort sortingObjectA = new SorterA();
        System.out.println("Array of size 100");
        SortingTester.checkSort(sortingObjectA, 100);
        System.out.println("Array of size 1000");
        SortingTester.checkSort(sortingObjectA, 1000);
        System.out.println("Array of size 10000");
        SortingTester.checkSort(sortingObjectA, 10000);
        SortingTester.isStable(sortingObjectA, 100);

        System.out.println("Sorter B");
        ISort sortingObjectB = new SorterB();
        System.out.println("Array of size 100");
        SortingTester.checkSort(sortingObjectB, 100);
        System.out.println("Array of size 1000");
        SortingTester.checkSort(sortingObjectB, 1000);
        System.out.println("Array of size 10000");
        SortingTester.checkSort(sortingObjectB, 10000);
        SortingTester.isStable(sortingObjectB, 100);

        System.out.println("Sorter C");
        ISort sortingObjectC = new SorterC();
        System.out.println("Array of size 100");
        SortingTester.checkSort(sortingObjectC, 100);
        System.out.println("Array of size 1000");
        SortingTester.checkSort(sortingObjectC, 1000);
        System.out.println("Array of size 10000");
        SortingTester.checkSort(sortingObjectC, 10000);
        SortingTester.isStable(sortingObjectC, 100);

        System.out.println("Sorter D");
        ISort sortingObjectD = new SorterD();
        System.out.println("Array of size 100");
        SortingTester.checkSort(sortingObjectD, 100);
        System.out.println("Array of size 1000");
        SortingTester.checkSort(sortingObjectD, 1000);
        System.out.println("Array of size 10000");
        SortingTester.checkSort(sortingObjectD, 10000);
        SortingTester.isStable(sortingObjectD, 100);

        System.out.println("Sorter E");
        ISort sortingObjectE = new SorterE();
        System.out.println("Array of size 100");
        SortingTester.checkSort(sortingObjectE, 100);
        System.out.println("Array of size 1000");
        SortingTester.checkSort(sortingObjectE, 1000);
        System.out.println("Array of size 10000");
        SortingTester.checkSort(sortingObjectE, 10000);
        SortingTester.isStable(sortingObjectE, 100);

        System.out.println("Sorter F");
        ISort sortingObjectF = new SorterF();
        System.out.println("Array of size 100");
        SortingTester.checkSort(sortingObjectF, 100);
        System.out.println("Array of size 1000");
        SortingTester.checkSort(sortingObjectF, 1000);
        System.out.println("Array of size 10000");
        SortingTester.checkSort(sortingObjectF, 10000);
        SortingTester.isStable(sortingObjectF, 100);
    }
}
