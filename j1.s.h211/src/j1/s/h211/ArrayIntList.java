/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1.s.h211;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author lanh0
 */
public class ArrayIntList {

    public static void main(String[] args) {
        int arr[] = new int[]{5, 2, 2, -5, -1, 3, 2, 4, 1, 1, 1, 0, 2};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(fromCounts(arr)));
    }

    public static Integer[] fromCounts(int[] elementData) {
        List<Integer> number = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < elementData.length - 1; i = i + 2) {
            int count = 0;
            if (elementData[i] > 0) {
                while (count < elementData[i]) {
                    number.add(elementData[i + 1]);
                    count++;
                }
            }else{
                System.out.println("Quantity >0");
            }
        }
        return number.toArray(new Integer[number.size()]);
    }

}
