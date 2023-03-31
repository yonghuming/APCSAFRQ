/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

/**
 * Created by 964683112@qq.com from xdf
 * An APCSA teacher
 */
import java.util.ArrayList;

class Digits
{
    private ArrayList<Integer> digitList;

    public Digits(int num)
    {
        digitList = new ArrayList<>();

        if (num == 0)
        {
            digitList.add(0);
        }
        else
        {
            while (num != 0)
            {
                int digit = num % 10;
                digitList.add(0, digit);
                num = num / 10;
            }
        }
    }

    public boolean isStrictlyIncreasing()
    {
        for (int i = 0; i < digitList.size() - 1; i++)
        {
            int front = digitList.get(i);
            int after = digitList.get(i+1);
            if (front >= after)
            {
                return false;
            }
        }
        return true;
    }
    public boolean isStrictlyIncreasing2()
    {
        for (int i = digitList.size() - 1; i > 0; i --)
        {
            int front = digitList.get(i-1);
            int after = digitList.get(i);
            if (front >= after)
            {
                return false;
            }
        }
        return true;
    }

    /**
     * do not need to write on exam
     */
    public String toString()
    {
        return digitList + "";
    }
}
public class FRQ201701Digits
{
    public static void main(String[] args)
    {
        Digits d1 = new Digits(15704);
        System.out.println(d1);

        Digits d2 = new Digits(0);
        System.out.println(d2);

        System.out.println(new Digits(7).isStrictlyIncreasing());
        System.out.println(new Digits(1356).isStrictlyIncreasing());
        System.out.println(new Digits(1336).isStrictlyIncreasing());
        System.out.println(new Digits(1536).isStrictlyIncreasing());
        System.out.println(new Digits(65310).isStrictlyIncreasing());
    }
}
