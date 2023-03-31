/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

import java.util.Arrays;

class ArrayTester
{
    public static int[] getColumn(int[][] arr2d, int c)
    {
        int rows = arr2d.length; //
        int[] rst = new int[rows];
        for (int r = 0; r < arr2d.length; r++)
        {
            int[] row = arr2d[r]; // 索引为 r 的行
            rst[r] = row[c];  // 索引为 r 列索引 c 行
            // rst[r] = arr2d[r][c];
        }
        return rst;
    }
    public static boolean hasAllValues(int[] arr1, int[] arr2)
    {
        for (int v1 : arr1)
        {
            boolean found = false;
            for (int v2 : arr2)
            {
                if (v1 == v2)
                {
                    found = true;
                }
            }
            if (!found)
            {
                return false;
            }
        }
        return true;
    }
    public static boolean containsDuplicates(int[] arr)
    {
        for (int i = 0; i < arr.length - 1; i++)
        {
            for (int j = i + 1; j < arr.length; j++)
            {
                if (arr[i] == arr[j])
                {
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isLatin(int[][] square)
    {
        if (containsDuplicates(square[0]))
        {
            return false; // 如果第一行包含了重复值，直接返回 false
        }
        int[] first = square[0];
        for (int[] row : square)
        {
            if (!hasAllValues(first, row))
            {
                return false; // 如果存在一行不包含第一行所有的值，返回 false
            }
        }
        for (int i = 0; i < square[0].length; i++)
        {
            if (!hasAllValues(first, getColumn(square, i)))
            {
                return false; // 如果某一列不包含第一行所有的值，返回 false
            }
        }
        return true; // 如果 3 个条件满足，返回 true
    }
    public static boolean isLatin2(int[][] square)
    {   // 如果第一行不包含家重复值，square[0] 表示第一行
        boolean rst = !containsDuplicates(square[0]);
        // 看任意行是否包含第一行所有的值
        for (int[] row : square)
        {
            rst = rst && hasAllValues(row, square[0]);
        }
        // 看任意列，是否包含第一行所有的值
        for (int i = 0; i < square[0].length; i++)
        {
            rst = rst && hasAllValues(getColumn(square, i), square[0]);
        }
        return rst;
    }
    public static int arraySum(int[] arr)
    {
        int sum = 0;
        for (int num : arr)
        {
            sum += num;
        }
        return sum;
    }
    public static int arraySum2(int[] arr)
    {
        int sum = 0;
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return sum;
    }

    public static int[] rowSums(int[][] arr2d)
    {
        int rows = arr2d.length;
        int[] rst = new int[rows];

        for (int i = 0; i < rows; i++)
        {
            rst[i] = arraySum(arr2d[i]);
        }
        return rst;
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

        // 如果数组是排序好的，则如果存在两个相邻的值
        // 相同，那么就是有重复的值吧

        Arrays.sort(sums); // 排列给定的数组
        // 并且这个方法会修改原来的数组
        for (int i = 0; i < sums.length - 1; i++)
        {
            if (sums[i] == sums[i+1])
            {
                return false;
            }
        }

        return true;
    }
}
public class FRQ201804ArrayTester
{
    public static void main(String[] args)
    {
        int[][] arr2d = {
                {0, 1, 2},
                {3, 4, 5},
                {6, 7, 8},
                {9, 5, 3}
        };
        int[] result = ArrayTester.getColumn(arr2d, 1);
        System.out.println(Arrays.toString(result));
        System.out.println(ArrayTester.isLatin(arr2d));
        int[][] mat = {
                {1, 2, 3},
                {2, 3, 1},
                {3, 1, 2}
        };
        System.out.println(ArrayTester.isLatin(mat));
    }
}
