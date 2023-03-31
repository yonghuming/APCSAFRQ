/*
 * Copyright (c) 2023.
 * Created by ilangxm from XDF. 964683112@qq.com vx:ilangxm
 */

import java.util.ArrayList;

class ProductReview
{
    private String name, review;

    public ProductReview(String name, String review)
    {
        this.name = name;
        this.review = review;
    }

    public String getName()
    {
        return name;
    }

    public String getReview()
    {
        return review;
    }
}
class ReviewCollector
{
    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    public ReviewCollector()
    {
        this.reviewList = new ArrayList<>();
        this.productList = new ArrayList<>();
    }

    public void addReview(ProductReview prodReview)
    {
        reviewList.add(prodReview);

        String prodName = prodReview.getName();
        boolean found = false;
        for (String n : productList)
        {
            if (n.equals(prodName))
            {
                found = true;
            }
        }
        if (!found)
        {
            productList.add(prodName);
        }
    }

    public int getNumGoodReviews(String prodName)
    {
        int goodReviews = 0;
        for (ProductReview prodReview : reviewList)
        {
            String review = prodReview.getReview();
            // not compare to Stirng "good"
            if (review.indexOf("best") >= 0)
            {
                goodReviews += 1;
            }
        }
        return goodReviews;
    }
}
public class FRQ202003ProductViewArrayListObject
{
    public static void main(String[] args)
    {

    }
}
