from selenium.webdriver import ActionChains
from selenium import webdriver
from kafka import KafkaConsumer, KafkaProducer
import json
import re


def crawler(nome, numero_processo):

    numero_processo_regex = re.sub('[^a-zA-Z0-9 \\\]', '', numero_processo)
    opcoes = webdriver.ChromeOptions()
    opcoes.headless = True
    browser = webdriver.Chrome(options=opcoes, executable_path="/Users/oyurimatheus/Downloads/chromedriver")

    browser.get('http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/siel/login.html')

    enviar_bt = browser.find_element_by_xpath("//td/input[@type='submit']")
    enviar_bt.click()

    input_nome = browser.find_element_by_xpath("//td/input[@name='nome']")
    input_nome.send_keys(nome)

    input_num_processo = browser.find_element_by_xpath("//input[@name='num_processo']")
    input_num_processo.send_keys(numero_processo_regex)

    pesquisar_bt = browser.find_element_by_class_name("img")
    pesquisar_bt.submit()  # verificar
    tds = browser.find_elements_by_tag_name('td')
    lista_de_textos = [t.text for t in tds]

    nome = lista_de_textos[3]
    titulo = lista_de_textos[5]
    data_nasc = lista_de_textos[7]
    zona = lista_de_textos[9]
    endereco = lista_de_textos[11]
    municipio = lista_de_textos[13]
    uf = lista_de_textos[15]
    data_domic = lista_de_textos[17]
    nome_pai = lista_de_textos[19]
    nome_mae = lista_de_textos[21]
    naturalidade = lista_de_textos[23]
    cod_validacao = lista_de_textos[25]

    dados = {
        'nome': nome,
        'titulo': titulo,
        'data_nasc': data_nasc,
        'zona': zona,
        'endereco': endereco,
        'municipio': municipio,
        'uf': uf,
        'data_domic': data_domic,
        'nome_pai': nome_pai,
        'nome_mae': nome_mae,
        'naturalidade': naturalidade,
        'cod_validacao': cod_validacao
    }

    return dados

if __name__ == "__main__":
    consumer = KafkaConsumer('consulta',
                             group_id='siel',
                             bootstrap_servers=['localhost:9092'],
                             auto_offset_reset='earliest',
                             value_deserializer=lambda m: json.loads(m.decode('utf8')))
    for mensagem in consumer:
        informacoes = mensagem.value
        print(informacoes)

        id_pedido = informacoes.get('id', '')
        nome = informacoes.get('nome', '')
        numero_processo = informacoes.get('numeroProcesso', '')

        infos = crawler(nome, numero_processo)
        infos['id'] = id_pedido

        print(infos)

        producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                                 value_serializer=lambda m: json.dumps(m).encode('utf8'))
        producer.send('siel', infos)