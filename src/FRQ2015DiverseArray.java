/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

/**
 * Created by vx:ilangxm 964683112@qq.com from xdf
 * An APCSA teacher
 */

import java.util.Arrays;

class DiverseArray
{
    public static int arraySum(int[] arr)
    {
        int sum = 0;
        for (int num : arr)
        {
            sum += num;
        }
        return sum;
    }
    public static int[] rowSums(int[][] arr2d)
    {
        int numRows = arr2d.length; // number of rows
        int[] sums = new int[numRows];

        for (int row = 0; row < numRows; row++)
        {
            sums[row] = arraySum(arr2d[row]);
        }

        return sums;
    }
    public static boolean isDiverse(int[][] arr2d)
    {
        int[] sums = rowSums(arr2d);

        for (int i = 0; i < sums.length - 1; i++)
        {
            for (int j = i + 1; j < sums.length; j++)
            {
                if (sums[i] == sums[j])
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isDiverse2(int[][] arr2d)
    {
        int[] sums = rowSums(arr2d);

        for (int i = 0; i < sums.length; i++)
        {
            for (int j = 0; j < sums.length; j++)
            {
                if (i != j && sums[i] == sums[j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
public class FRQ2015DiverseArray
{
    public static void main(String[] args)
    {
        int[][] arr2d = {
                {1, 3, 2, 7, 3},
                {10, 10, 4, 6, 2},
                {5, 3, 5, 8, 6},
                {7, 6, 4, 2, 1}
        };
        System.out.println("array sum: " + DiverseArray.arraySum(arr2d[0]));
        System.out.println("row sums: " + Arrays.toString(DiverseArray.rowSums(arr2d)));
        System.out.println("is diverse array: " + DiverseArray.isDiverse(arr2d));

        arr2d = new int[][]{
                {1, 1, 5, 3, 4},
                {12, 7, 6, 1, 9},
                {8, 11, 10, 2, 5},
                {3, 2, 3, 0, 6}
        };
        System.out.println("array sum: " + DiverseArray.arraySum(arr2d[0]));
        System.out.println("row sums: " + Arrays.toString(DiverseArray.rowSums(arr2d)));
        System.out.println("is diverse array: " + DiverseArray.isDiverse(arr2d));
    }
}
