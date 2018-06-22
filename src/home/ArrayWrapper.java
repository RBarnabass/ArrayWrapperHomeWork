package home;


public class ArrayWrapper {

    private static int[] arr = new int[10];
    private static int size = 0;

    public static void add(int num) {
        if (size >= arr.length) {
            extendArray();
        }
        arr[size++] = num;
    }

    private static void extendArray() {
        int[] newArr = new int[size << 1];
        System.arraycopy(arr, 0, newArr, 0, arr.length);
        arr = newArr;
    }

    public static int[] getArr() {
        return arr.clone();
    }

    // returns element by index
    public static int get(int index) {
        if (index < arr.length && index >= 0) {
            return arr[index];
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // copy of sorted array
    public static void sort() {
        int bottom = 0;
        int topPoint = arr.length - 1;
        sortQ(arr, bottom, topPoint);
        System.out.println("Your array successfully sorted");
    }

    // NEW one
    private static void sortQ(int[] arr, int bottom, int topPoint) {
        int mid = (bottom + topPoint) >>> 1;
        int midValue = arr[mid];
        int tmpLeft = bottom;
        int tmpRight = topPoint;
        int tmpSwap;

        while (tmpLeft < tmpRight) {

            while (arr[tmpLeft] < midValue) {
                tmpLeft++;
            }

            while (arr[tmpRight] > midValue) {
                tmpRight--;
            }

            if (tmpLeft <= tmpRight) {
                ArrayWrapper.swap(tmpLeft, tmpRight);
                tmpLeft++;
                tmpRight--;
            }
        }

        if (tmpRight > bottom) {
            sortQ(arr, bottom, tmpRight);
        }
        if (tmpLeft < topPoint) {
            sortQ(arr, tmpLeft, topPoint);
        }
    }

    // remove by index
    public static void remove(int index) {
        if (index < arr.length) {
            int[] tmpArr = new int[arr.length - 1];
            System.arraycopy(arr, 0, tmpArr, 0, index);
            System.arraycopy(arr, index + 1, tmpArr, index, arr.length - index - 1);
            arr = tmpArr;
            System.out.println("And successfully removed");
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    // remove by value
    public static void removeByValue(int value) {
        int index = searchCorrect(value);
        remove(index);
        System.out.println("And successfully removed");
    }

    // NEW one
    public static void insert(int value, int index) {
        if (index == 0) {
            ArrayWrapper.prepend(0);
        } else if (index <= arr.length) {
            int[] tmpArr = new int[arr.length + 1];
            System.arraycopy(arr, 0, tmpArr, 0, index);
            System.arraycopy(arr, index, tmpArr, index + 1, arr.length - index - 1);
            arr = tmpArr;
            ArrayWrapper.add(index, value);
            System.out.println("Value successfully inserted");
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static int searchCorrect(int value) {
        int position = searchBinary(value);
        if (position >= 0) {
            System.out.println("Your element was define at position number: " + position);
            return position;
        } else {
            System.out.println("Your element wasn't define, but it must be at position number: " + (position * (-1) - 1));
            return position * (-1) - 1;
        }
    }

    // search by value
    private static int searchBinary(int value) {
        ArrayWrapper.sort();
        int low = 0;
        int hight = arr.length - 1;

        while (low <= hight) {
            int mid = (low + hight) >>> 1;
            int midValue = arr[mid];
            if (midValue == value) {
                return mid;
            } else if (midValue > value) {
                hight = mid - 1;
            } else if (midValue < value) {
                low = mid + 1;
            }
        }
        return -(low + 1);
    }

    // NEW one RETURN
    public static int searchIterality(int value) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // NEW one
    public static int searchContainsQuantity(int value) {
        int quantity = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                quantity++;
            }
        }
        return quantity;
    }

    // returns revers of array
    public static void revers() {
        int mid = arr.length / 2;
        for (int i = 0; i < mid; i++) {
            ArrayWrapper.swap(i, arr.length - 1 - i);
        }
    }

    // NEW one
    private static void swap(int num1, int num2) {
        int tmp = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] = tmp;
    }

    // returns sub array
    public static int[] subArray(int start, int end) {
        int[] arrSub = new int[end - start];
        System.arraycopy(arr, start, arrSub, 0, end - start);
        return arr = arrSub;
    }

    // returns sum of all elements
    public static int sum() {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        return total;
    }

    // add whole array
    public static void add(int[] newArr) {
        int[] arrTmp = new int[arr.length + newArr.length];
        System.arraycopy(arr, 0, arrTmp, 0, arr.length);
        System.arraycopy(newArr, 0, arrTmp, arr.length, newArr.length);
        arr = arrTmp;
    }

    // add on specific position
    // if index greater then size -> throw ArrayIndexOutOfBoundsException
    public static void add(int index, int value) {
        int[] tmp = getArr();
        if (index < tmp.length && index >= 0) {
            tmp[index] = value;
            arr = tmp;
        }
    }

    // prepend value
    public static void prepend(int num) {
        int[] tmp = new int[arr.length + 1];
        System.arraycopy(arr, 0, tmp, 1, arr.length);
        tmp[0] = num;
        arr = tmp;
    }

    // set new value instead old value
    // if index greater then size -> throw ArrayIndexOutOfBoundsException
    public static int set(int index, int value) {
        int[] tmp = getArr();
        get(index);
        arr = tmp;
        return arr[index] = value;
    }

    // search sub array
    public static int searchSubArray(int[] subArray) {
        if (subArray.length > 1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == subArray[0] && arr.length - i > subArray.length) {
                    if (subArray[subArray.length - 1] == arr[i + subArray.length - 1]) { // DON'T TOUCH! MAGIC! )))
                        int[] tmp = new int[subArray.length];
                        System.arraycopy(arr, i, tmp, 0, subArray.length);
                        boolean isEqual = ArrayWrapper.checkIt(subArray, tmp);
                        if (isEqual == true) {
                            return i;
                        }
                    }
                }
            }
        }
        return 0;
    }

    // New sub search
    public static int searchSubArrayPro(int[] subArray) {
        int quantityOfFirstElemet = ArrayWrapper.searchContainsQuantity(subArray[0]);
        int quantityOfLastElement = ArrayWrapper.searchContainsQuantity(subArray[subArray.length - 1]);
        if (quantityOfFirstElemet > 0 && quantityOfLastElement > 0) {
            for (int i = 0; i <= quantityOfFirstElemet; i++) {
                int firstElementIndex = ArrayWrapper.searchIterality(subArray[0]);
                int lastElementIndex = ArrayWrapper.searchIterality(subArray[subArray.length - 1]);
                if (lastElementIndex - firstElementIndex == subArray.length - 1) {
                    boolean isEqual = ArrayWrapper.checkIt(subArray, arr, firstElementIndex);
                    if (isEqual == true) {
                        return firstElementIndex;
                    } else {
                        ArrayWrapper.remove(firstElementIndex);
                        ArrayWrapper.remove(lastElementIndex - 1);
                    }
                }
            }
        }
        return 0;
    }

    // NEW one Overload
    private static boolean checkIt(int[] subArray, int[] tmp, int firstElement) {
        int count = 0;
        for (int i = 0; i < subArray.length; i++) {
            if (tmp[firstElement + i] == subArray[i]) {
                count++;
            }
        }
        if (count == subArray.length) {
            return true;
        } else {
            return false;
        }
    }

    // NEW one
    private static boolean checkIt(int[] subArray, int[] tmp) {
        int count = 0;
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] == subArray[i]) {
                count++;
            }
        }
        if (count == subArray.length) {
            return true;
        } else {
            return false;
        }
    }


    public static void removeSubArray(int[] subArray) {
        int check = ArrayWrapper.searchSubArray(subArray);
        if (check <= 0) {
            System.out.println("There is no any subArray inside !");
        } else {
            int[] tmp = new int[arr.length - subArray.length];
            System.arraycopy(arr, 0, tmp, 0, check);
            System.arraycopy(arr, check + subArray.length, tmp, check, tmp.length - subArray.length);
            arr = tmp;
        }
    }

}
