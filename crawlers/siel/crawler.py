from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.keys import Keys

browser = webdriver.Chrome(executable_path=r"C:\Users\logonrmlocal\Downloads\chromedriver_win32\chromedriver.exe")

browser.get('http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/siel/login.html')

enviar_bt = browser.find_element_by_xpath("//td/input[@type='submit']")
enviar_bt.click()

input_nome = browser.find_element_by_xpath("//td/input[@name='nome']")
input_nome.send_keys("nome")

input_num_processo = browser.find_element_by_xpath("//input[@name='num_processo']")
input_num_processo.send_keys("889532255")

pesquisar_bt = browser.find_element_by_class_name("img")
pesquisar_bt.submit()  # verificar
tds = browser.find_elements_by_tag_name('td')
lista_de_textos = [t.text for t in tds]

print(lista_de_textos)

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

print(dados)

browser.close()
