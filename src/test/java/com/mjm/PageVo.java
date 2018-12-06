package com.mjm;

import com.xuxueli.crawler.annotation.PageFieldSelect;
import com.xuxueli.crawler.annotation.PageSelect;
import com.xuxueli.crawler.conf.XxlCrawlerConf;
import lombok.Data;

// PageSelect 注解：从页面中抽取出一个或多个VO对象；
@PageSelect(cssQuery = "#header > div > div.bd2 > div.bd3 > div.bd3r > div.co_area2")
@Data
public class PageVo {

//    /**
//     * 译名
//     */
//    private String zh_title;
//
//    /**
//     * 片名
//     */
//    private String en_title;
//
//    /**
//     * 年代
//     */
//    private Integer year;
//
//    /**
//     * 地区
//     */
//    private String region;
//
//    /**
//     * 类别
//     */
//    private String category;
//
//    /**
//     * 语言
//     */
//    private String language;
//
//    /**
//     * 副标题
//     */
//    private String subtitle;
//
//    /**
//     * 上映日期
//     */
//    private String releaseDate;
//
//    /**
//     * 豆瓣评分
//     */
//    private String doubanScore;
//
//    /**
//     * 文件格式
//     */
//    private String fileFormat;
//
//    /**
//     * 视频尺寸
//     */
//    private String VideoSize;
//
//    /**
//     * 文件大小
//     */
//    private String fileSize;
//
//    /**
//     * 片长
//     */
//    private String length;
//
//    /**
//     * 导演
//     */
//    private String director;
//
//    /**
//     * 主演
//     */
//    private String starring;

    @PageFieldSelect(cssQuery = "#Zoom > span > p:nth-child(1)", selectType = XxlCrawlerConf.SelectType.TEXT)
    private String content;

    /**
     * 海报
     */
    @PageFieldSelect(cssQuery = "#Zoom > span > p:nth-child(1) > img:first-of-type",
            selectType = XxlCrawlerConf.SelectType.ATTR, selectVal = "abs:src")
    private String posterUrl;

    /**
     * ftp下载链接
     */
    @PageFieldSelect(cssQuery = "#Zoom > span > table > tbody > tr > td > a",
    selectType = XxlCrawlerConf.SelectType.TEXT)
    private String ftpLink;

}