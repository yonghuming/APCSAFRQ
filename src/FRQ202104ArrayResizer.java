/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class ArrayResizer
{
    public static boolean isNonZeroRow(int[][] arr2d, int r)
    {
        for (int num : arr2d[r])
        {
            if (num == 0)
            {
                return false;
            }
        }
        return true;
    }

    public static int numNonZeroRows(int[][] arr2d)
    {
        int count = 0;

        for (int i = 0; i < arr2d.length; i++)
        {
            if (isNonZeroRow(arr2d, i))
            {
                count += 1;
            }
        }
        return count;
    }

    public static int[][] resize(int[][] arr2d)
    {
        int size = numNonZeroRows(arr2d);
        int columns = arr2d[0].length;
        int[][] result = new int[size][columns];

        int index = 0;

        for (int i = 0; i < arr2d.length; i++)
        {
            if (isNonZeroRow(arr2d, i))
            {
                result[index] = arr2d[i];
                index += 1;
            }
        }
        // result is not excatly copy of non zero row
        return result;
    }

    public static void display(int[][] arr2d)
    {
        for(int[] row : arr2d)
        {
            for (int num : row)
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
public class FRQ202104ArrayResizer
{
    public static void main(String[] args)
    {
        int[][] arr2d = {
                {2, 2, 0},
                {1, 3, 2},
                {0, 0, 0},
                {4, 5, 6}
        };
        System.out.println("row index: " + 0 + " " + ArrayResizer.isNonZeroRow(arr2d, 0) );
        System.out.println("row index: " + 1 + " " + ArrayResizer.isNonZeroRow(arr2d, 1) );
        System.out.println("row index: " + 2 + " " + ArrayResizer.isNonZeroRow(arr2d, 2) );
        System.out.println("row index: " + 3 + " " + ArrayResizer.isNonZeroRow(arr2d, 3) );

        ArrayResizer.display(arr2d);
        System.out.println("after resize: ");
        ArrayResizer.display(ArrayResizer.resize(arr2d));
    }
}
