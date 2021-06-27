# http://tinyurl.com/jmgyar8
# http://tinyurl.com/h5eywoa
# http://tinyurl.com/hvjulxh

import urllib.request
from bs4 import BeautifulSoup

class Scraper:
    def __init__(self, site):
        self.site = site
    
    def scrape(self):
        #pass
        # HTML を読み込む
        print("{} Open!".format(self.site))
        r = urllib.request.urlopen(self.site)
        html = r.read()

        # HTML をパースする
        parser = "html.parser"
        sp = BeautifulSoup(html, parser)
        print("BeautifulSoup Pasing Start!")

        # A タグを収集する
        for tag in sp.find_all("a"):
            # A タグの href 属性を収集する
            url = tag.get("href")
            
            # A タグに href 属性がなければ、無視
            if url is None:
                continue

            # href 属性に html を含む場合、リンク先のアドレスとして出力する
            # 現状、htmlを含んでおらず、結果として何も出力しない処理になる
            if "html" in url:
                print("\n" + url)

news = "https://news.google.com/"
Scraper(news).scrape()
