/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class GameSpinner
{
    private int sector;
    private int run;
    private int num;
    private int lastNum;
    public GameSpinner(int sector)
    {
        this.sector = sector;
    }
    public int currentRun()
    {
        return run;
    }

    public void spin()
    {
        lastNum = num;
        num = (int) (Math.random() * sector) + 1;
        if (num == lastNum)
        {
            run += 1;
        }
        else
        {
            run = 1;
        }
    }

    public int getNum()
    {
        return num;
    }
}

public class FRQ202002GameSpinnerWhile
{
    public static void main(String[] args)
    {
        GameSpinner spinner = new GameSpinner(4);
        for (int i = 0; i < 12; i++)
        {
            System.out.println("run:  " + spinner.currentRun());
            spinner.spin();
            System.out.println("num: " + spinner.getNum());
        }
    }
}
