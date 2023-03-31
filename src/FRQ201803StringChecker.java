/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

interface StringChecker
{
    boolean isValid(String str);
}

class CodeWordChecker implements StringChecker
{
    private int min, max;
    private String symbol;

    public CodeWordChecker(int min, int max, String symbol)
    {
        this.min = min;
        this.max = max;
        this.symbol = symbol;
    }

    public CodeWordChecker(String s)
    {
        this.symbol = s;
        min = 6;
        max = 20;
    }

    public boolean isValid(String str)
    {
        boolean validLength = str.length() >= min && str.length() <= max;
        boolean hasSymbol = str.contains(symbol);
        return validLength && !hasSymbol;
    }
}
public class FRQ201803StringChecker
{
    public static void main(String[] args)
    {
        StringChecker sc1 = new CodeWordChecker(5, 8, "$");
        System.out.println("happy: " + sc1.isValid("happy"));
        System.out.println("happy$: " + sc1.isValid("happy$"));
        System.out.println("Code: " + sc1.isValid("Code"));
        System.out.println("happyCode: " + sc1.isValid("happyCode"));

        StringChecker sc2 = new CodeWordChecker("pass");
        System.out.println("MyPass: " + sc2.isValid("MyPass"));
        System.out.println("Mypassport: " + sc2.isValid("Mypassport"));
        System.out.println("happy: " + sc2.isValid("happy"));
        System.out.println("1,000,000,000,000,000,000,000,000: " + sc2.isValid("1,000,000,000,000,000,000,000,000"));
    }
}
