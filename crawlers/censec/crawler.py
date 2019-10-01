from selenium import webdriver
from selenium.webdriver import ActionChains
from kafka import KafkaConsumer, KafkaProducer
import json


def crawler(cnpj):
    opcoes = webdriver.ChromeOptions()
    opcoes.headless = True

    browser = webdriver.Chrome(options=opcoes, executable_path="/Users/oyurimatheus/Downloads/chromedriver")
    browser.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/censec/login.html")

    input_nome = browser.find_element_by_id("LoginTextBox")
    input_nome.send_keys("fiap")
    input_senha = browser.find_element_by_id("SenhaTextBox")
    input_senha.send_keys("mpsp")

    botao_login = browser.find_element_by_id("EntrarButton")
    botao_login.click()

    menu_elemento = browser.find_element_by_id("menucentrais")
    sub_menu = browser.find_element_by_id("ctl00_CESDILi")
    sub_sub_menu = browser.find_element_by_id("ctl00_CESDIConsultaAtoLI")
    actions = ActionChains(browser)
    actions.move_to_element(menu_elemento).move_to_element(sub_menu).move_to_element(sub_sub_menu).click().perform()

    input_cpf_cnpj = browser.find_element_by_id("ctl00_ContentPlaceHolder1_DocumentoTextBox")
    input_cpf_cnpj.send_keys(cnpj)

    botao_buscar = browser.find_element_by_id("ctl00_ContentPlaceHolder1_BuscarButton")
    botao_buscar.click()

    input_radio = browser.find_element_by_xpath("//input[@value='81448223']")
    input_radio.click()

    botao_visualizar = browser.find_element_by_id("ctl00_ContentPlaceHolder1_VisualizarButton")
    botao_visualizar.click()

    carga = browser.find_element_by_id("ctl00_ContentPlaceHolder1_CodigoTextBox").get_attribute("value")
    mes_carga = browser.find_element_by_id("ctl00_ContentPlaceHolder1_MesReferenciaDropDownList").get_attribute("value")
    ano_carga = browser.find_element_by_id("ctl00_ContentPlaceHolder1_AnoReferenciaDropDownList").get_attribute("value")
    ato = browser.find_element_by_id("ctl00_ContentPlaceHolder1_TipoAtoDropDownList").get_attribute("value")
    dia_ato = browser.find_element_by_id("ctl00_ContentPlaceHolder1_DiaAtoTextBox").get_attribute("value")
    mes_ato = browser.find_element_by_id("ctl00_ContentPlaceHolder1_MesAtoTextBox").get_attribute("value")
    ano_ato = browser.find_element_by_id("ctl00_ContentPlaceHolder1_AnoAtoTextBox").get_attribute("value")
    mes_num = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho', 'Agosto', 'Setembro', 'Outubro',
               'Novembro', 'Dezembro']
    mes_format = mes_num.index(mes_ato)
    data_ato = (dia_ato + '/' + str(mes_format + 1) + '/' + ano_ato)
    livro = browser.find_element_by_id("ctl00_ContentPlaceHolder1_LivroTextBox").get_attribute("value")
    livro_compl = browser.find_element_by_id("ctl00_ContentPlaceHolder1_LivroComplementoTextBox").get_attribute("value")
    folha = browser.find_element_by_id("ctl00_ContentPlaceHolder1_FolhaTextBox").get_attribute("value")
    folha_compl = browser.find_element_by_id("ctl00_ContentPlaceHolder1_FolhaComplementoTextBox").get_attribute("value")
    uf = browser.find_element_by_id("ctl00_ContentPlaceHolder1_DadosCartorio_CartorioUFTextBox").get_attribute("value")
    municipio = browser.find_element_by_id(
        "ctl00_ContentPlaceHolder1_DadosCartorio_CartorioMunicipioTextBox").get_attribute("value")
    cartorio = browser.find_element_by_id("ctl00_ContentPlaceHolder1_DadosCartorio_CartorioNomeTextBox").get_attribute(
        "value")

    dados = {
        'carga': carga,
        'mes_carga': mes_carga,
        'ano_carga': ano_carga,
        'ato': ato,
        'data_ato': data_ato,
        'livro': livro,
        'livro_compl': livro_compl,
        'folha': folha,
        'folha_compl': folha_compl,
        'uf': uf,
        'municipio': municipio,
        'cartorio': cartorio
    }
    return dados


if __name__ == "__main__":
    consumer = KafkaConsumer('consulta',
                             group_id='censec',
                             bootstrap_servers=['localhost:9092'],
                             auto_offset_reset='earliest',
                             value_deserializer=lambda m: json.loads(m.decode('utf8')))
    for mensagem in consumer:
        informacoes = mensagem.value
        print(informacoes)

        id_pedido = informacoes.get('id', '')
        cnpj = informacoes.get('cnpj', '')

        infos = crawler(cnpj)
        infos['id'] = id_pedido

        print(infos)
        producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                                 value_serializer=lambda m: json.dumps(m).encode('utf8'))
        producer.send('censec', infos)
