/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class Position
{
    private int r, c;

    public Position(int r, int c)
    {
        this.r = r;
        this.c = c;
    }

    public int getC()
    {
        return c;
    }

    public int getR()
    {
        return r;
    }
    public String toString()
    {
        return "(" + r + "," + c + ")";
    }
}

public class FRQ201704Position
{
    public static Position findPosition(int num, int[][] arr2d)
    {
        for (int row = 0; row < arr2d.length; row++)
        {
            for (int col = 0; col < arr2d[0].length; col++)
            {
                if (arr2d[row][col] == num)
                {
                    return new Position(row, col);
                }
            }
        }
        return null;
    }

    public static Position[][] getSuccessorArray(int[][] arr2d)
    {
        int rows = arr2d.length;
        int cols = arr2d[0].length;

        Position[][] result = new Position[rows][cols]; // successor array position
        for (int row = 0; row < rows; row++)
        {
            for (int col = 0; col < cols; col++)
            {
                result[row][col] = findPosition(arr2d[row][col] + 1, arr2d);
            }
        }
        return result;
    }

    /**
     * do not need write
     * @param positions
     */
    public static void display(Position[][] positions)
    {
        for(Position[] row : positions)
        {
            for (Position p : row)
            {
                System.out.print(p);
            }
            System.out.println();
        }
    }
    public static void main(String[] args)
    {
        int[][] arr2d = {
                {15, 5, 9, 10},
                {12, 16, 11, 6},
                {14, 8, 13, 7}
        };

        display(getSuccessorArray(arr2d));

    }
}
