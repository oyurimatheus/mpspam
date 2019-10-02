from selenium import webdriver
from selenium.webdriver import ActionChains
from kafka import KafkaConsumer, KafkaProducer
import json


def crawler():
    opcoes = webdriver.ChromeOptions()
    opcoes.headless = True
    driver = webdriver.Chrome(options=opcoes, executable_path="/Users/oyurimatheus/Downloads/chromedriver")

    driver.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/jucesp/index.html")

    click_botao = driver.find_element_by_xpath("//input[@type='submit' and @value='Buscar']")
    click_botao.click();

    captcha = driver.find_element_by_name("ctl00$cphContent$gdvResultadoBusca$CaptchaControl1")
    captcha.click();

    click_continuar = driver.find_element_by_xpath("//input[@type='submit' and @value='Continuar']")
    click_continuar.click();

    click_empresa = driver.find_element_by_id("ctl00_cphContent_gdvResultadoBusca_gdvContent_ctl02_lbtSelecionar")
    click_empresa.click();

    # DEF VAR
    data_emissao = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblEmissao")
    data_emissao = data_emissao.text

    nome_social = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblEmpresa")
    nome_social = nome_social.text

    nire_matriz = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblNire")
    nire_matriz = nire_matriz.text

    tipo_empresa = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblDetalhes")
    tipo_empresa = tipo_empresa.text

    dt_consti = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblConstituicao")
    dt_consti = dt_consti.text

    inicio_atividade = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblAtividade")
    inicio_atividade = inicio_atividade.text

    cnpj = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblCnpj")
    cnpj = cnpj.text

    objeto = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblObjeto")
    objeto = objeto.text

    capital = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblCapital")
    capital = capital.text

    logradouro = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblLogradouro")
    logradouro = logradouro.text

    numero = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblNumero")
    numero = numero.text

    bairro = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblBairro")
    bairro = bairro.text

    complemento = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblComplemento")
    complemento = complemento.text

    municipio = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblMunicipio")
    municipio = municipio.text

    cep = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblCep")
    cep = cep.text

    uf = driver.find_element_by_id("ctl00_cphContent_frmPreVisualiza_lblUf")
    uf = uf.text

    # FIM DEF VAR

    dados = {
        'Data de emissao ': data_emissao,
        'Nome empresa ': nome_social,
        'Nire Matriz ': nire_matriz,
        'Tipo de empresa ': tipo_empresa,
        'Data de Constituicao ': dt_consti,
        'Inicio de atividade ': inicio_atividade,
        'CNPJ ': cnpj,
        'Objeto ': objeto,
        'Capital ': capital,
        'Logradouro ': logradouro,
        'Numero ': numero,
        'Bairro ': bairro,
        'Complemento ': complemento,
        'Municipio ': municipio,
        'CEP ': cep,
        'UF ': uf
    }

    return dados


if __name__ == '__main__':
    consumer = KafkaConsumer('consulta',
                             group_id='jucesp',
                             bootstrap_servers=['localhost:9092'],
                             auto_offset_reset='earliest',
                             value_deserializer=lambda m: json.loads(m.decode('utf8')))
    for mensagem in consumer:
        informacoes = mensagem.value
        print(informacoes)

        id_pedido = informacoes.get('id', '')
        cnpj = informacoes.get('cnpj', '')

        infos = crawler()
        infos['id'] = id_pedido

        print(infos)
        producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                                 value_serializer=lambda m: json.dumps(m).encode('utf8'))
        producer.send('jucesp', infos)