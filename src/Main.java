/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

public class Main
{
    public static void hello(int times)
    {
        System.out.println("call hello method with parameter: " + times);
        if (times > 0) // recursion case
        {
            System.out.println("A " + times);
            hello(times - 1); // recursive call hello
            System.out.println("B " + times);
        }
        // base case times <= 0
        System.out.println("call end parameter: " + times);
    }
    public static int sum(int n)
    {
        if (n == 0)
        {
            return 0; // base case
        }
        else
        {
            return n + sum(n - 1); // recursion case
        }
    }
    public static int arraySum(int[] arr)
    {
        int sum = 0; // declare initialize variable
        for (int i = 0; i < arr.length; i++)
        {
            sum += arr[i];
        }
        return sum;
    }
    public static int count(int[] arr)
    {
        int numEvens = 0;

        for (int i = 0; i < arr.length; i++)
        {
            if (arr[i] % 2 == 0)
            {
                numEvens += 1;
            }
        }
        return numEvens;
    }
    public static void main(String[] args)
    {

        int[] arr = {1, 2, 3, 4};
        System.out.println(count(arr));
    }
}