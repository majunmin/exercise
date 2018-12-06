package com.mjm;

import com.xuxueli.crawler.XxlCrawler;
import com.xuxueli.crawler.parser.PageParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void test1(){
        Document document = null;
        try {
            document = Jsoup.connect("http://www.baidu.com").get();
            Elements links = document.select("a[href]");
            for (Element link : links) {
//                System.out.println("link: " + link.attr("href"));
//                System.out.println("text: " + link.text());
            }

            Document doc = Jsoup.connect("http://www.yiibai.com").get();
            String title = doc.title();
            System.out.println("title is: " + title);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2(){

        String[] urls = new String[1];
        for (int i = 0; i < urls.length; i++) {
             urls[i] = "http://www.ygdy8.net/html/gndy/oumei/list_7_" + (i + 1) + ".html";
        }

        XxlCrawler crawler = new XxlCrawler.Builder()
                .setUrls(urls)
                .setWhiteUrlRegexs("https://my\\.oschina\\.net/xuxueli/blog/\\d+")
                .setWhiteUrlRegexs("http://www\\.ygdy8\\.net/html/gndy/dyzz/\\d+/\\d+.html")
                .setThreadCount(3)
                .setPageParser(new PageParser<PageVo>() {
                    @Override
                    public void parse(Document html, Element pageVoElement, PageVo pageVo) {
                        // 解析封装 PageVo 对象
                        String pageUrl = html.baseUri();
                        System.out.println(pageUrl + ":" + pageVo.toString());
                        pageVo.getContent().split("◎");
                    }
                })
                .build();

        crawler.start(true);
    }
}
