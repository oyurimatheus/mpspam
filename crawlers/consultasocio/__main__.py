from crawlers.consultasocio.helpers.url_helpers import formatar_nome_para_o_padrao_da_url
from crawlers.consultasocio.infra import SocioClient
from crawlers.consultasocio.infra.constants import URL_CONSULTA_BASE
from crawlers.mister.crawler.mister_crawler import MisterCrawler
from kafka import KafkaProducer, KafkaConsumer
import json


consumer = KafkaConsumer('consulta',
                             group_id='arpensp',
                             bootstrap_servers=['localhost:9092'],
                             auto_offset_reset='earliest',
                             value_deserializer=lambda m: json.loads(m.decode('utf8')))

for mensagem in consumer:
    informacoes = mensagem.value
    print(informacoes)

    id_pedido = informacoes.get('id', '')
    nome = informacoes.get('nome', '')

    socio_client = SocioClient(MisterCrawler())

    nome_formatado = formatar_nome_para_o_padrao_da_url(nome)

    url = URL_CONSULTA_BASE.format(nome_formatado)

    socio_scrap = socio_client.request(url)

    socio = socio_scrap.extract()

    print('-' * 50)
    print(socio)

    socios = [socio['nome'] for socio in socio.socios]

    infos = {'nome': socio.nome,
             'primeira_sociedade': socio.primeira_sociedade,
             'capital_social': socio.capital_social_das_empresas,
             'quantidade_de_empresas': socio.quantidade_de_empresas,
             'socios': ''.join(socios), 
             'id': id_pedido
    }

    print(infos)

    producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                             value_serializer=lambda m: json.dumps(m).encode('utf8'))
    producer.send('consulta-socio', infos)
