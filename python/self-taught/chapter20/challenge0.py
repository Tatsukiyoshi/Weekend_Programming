# http://tinyurl.com/jmgyar8
# http://tinyurl.com/h5eywoa
# http://tinyurl.com/hvjulxh

import urllib.request
from bs4 import BeautifulSoup

class Scraper:
    def __init__(self, site):
        self.site = site
    
    def scrape(self):
        urllist = open("self-taught/chapter20/url.txt", "w", encoding="utf-8")

        # HTML を読み込む
        urllist.write("{} Open!\n".format(self.site))
        r = urllib.request.urlopen(self.site)
        html = r.read()

        # HTML をパースする
        parser = "html.parser"
        sp = BeautifulSoup(html, parser)
        urllist.write("BeautifulSoup Pasing Start!\n")

        # A タグを収集する
        for tag in sp.find_all("a"):
            # A タグの href 属性を収集する
            url = tag.get("href")
            
            # A タグに href 属性がなければ、無視
            if url is None:
                continue

            if "topics" in url:
                urllist.write("Topic: {}\n".format(news + url))

            if "articles" in url:
                urllist.write("Article: {}\n".format(news + url))

        urllist.close()

news = "https://news.google.co.jp/"
Scraper(news).scrape()
