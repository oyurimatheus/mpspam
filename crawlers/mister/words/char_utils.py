import unicodedata


def remove_words_accents(word: str):
    normalized = unicodedata.normalize('NFD', word)
    ascii_text = normalized.encode('ascii', 'ignore')

    return str(ascii_text.decode("utf-8"))

