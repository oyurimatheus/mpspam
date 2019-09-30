from typing import Dict, Any, Union

from selenium.webdriver import ActionChains
from selenium import webdriver
from kafka import KafkaConsumer, KafkaProducer
import json

def crawler(cnpj, pis):

    opcoes = webdriver.ChromeOptions()
    opcoes.headless = True

    browser = webdriver.Chrome(options=opcoes, executable_path="/Users/oyurimatheus/Downloads/chromedriver")
    # browser = webdriver.Chrome()

    browser.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/caged/login.html")
    login = browser.find_element_by_name("submit")
    login.click()

    def open_menu_and_select(option_id) :
        elemento_menu = browser.find_element_by_id("j_idt12:lk_menu_consultas")

        sub_elemento_menu = browser.find_element_by_id(str(option_id))

        acoes = ActionChains(browser)

        acoes.move_to_element(elemento_menu).move_to_element(sub_elemento_menu).click().perform()


    open_menu_and_select("j_idt12:idMenuLinkAutorizado")

    input_chave = browser.find_element_by_id("formPesquisarAutorizado:txtChavePesquisaAutorizado014")

    input_chave.send_keys(cnpj)

    input_chave.submit()


    cnpj_cei_cpf = browser.find_element_by_id("txCnpj020_2").text
    social_reason = browser.find_element_by_id("txtrazaosocial020_4").text
    street_address = browser.find_element_by_id("txt3_logradouro020").text
    city_district = browser.find_element_by_id("txt4_bairro020").text
    city_county = browser.find_element_by_id("txt5_codmunicipio020").text
    city_uf = browser.find_element_by_id("txt7_uf020").text
    city_cep = browser.find_element_by_id("txt8_cep020").text
    contact_name = browser.find_element_by_id("txt_nome_contato").text
    contact_email = browser.find_element_by_id("txt11_email").text
    municipio_id = browser.find_element_by_id("txt5_codmunicipio020").text
    municipio_nome = browser.find_element_by_id("txt6_municipio020").text
    telefone_ddd = browser.find_element_by_id("txt21_ddd020").text
    telefone_numero = browser.find_element_by_id("txt9_telefone020").text

    open_menu_and_select("j_idt12:idMenuLinkEmpresaCaged")

    cnpj_input = browser.find_element_by_id("formPesquisarEmpresaCAGED:txtcnpjRaiz")
    cnpj_input.send_keys(cnpj)
    cnpj_input.submit()

    cnpj_raiz = browser.find_element_by_id("formResumoEmpresaCaged:txtCnpjRaiz").text
    codigo_atividade_economica = browser.find_element_by_id("formResumoEmpresaCaged:txtCodigoAtividadeEconomica").text
    descricao_atividade_economica = browser.find_element_by_id("formResumoEmpresaCaged:txtDescricaoAtividadeEconomica").text
    numero_filiais = browser.find_element_by_id("formResumoEmpresaCaged:txtNumFiliais").text
    numero_admissoes = browser.find_element_by_id("formResumoEmpresaCaged:txtTotalNumAdmissoes").text
    variacao_absoluta = browser.find_element_by_id("formResumoEmpresaCaged:txtTotalVariacaoAbosulta").text
    total_vinculos = browser.find_element_by_id("formResumoEmpresaCaged:txtTotalVinculos").text
    desligamentos = browser.find_element_by_id("formResumoEmpresaCaged:txtTotalNumDesligamentos").text

    open_menu_and_select("j_idt12:idMenuLinkTrabalhador")
    input_trabalhador = browser.find_element_by_id("formPesquisarTrabalhador:txtChavePesquisa")
    input_trabalhador.send_keys(pis)
    input_trabalhador.submit()


    nome_trabalhador = browser.find_element_by_id("txt2_Nome027").text
    pis_base_trabalhador = browser.find_element_by_id("txt1_Pis028").text
    cpf_trabalhador = browser.find_element_by_id("txt3_Cpf027").text
    ctps_trabalhador = browser.find_element_by_id("txt5_Ctps027").text
    situacao_pis_trabalhador = browser.find_element_by_id("txt4_SitPis027").text
    nacionalidade_trabalhador = browser.find_element_by_id("txt8_Nac027").text
    grau_trabalhador = browser.find_element_by_id("txt12_Instr027").text
    deficiencia_trabalhador = browser.find_element_by_id("txt13_Def027").text
    tempo_trabalho_trabalhador = browser.find_element_by_id("txt26_Caged027").text

    dados = {
        'cnpj_cei_cpf': cnpj_cei_cpf,
        'social_reason': social_reason,
        'street_address': street_address,
        'city_district': city_district,
        'city_county': city_county,
        'city_uf': city_uf,
        'city_cep': city_cep,
        'contact_name': contact_name,
        'contact_email': contact_email,
        'municipio_id': municipio_id,
        'municipio_nome': municipio_nome,
        'telefone_ddd': telefone_ddd,
        'telefone_numero': telefone_numero,
        'cnpj_raiz': cnpj_raiz,
        'codigo_atividade_economica': codigo_atividade_economica,
        'descricao_atividade_economica': descricao_atividade_economica,
        'numero_filiais': numero_filiais,
        'numero_admissoes': numero_admissoes,
        'variacao_absoluta': variacao_absoluta,
        'total_vinculos': total_vinculos,
        'desligamentos': desligamentos,
        'nome_trabalhador': nome_trabalhador,
        'pis_base_trabalhador': pis_base_trabalhador,
        'cpf_trabalhador': cpf_trabalhador,
        'ctps_trabalhador': ctps_trabalhador,
        'situacao_pis_trabalhador': situacao_pis_trabalhador,
        'nacionalidade_trabalhador': nacionalidade_trabalhador,
        'grau_trabalhador': grau_trabalhador,
        'deficiencia_trabalhador': deficiencia_trabalhador,
        'tempo_trabalho_trabalhador': tempo_trabalho_trabalhador
    }

    return dados

if __name__ == '__main__':
    consumer = KafkaConsumer('consulta',
                          group_id='caged',
                          bootstrap_servers=['localhost:9092'],
                          auto_offset_reset='earliest',
                          value_deserializer=lambda m: json.loads(m.decode('utf8')))
    for mensagem in consumer:
        informacoes = mensagem.value
        print(informacoes)

        id_pedido = informacoes.get('id', '')
        cnpj = informacoes.get('cnpj', '')
        pis = informacoes.get('pis', '')

        infos = crawler(cnpj, pis)
        infos['id'] = id_pedido

        print(infos)

        producer = KafkaProducer(bootstrap_servers=['localhost:9092'],
                              value_serializer=lambda m: json.dumps(m).encode('utf8'))
        producer.send('caged', infos)