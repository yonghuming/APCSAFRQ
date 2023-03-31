/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

/**
 * Created by vx:ilangxm 964683112@qq.com from xdf
 * An APCSA teacher
 */
interface StudyPractice
{
    String getProblem();

    void nextProblme();
}
class MultPractice implements StudyPractice
{
    private int num1, num2;

    public MultPractice(int num1, int num2)
    {
        this.num1 = num1;
        this.num2 = num2;
    }

    public String getProblem()
    {
        return num1 + " TIMES " + num2;
    }

    public void nextProblme()
    {
        num2 += 1;
    }
}
public class FRQ201702StudyPractice
{
    public static void main(String[] args)
    {
        StudyPractice p1 = new MultPractice(7, 3);
        System.out.println(p1.getProblem());

        p1.nextProblme();
        System.out.println(p1.getProblem());

        p1.nextProblme();
        System.out.println(p1.getProblem());

        p1.nextProblme();
        System.out.println(p1.getProblem());

        StudyPractice p2 = new MultPractice(4, 12);
        p2.nextProblme();
        System.out.println(p2.getProblem());
        System.out.println(p2.getProblem());

        p2.nextProblme();
        p2.nextProblme();
        System.out.println(p2.getProblem());

        p2.nextProblme();
        System.out.println(p2.getProblem());


    }
}
