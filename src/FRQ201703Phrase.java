/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class Phrase
{
    private String currentPhrase;

    public Phrase(String p)
    {
        this.currentPhrase = p;
    }
    public int findNthOccurrences(String str, int n)
    {
        int count = 0;
        for (int i = 0; i <= currentPhrase.length() - str.length(); i++)
        {
            String temp = currentPhrase.substring(i, i+str.length());
            if (temp.equals(str))
            {
                count += 1;
                if (count == n)
                {
                    return i;
                }
            }
        }
        return -1;
    }
    public void replaceNthOccurrence(String str, int n, String repl)
    {
        int pos = findNthOccurrences(str, n);
        if (pos != -1)
        {
            String first = currentPhrase.substring(0, pos);
            String last = currentPhrase.substring(pos + str.length());

            currentPhrase = first + repl + last;
        }
    }
    public int findLastOccurrence(String str)
    {
        int pos = -1;
        for (int i = 0; i <= currentPhrase.length() - str.length(); i++)
        {
            String temp = currentPhrase.substring(i, i + str.length());
            if (temp.equals(str))
            {
                pos = i;
            }
        }
        return pos;
    }
    public String toString()
    {
        return currentPhrase;
    }
}
public class FRQ201703Phrase
{
    public static void main(String[] args)
    {
        Phrase phrase1 = new Phrase("A cat ate late.");
        phrase1.replaceNthOccurrence("at", 1, "rane");
        System.out.println(phrase1);

        Phrase phrase2 = new Phrase("A cat ate late.");
        phrase2.replaceNthOccurrence("at", 6, "xx");
        System.out.println(phrase2);

        Phrase phrase3 = new Phrase("A cat ate late.");
        phrase3.replaceNthOccurrence("bat", 2, "xx");
        System.out.println(phrase3);

        Phrase phrase4 = new Phrase("aaaa");
        phrase4.replaceNthOccurrence("aa", 1, "xx");
        System.out.println(phrase4);

        Phrase phrase5 = new Phrase("aaaa");
        phrase5.replaceNthOccurrence("aa", 2, "bbb");
        System.out.println(phrase5);

        Phrase phrase7 = new Phrase("A cat ate late.");
        System.out.println(phrase7.findLastOccurrence("at"));
        System.out.println(phrase7.findLastOccurrence("cat"));
        System.out.println(phrase7.findLastOccurrence("bat"));
    }
}
