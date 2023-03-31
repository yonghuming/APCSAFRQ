/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class Seat
{
    private boolean available;
    private int tier;

    public Seat(boolean available, int tier)
    {
        this.available = available;
        this.tier = tier;
    }

    public boolean isAvailable()
    {
        return available;
    }

    public int getTier()
    {
        return tier;
    }

    public void setAvailablility(boolean available)
    {
        this.available = available;
    }
}
class Theater
{
    private Seat[][] theaterSeats;

    public Theater(int seatsPerRow, int tier1Rows, int tier2Rows)
    {
        theaterSeats = new Seat[tier1Rows + tier2Rows][seatsPerRow];

        for (int row = 0; row < theaterSeats.length; row++)
        {
            for (int col = 0; col < seatsPerRow; col++)
            {
                if (row < tier1Rows)
                {
                    theaterSeats[row][col] = new Seat(true, 1);
                }
                else
                {
                    theaterSeats[row][col] = new Seat(true, 2);
                }
            }
        }
    }

    public boolean reassignSeat(int fromRow, int toRow, int fromCol, int toCol)
    {
        Seat toSeat = theaterSeats[toRow][fromCol];
        if (!toSeat.isAvailable())
        {
            return false;
        }
        Seat fromSeat = theaterSeats[fromCol][toCol];

        if (fromSeat.getTier() > toSeat.getTier())
        {
            return false;
        }

        fromSeat.setAvailablility(true);
        toSeat.setAvailablility(false);
        return true;
    }

}
public class FRQ202004TheaterSeats2DArray
{
    public static void main(String[] args)
    {

    }
}
