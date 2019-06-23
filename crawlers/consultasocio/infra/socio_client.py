from crawlers.consultasocio.aplication import SocioScrap


class SocioClient:

    def __init__(self, service: 'A service with the method scrap'):
        self.__mister_service = service

    def request(self, url) -> SocioScrap:
        return SocioScrap(self.__mister_service.scrap(url))

