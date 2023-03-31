/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class LightBoard
{
    private boolean[][] lights;

    public LightBoard(int numRows, int numCols)
    {
        lights = new boolean[numRows][numCols];
        for (int r = 0; r < numRows; r++)
        {
            for (int c = 0; c < numCols; c++)
            {
                if (Math.random() < 0.4)
                {
                    lights[r][c] = true;
                }
                else
                {
                    lights[r][c] = false;
                }
            }
        }
    }

    public boolean evaluateLight(int row, int col)
    {

        int numOfOn = 0;
        boolean isOn = lights[row][col];
        for (int r = 0; r < lights.length; r++)
        {
            if (lights[r][col])
            {
                numOfOn += 1;
            }
        }
        if (isOn && numOfOn % 2 == 0)
        {
            return false;
        }
        if (!isOn && numOfOn % 3 == 0)
        {
            return true;
        }

        return lights[row][col];
    }
    public void dispaly()
    {
        for (boolean[] row: lights)
        {
            for (boolean light: row)
            {
                if (light)
                {
                    System.out.print(light + "  ");
                }
                else
                {
                    System.out.print(light + " ");
                }
            }
            System.out.println();
        }
    }
}

public class FRQ201904LightBoard {
    public static void main(String[] args) {
        LightBoard borad = new LightBoard(7, 5);
        borad.dispaly();
        System.out.println(borad.evaluateLight(0, 3));
        System.out.println(borad.evaluateLight(6,0));
    }
}

