from crawlers.consultasocio.helpers.url_helpers import formatar_nome_para_o_padrao_da_url
from crawlers.consultasocio.infra import SocioClient
from crawlers.consultasocio.infra.constants import URL_CONSULTA_BASE
from crawlers.mister.crawler.mister_crawler import MisterCrawler

socio_client = SocioClient(MisterCrawler())

nome = 'Carlos Felicio Da Silveira'


nome_formatado = formatar_nome_para_o_padrao_da_url(nome)

url = URL_CONSULTA_BASE.format(nome_formatado)

socio_scrap = socio_client.request(url)

socio = socio_scrap.extract()

print('-' * 50)
print(socio)

