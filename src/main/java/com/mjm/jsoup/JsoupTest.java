package com.mjm.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by majunmin on 2018/12/4.
 */
public class JsoupTest {

    public static void main(String[] args) {
        try
        {
            Document document = Jsoup.connect("http://www.yiibai.com").get();

            Element first = document.head().select("link[href~=.*\\.(ico|png)]").first();
            if (first == null){
                first = document.head().select("meta[itemprop=image]").first();
                if (first != null)
                {
                    String favImage = first.attr("content");
                    System.out.println(favImage);
                }
            }else{
                System.out.println(first.attr("href"));
            }
            Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif)]");
            for (Element image : images)
            {
                System.out.println("src : " + image.attr("src"));
                System.out.println("height : " + image.attr("height"));
                System.out.println("width : " + image.attr("width"));
                System.out.println("alt : " + image.attr("alt"));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
