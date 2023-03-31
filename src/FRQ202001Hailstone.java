/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class Hailstone
{
    public static int hailstoneLength(int n)
    {
        int len = 1;
        while (n != 1)
        {
            if (n % 2 == 0)
            {
                n = n / 2;
            }
            else
            {
                n = 3 * n + 1;
            }
            len += 1;
        }
        return len;
    }
    public static boolean isLongSeq(int n)
    {
        return hailstoneLength(n) > n;
    }

    public static double progLong(int n)
    {
        int count = 0;
        for (int i = 1; i <= n ; i++)
        {
            if (isLongSeq(i))
            {
                count += 1;
            }
        }
        return (double) count / n;
    }
}
public class FRQ202001Hailstone
{
    public static void main(String[] args)
    {
        System.out.println(Hailstone.progLong(10));
    }
}
