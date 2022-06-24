import grpc
from yagrc import reflector as yagrc_reflector

reflector = yagrc_reflector.GrpcReflectionClient()

with grpc.insecure_channel('localhost:50051') as channel:
    reflector.load_protocols(channel, symbols=["author.AuthorInfo"])
    stub_class = reflector.service_stub_class("author.AuthorInfo")
    request_class_1 = reflector.message_class("author.nationalityRequest")
    request_class_2 = reflector.message_class("author.nameRequest")
    nation_class = reflector.enum_class("author.Nationality")

    stub = stub_class(channel)
    response_1 = stub.countByNationality(request_class_1(nation="greek"))
    print("RESPONSE -- countByNationality")
    print("nationality: greek")
    print("Number of works:", response_1.num)
    print("Authors:", response_1.names)
    print("------------------------------")

    response_2 = stub.getAuthorByName(request_class_2(name="Sappho"))
    print("RESPONSE -- getAuthorByName")
    print("name:", response_2.name)
    if response_2.nation == nation_class.GREEK:
        print("nationality:", "greek")
    else:
        print("nationality:", "roman")
    print("_____author works______")
    works = response_2.works
    l = len(works)
    for i in range(l):
        w = works[i]
        print("--title:", w.title)
        print("  genre:", w.genre)
        if w.lang == 0:
            print("  language: latin")
        elif w.lang == 1:
            print("  language: greek")
    print("------------------------------")

    response_3 = stub.getAuthorsByNationality(request_class_1(nation="roman"))
    print("RESPONSE -- getAuthorsByNationality")
    authors = response_3.authors
    print("nationality: roman")
    l = len(authors)
    for i in range(l):
        a = authors[i]
        print("--name:", a.name)
        works = a.works
        lw = len(works)
        print("--works:")
        for i in range(lw):
            print("-----title:",works[i].title)
            print("     genre:",works[i].genre)
    print("------------------------------")
    response_4 = stub.getAuthorsByNationality(request_class_1(nation="r"))
    print("RESPONSE -- getAuthorsByNationality")
    authors = response_4.authors
    print("nationality: r")
    l = len(authors)
    for i in range(l):
        a = authors[i]
        print("--name:", a.name)
        works = a.works
        lw = len(works)
        print("--works:")
        for i in range(lw):
            print("-----title:", works[i].title)
            print("     genre:", works[i].genre)
    print("------------------------------")
    response_5 = stub.countByNationality(request_class_1(nation="g"))
    print("RESPONSE -- countByNationality")
    print("nationality: g")
    print("Number of works:", response_5.num)
    print("Authors:", response_5.names)
    print("------------------------------")
    response_2 = stub.getAuthorByName(request_class_2(name="S"))
    print("RESPONSE -- getAuthorByName")
    print("name:", response_2.name)
    if response_2.nation == nation_class.GREEK:
        print("nationality:", "greek")
    else:
        print("nationality:", "roman")
    print("_____author works______")
    works = response_2.works
    l = len(works)
    for i in range(l):
        w = works[i]
        print("--title:", w.title)
        print("  genre:", w.genre)
        if w.lang == 0:
            print("  language: latin")
        elif w.lang == 1:
            print("  language: greek")
    print("------------------------------")