/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

/**
 * Created by vx:ilangxm 964683112@qq.com from xdf
 * An APCSA teacher
 */
import java.util.ArrayList;

class SpareArrayEntry
{
    private int row, col, value;
    public SpareArrayEntry(int r, int c, int v)
    {
        row = r;
        col = c;
        value = v;
    }

    public int getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
    public String toString()
    {
        return String.format("(%d,%d,%d)", row, col, value);
    }
}

class SparseArray
{
    private int numRows, numCols;
    private ArrayList<SpareArrayEntry> entries;
    public SparseArray()
    {
        entries = new ArrayList<>();
    }
    public int getValueAt(int row, int col)
    {
        for (SpareArrayEntry item : entries)
        {
            if (row == item.getRow() && col == item.getCol())
            {
                return item.getValue();
            }
        }
        return 0;
    }
    public void remmoveColumn(int c)
    {
        for (int i = 0; i < entries.size(); i++)
        {
            SpareArrayEntry entry = entries.get(i);
            if (entry.getCol() == c)
            {
                entries.remove(i);
                i -= 1;
            }
            if (entry.getCol() > c)
            {
                SpareArrayEntry newEntry = new SpareArrayEntry(entry.getRow(), entry.getCol()-1, entry.getValue());
                entries.set(i,newEntry);
            }
            numCols -= 1;
        }
    }

    public int getNumRows()
    {
        return numRows;
    }

    public int getNumCols()
    {
        return numCols;
    }

    public void addEntry(int row, int col, int value)
    {
        SpareArrayEntry entry = new SpareArrayEntry(row, col, value);
        entries.add(entry);
    }
}

public class FRQ201503SparseArray
{
    public static void main(String[] args)
    {
        SparseArray matrix = new SparseArray();
        matrix.addEntry(2, 0, 1);
        matrix.addEntry(1, 1, 5);
        matrix.addEntry(3, 1, -9);
        matrix.addEntry(1,4, 4);
        System.out.println("(2, 0) " + matrix.getValueAt(2, 0));
        System.out.println("(2, 1) " + matrix.getValueAt(2, 1));


    }
}
