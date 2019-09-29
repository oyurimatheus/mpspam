from selenium import webdriver
from kafka import KafkaConsumer, KafkaProducer
import json


def crawler(tipo_de_registro, numero_processo, vara):
    opcoes = webdriver.FirefoxOptions()
    opcoes.headless = True

    firefox = webdriver.Firefox(options=opcoes)

    firefox.get('http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/arpensp/login.html')

    banner_pesquisa = firefox.find_element_by_xpath("//a[@href='pagina2-pesquisa.html']")
    banner_pesquisa.click()

    crc = firefox.find_element_by_xpath("//li[@class='item3']/a")
    crc.click()

    botao_pagina_busca = firefox.find_element_by_xpath("//a[@href='pagina3-busca.html']")
    botao_pagina_busca.click()

    input_tipo_registro = firefox.find_element_by_xpath(f"//input[@id='{tipo_de_registro}']")
    input_tipo_registro.click()

    input_numero_processo = firefox.find_element_by_xpath("//input[@name='numero_processo']")
    input_numero_processo.send_keys(numero_processo)

    input_vara = firefox.find_element_by_xpath(f"//option[@value='{vara}']")
    input_vara.click()

    input_pesquisar = firefox.find_element_by_xpath("//input[@id='btn_pesquisar']")
    input_pesquisar.click()

    cartorio_id = firefox.find_element_by_xpath("//input[@name='cartorio_id']")
    busca_juiz_id = firefox.find_element_by_xpath("//input[@name='busca_juiz_id']")
    tipo_registro = firefox.find_element_by_xpath("//input[@name='tipo_registro']")
    nome_registrado_1 = firefox.find_element_by_xpath("//input[@name='nome_registrado_1']")
    nome_registrado_2 = firefox.find_element_by_xpath("//input[@name='nome_registrado_2']")
    novo_nome_registrado_1 = firefox.find_element_by_xpath("//input[@name='novo_nome_registrado_1']")
    novo_nome_registrado_2 = firefox.find_element_by_xpath("//input[@name='novo_nome_registrado_2']")
    data_ocorrido = firefox.find_element_by_xpath("//input[@name='data_ocorrido']")
    data_registro = firefox.find_element_by_xpath("//input[@name='data_registro']")
    num_livro = firefox.find_element_by_xpath("//input[@name='num_livro']")
    num_folha = firefox.find_element_by_xpath("//input[@name='num_folha']")
    num_registro = firefox.find_element_by_xpath("//input[@name='num_registro']")
    matricula = firefox.find_element_by_xpath("//input[@name='matricula']")

    informacoes = {
        "cartorio_id": cartorio_id.get_attribute('value'),
        "busca_juiz_id": busca_juiz_id.get_attribute('value'),
        "tipo_registro": tipo_registro.get_attribute('value'),
        "nome_registrado_1": nome_registrado_1.get_attribute('value'),
        "nome_registrado_2": nome_registrado_2.get_attribute('value'),
        "novo_nome_registrado_1": novo_nome_registrado_1.get_attribute('value'),
        "novo_nome_registrado_2": novo_nome_registrado_2.get_attribute('value'),
        "data_ocorrido": data_ocorrido.get_attribute('value'),
        "data_registro": data_registro.get_attribute('value'),
        "num_livro": num_livro.get_attribute('value'),
        "num_folha": num_folha.get_attribute('value'),
        "num_registro": num_registro.get_attribute('value'),
        "matricula": matricula.get_attribute('value')
    }

    return informacoes


if __name__ == "__main__":
    consumer = KafkaConsumer('consulta',
                             group_id='arpensp',
                             bootstrap_servers=['localhost:9092'],
                             auto_offset_reset='earliest',
                             value_deserializer=lambda m: json.loads(m.decode('utf8')))
    for mensagem in consumer:
        informacoes = mensagem.value
        print(informacoes)

        id_pedido = informacoes.get('id', '')
        tipo_de_registro = informacoes.get('tipoDeRegistro', 'i')
        numero_processo = informacoes.get('numeroProcesso', '')
        vara = informacoes.get('vara', '297')

        infos = crawler(tipo_de_registro, numero_processo, vara)
        infos['id'] = id_pedido

        print(infos)

        producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                                 value_serializer=lambda m: json.dumps(m).encode('utf8'))
        producer.send('arpensp', infos)
