/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class SingleTable
{
    private int numSeats, height;
    private double viewQuality;

    public SingleTable(int numSeats, double viewQuality, int height)
    {
        this.numSeats = numSeats;
        this.height = height;
        this.viewQuality = viewQuality;
    }

    public int getNumSeats()
    {
        return numSeats;
    }

    public int getHeight()
    {
        return height;
    }

    public double getViewQuality()
    {
        return viewQuality;
    }

    public void setViewQuality(double viewQuality)
    {
        this.viewQuality = viewQuality;
    }
}

class CombinedTable
{
    private SingleTable t1, t2;
    private int canSeat;
//    private double desirability;

    public CombinedTable(SingleTable t1, SingleTable t2)
    {
        this.t1 = t1;
        this.t2 = t2;
        canSeat = (t1.getNumSeats() + t2.getNumSeats()) - 2;
    }
    public boolean canSeat(int num)
    {
        return canSeat >= num;
    }

    public double getDesirability()
    {
        double desirability = (t1.getViewQuality() + t2.getViewQuality()) / 2;
        if (t1.getHeight() != t2.getHeight())
        {
            desirability -= 10;
        }
        return desirability;
    }
}

public class FRQ202102CombinedTable
{
    public static void main(String[] args)
    {
        SingleTable t1 = new SingleTable(4, 60.0, 74);
        SingleTable t2 = new SingleTable(8, 70.0, 74);
        SingleTable t3 = new SingleTable(12, 75.0, 76);

        CombinedTable c1 = new CombinedTable(t1, t2);
        System.out.println("c1 can seat 9: " + c1.canSeat(9));
        System.out.println("c1 can seat 11: " + c1.canSeat(11));
        System.out.println("c1 desirability: " + c1.getDesirability());

        CombinedTable c2 = new CombinedTable(t2, t3);
        System.out.println("c2 can seat 9: " + c2.canSeat(18));
        System.out.println("c2 desirability: " + c2.getDesirability());
        t2.setViewQuality(80); // dynamic cal
        System.out.println("c2 desirability: " + c2.getDesirability());
    }
}
