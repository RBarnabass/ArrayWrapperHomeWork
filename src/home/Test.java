package home;


import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        for (int i = 0; i < 11; i++) {
            ArrayWrapper.add(i);
        }
        ArrayWrapper.set(0,3);
        ArrayWrapper.set(2,5);

      /*  for (int i = 0; i < 20; i++) {
            ArrayWrapper.add((int)(Math.random() * 100));
        }*/

       /* int[] arrTmp = new int[21];
        for (int i = 0; i < 21; i++) {
            arrTmp[i] = i;
        }*/

        int[] tmp = new int[4];
        tmp = new int[]{3, 4, 5};
        //System.out.println(Arrays.toString(rr));
        System.out.println(Arrays.toString(ArrayWrapper.getArr()));
        //System.out.println(ArrayWrapper.get(0));
        //System.out.println(ArrayWrapper.get(1));
        //System.out.println(ArrayWrapper.get(4));
        //System.out.println(ArrayWrapper.get(19));
        //System.out.println(ArrayWrapper.get(20));
        //ArrayWrapper.remove(0);
        //ArrayWrapper.remove(1);
        //ArrayWrapper.remove(5);
        //ArrayWrapper.remove(18);
        //ArrayWrapper.remove(19);
        //ArrayWrapper.remove(20);
        //System.out.println(Arrays.toString(ArrayWrapper.getArr()));
        //ArrayWrapper.sort();
        //System.out.println(ArrayWrapper.searchCorrect(10));
        //ArrayWrapper.removeByValue(10);
        //ArrayWrapper.revers();
        //ArrayWrapper.subArray(3,7);
        //System.out.println(ArrayWrapper.sum());
        //ArrayWrapper.add(arrTmp);
        //ArrayWrapper.add(5, 777);
        //ArrayWrapper.prepend(7);
        System.out.println(ArrayWrapper.searchSubArray(tmp));
        System.out.println(Arrays.toString(tmp));
        ArrayWrapper.removeSubArray(tmp);
        System.out.println(Arrays.toString(ArrayWrapper.getArr()));

    }
}