from crawlers.consultasocio.domain.socio import Socio
from crawlers.consultasocio.infra.constants import URL_SITE_BASE
from crawlers.mister.words.char_utils import remove_words_accents


class SocioScrap:

    def __init__(self, page: 'A mister instance'):
        self.__page = page

    def extract(self) -> Socio:
        infos = dict()

        infos['nome'] = self.__page.get_tag_content(tag='h1', cssclass='documentFirstHeading')
        strongs = self.__page.get_all_tags('strong')

        infos['quantidade_de_empresas'] = strongs[0].string
        infos['capital_social_das_empresas'] = strongs[1].string
        infos['primeira_sociedade'] = strongs[2].string

        socios = self.__page.get_all_tags('a', cssclass='socio_value', href=True)
        infos['socios'] = []

        for socio in socios:
            nome_socio = remove_words_accents(socio.string)
            if nome_socio != remove_words_accents(infos['nome']):
                infos['socios'].append(dict(url=URL_SITE_BASE.format(socio['href']), nome=nome_socio))

        return Socio(**infos)


