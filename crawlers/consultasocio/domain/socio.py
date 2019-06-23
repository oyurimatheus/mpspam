class Socio:

    def __init__(self, nome, quantidade_de_empresas, capital_social_das_empresas, primeira_sociedade, socios):
        self.__nome = nome
        self.__quantidade_de_empresas = quantidade_de_empresas
        self.__capital_social_das_empresas = capital_social_das_empresas
        self.__primeira_sociedade = primeira_sociedade
        self.__socios = socios

    @property
    def nome(self):
        return self.__nome

    @property
    def quantidade_de_empresas(self):
        return self.__quantidade_de_empresas

    @property
    def capital_social_das_empresas(self):
        return self.__capital_social_das_empresas

    @property
    def primeira_sociedade(self):
        return self.__primeira_sociedade

    @property
    def socios(self):
        return self.__socios

    def __str__(self) -> str:
        return f'[SOCIO] nome={self.__nome}, quantidade_de_empresas={self.__quantidade_de_empresas},' \
               f'capital_social_das_empresas={self.__capital_social_das_empresas},' \
               f'primeira_sociedade={self.__primeira_sociedade}' \
               f'socios={self.__socios}'
