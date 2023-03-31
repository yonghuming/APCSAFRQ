/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

class WordMatch
{
    private String secret;

    public WordMatch(String secret)
    {
        this.secret = secret;
    }

    public int scoreGuess(String guess)
    {
        int lenDelta = secret.length() - guess.length();

        int ocurrences = 0;
        for (int i = 0; i <= lenDelta ; i++)
        {
            String temp = secret.substring(i, i + guess.length());
            if (temp.equals(guess))
            {
                ocurrences += 1;
            }
        }
        int len = guess.length();
        return ocurrences * len * len;
    }

    public String findBetterGuess(String guess1, String guess2)
    {
        int value = scoreGuess(guess1) - scoreGuess(guess2);
        if (value > 0)
        {
            return guess1;
        }
        else if (value < 0)
        {
            return guess2;
        }

        if (guess1.compareTo(guess2) > 0)
        {
            return guess1;
        }
        return guess2;
    }
}
public class FRQ202101WordMatchString
{
    public static void main(String[] args)
    {
        WordMatch game = new WordMatch("mississippi");
        System.out.println("guess i: " + game.scoreGuess("i"));
        System.out.println("guess iss: " + game.scoreGuess("iss"));
        System.out.println("guess issipp: " + game.scoreGuess("issipp"));
        System.out.println("guess mississippi: " + game.scoreGuess("mississippi"));

        game = new WordMatch("aaaabb");
        System.out.println("guess a: " + game.scoreGuess("a"));
        System.out.println("guess aa: " + game.scoreGuess("aa"));
        System.out.println("guess aaa: " + game.scoreGuess("aaa"));
        System.out.println("guess aabb: " + game.scoreGuess("aabb"));
        System.out.println("guess c: " + game.scoreGuess("c"));

        System.out.println(game.findBetterGuess("ten", "nation"));
        System.out.println(game.findBetterGuess("con", "cat"));
    }
}
