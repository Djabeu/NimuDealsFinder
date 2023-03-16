package org.example;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        WebClient client = new WebClient();
        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setCssEnabled(false);
        HtmlPage searchPage = client.getPage("https://79element.pl/srebrne-monety-1-oz/?orderby=price&InStockbutton=sort&product-page=1");

        for(DomElement domElement : searchPage.getElementsByTagName("ul")) {
            System.out.println(domElement);

            System.out.println(domElement.getAttribute("class"));

            if(domElement.getAttribute("class").contains("products")) {
                for(DomElement child : domElement.getChildElements()) {
                    System.out.println(child.getTagName());
                }
            }

            System.out.println();
        }

    }
}