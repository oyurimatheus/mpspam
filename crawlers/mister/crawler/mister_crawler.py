from bs4 import BeautifulSoup
import requests
from crawlers.mister.crawler.errors import ScrapPageError
from crawlers.mister.crawler.mister import Mister


class MisterCrawler:

    def scrap(self, url: 'a site url string to scrap') -> Mister:
        response = requests.get(url)

        if response.status_code != 200:
            raise ScrapPageError('Fail to connect to server')

        html = response.content
        parser = BeautifulSoup(html, 'html.parser')

        return Mister(parser)
