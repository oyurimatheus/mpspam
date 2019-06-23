class Mister:

    def __init__(self, parser):
        self.__parser = parser

    def get_tag_content(self, tag, cssclass=None) -> str:
        return self.__parser.find(tag, class_=cssclass).contents[0]

    def get_all_tags(self, tag, cssclass=None, **kwargs) -> list:
        return self.__parser.find_all(tag, class_=cssclass, **kwargs)

