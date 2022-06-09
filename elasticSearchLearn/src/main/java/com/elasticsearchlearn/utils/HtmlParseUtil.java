package com.elasticsearchlearn.utils;/*
 * @Author: zeng
 * @Data: 2022/1/21 19:17
 * @Description: TODO
 */

import com.elasticsearchlearn.po.Goods;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;

@Component
public class HtmlParseUtil {

    public ArrayList<Goods> JsoupGet(String search) throws IOException {

        //https://search.jd.com/Search?keyword=java&pvid=a103f60f8c2f4811aa6fddcd24af6d97&page=3&s=56&click=0
        //https://search.jd.com/Search?keyword=java&pvid=a103f60f8c2f4811aa6fddcd24af6d97&page=5&s=116&click=0
        StringBuilder url = new StringBuilder("https://search.jd.com/Search?keyword=");
        url.append(search);
        Document doc = Jsoup.parse(new URL(url.toString()),30000);
        Elements elementsBox = doc.getElementsByClass("gl-i-wrap");
        ArrayList<Goods> list = new ArrayList<>();

        for (Element element : elementsBox) {
            String img = element.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = element.getElementsByClass("p-price").eq(0).text();
            String name = element.getElementsByClass("p-name").eq(0).text();
            list.add(new Goods(UUID.randomUUID().toString(),name,price,img));
        }

        Iterator<Goods> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }

        return list;
    }
}
