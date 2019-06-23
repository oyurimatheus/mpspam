from crawlers.mister.words.char_utils import remove_words_accents


def formatar_nome_para_o_padrao_da_url(nome):
    return '/' + remove_words_accents(nome).lower().replace(' ', '-')
