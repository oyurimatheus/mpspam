from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.keys import Keys

browser = webdriver.Chrome(executable_path=r"C:\Users\Matheus\Documents\chromedriver_win32\chromedriver.exe")
browser.get("http://ec2-18-231-116-58.sa-east-1.compute.amazonaws.com/cadesp/login.html")

input_nome = browser.find_element_by_id("ctl00_conteudoPaginaPlaceHolder_loginControl_UserName")
input_nome.send_keys("fiap")
input_senha = browser.find_element_by_id("ctl00_conteudoPaginaPlaceHolder_loginControl_Password")
input_senha.send_keys("mpsp")

botao_login = browser.find_element_by_id("ctl00_conteudoPaginaPlaceHolder_loginControl_loginButton")
botao_login.click()

menu_elemento = browser.find_element_by_xpath ("//a[@href='https://www.cadesp.fazenda.sp.gov.br/(S(wyminl552cyomgasm4yfb245))/Pages/Principal.aspx#']")
sub_menu = browser.find_element_by_xpath("//a[@href='pagina3-pesquisa.html']")
actions = ActionChains(browser)
actions.move_to_element(menu_elemento).move_to_element(sub_menu).click().perform()

browser.find_element_by_xpath("//select[@name='ctl00$conteudoPaginaPlaceHolder$tcConsultaCompleta$TabPanel1$lstIdentificacao']/option[text()='CNPJ']").click()

input_cnpj = browser.find_element_by_id("ctl00_conteudoPaginaPlaceHolder_tcConsultaCompleta_TabPanel1_txtIdentificacao")
input_cnpj.send_keys("58048000000141")

botao_consultar = browser.find_element_by_id("ctl00_conteudoPaginaPlaceHolder_tcConsultaCompleta_TabPanel1_btnConsultarEstabelecimento")
botao_consultar.click()

array=browser.find_elements_by_class_name("dadoDetalhe")

print(array[3].text)
ie = array[3].text

print(array[4].text)
situacao = array[4].text

print(array[5].text)
cnpj = array[5].text

print(array[6].text)
data_inscricao_estado = array[6].text

print(array[7].text)
nome_empresarial = array[7].text

print(array[8].text)
regime_estadual = array[8].text

print(array[9].text)
drt = array[9].text

print(array[10].text)
posto_fiscal = array[10].text

print(array[20].text)
data_ie = array[20].text

print(array[22].text)
nire = array[22].text

print(array[23].text)
situacao_cadastral = array[23].text

print(array[24].text)
data_inicio_situacao = array[24].text

print(array[27].text)
tipo_unidade = array[27].text

print(array[28].text)
formas_atuacao = array[28].text

dados = {
    'ie': ie,
    'situacao': situacao,
    'cnpj': cnpj,
    'data_inscricao_estado': data_inscricao_estado,
    'nome_empresarial': nome_empresarial,
    'regime_estadual': regime_estadual,
    'drt': drt,
    'posto_fiscal': posto_fiscal,
    'data_ie': data_ie,
    'nire': nire,
    'situacao_cadastral': situacao_cadastral,
    'data_inicio_situacao': data_inicio_situacao,
    'tipo_unidade': tipo_unidade,
    'formas_atuacao': formas_atuacao
}

print (dados)

browser.close()