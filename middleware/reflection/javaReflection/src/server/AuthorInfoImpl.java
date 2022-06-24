package server;

import sr.grpc.gen.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AuthorInfoImpl extends AuthorInfoGrpc.AuthorInfoImplBase {
    private class Work {
        Work(String t, String g, Author.Work.Language l) {
            this.title = t;
            this.genre = g;
            this.lang = l;
        }
        String title;
        String genre;
        Author.Work.Language lang;
    }

    Map<String, ArrayList<Work>> authorWorks = new HashMap<>() {{
        put("Sappho", new ArrayList<Work>() {{
            add(new Work("Ode to Aphrodite","poetry",Author.Work.Language.GREEK));
            add(new Work("Tithonus poem","poetry",Author.Work.Language.GREEK));
            add(new Work("Midnight poem","poetry",Author.Work.Language.GREEK));
        }});
        put("Homer", new ArrayList<Work>() {{
            add(new Work("Iliad","epic",Author.Work.Language.GREEK));
            add(new Work("Odyssey","epic",Author.Work.Language.GREEK));
        }});
        put("Cicero", new ArrayList<Work>() {{
            add(new Work("De natura deorum","dialogue",Author.Work.Language.LATIN));
            add(new Work("Aratea","poetry",Author.Work.Language.LATIN));
        }});
        put("Virgil", new ArrayList<Work>() {{
            add(new Work("Aeneis","epic",Author.Work.Language.LATIN));
            add(new Work("Georgica","poetry",Author.Work.Language.LATIN));
            add(new Work("Catalepton","poetry",Author.Work.Language.LATIN));
        }});
    }};
    Map<String, Nationality> authorNationality = new HashMap<>() {{
        put("Sappho",Nationality.GREEK);
        put("Homer",Nationality.GREEK);
        put("Cicero",Nationality.ROMAN);
        put("Virgil",Nationality.ROMAN);
    }};
    Map<String, ArrayList<String>> authorNames = new HashMap<>() {{
        put("greek", new ArrayList<String>() {{
            add("Sappho");
            add("Homer");
        }});
        put("roman", new ArrayList<String>() {{
            add("Virgil");
            add("Cicero");
        }});
    }};

    public void getAuthorByName(sr.grpc.gen.nameRequest request,
                                io.grpc.stub.StreamObserver<sr.grpc.gen.Author> responseObserver) {
        String name = request.getName();
        System.out.println("getAuthorByName: " + name);
        Nationality n = authorNationality.get(name);
        ArrayList<Work> works = authorWorks.get(name);
        Author.Builder b = Author.newBuilder();
        if (n != null && works != null) {
            b.setName(name).setNation(n);
            for (Work w: works) {
                Author.Work work = Author.Work.newBuilder().setTitle(w.title).setGenre(w.genre).setLang(w.lang).build();
                b.addWorks(work);
            }
        }
        Author response = b.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void getAuthorsByNationality(sr.grpc.gen.nationalityRequest request,
                                        io.grpc.stub.StreamObserver<sr.grpc.gen.Authors> responseObserver) {
        String nationality = request.getNation();
        System.out.println("getAuthorsByNationality: " + nationality);
        ArrayList<String> authors = authorNames.get(nationality);
        Authors.Builder b = Authors.newBuilder();
        if(authors != null) {
            for(String name: authors) {
                Nationality n = authorNationality.get(name);
                ArrayList<Work> works = authorWorks.get(name);
                Author.Builder ab = Author.newBuilder().setName(name).setNation(n);
                for(Work w: works) {
                    Author.Work work = Author.Work.newBuilder().setTitle(w.title).setGenre(w.genre).setLang(w.lang).build();
                    ab.addWorks(work);
                }
                Author a = ab.build();
                b.addAuthors(a);
            }
        }
        Authors response = b.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void countByNationality(sr.grpc.gen.nationalityRequest request,
                                   io.grpc.stub.StreamObserver<sr.grpc.gen.Count> responseObserver) {
        String nationality = request.getNation();
        System.out.println("countByNationality: " + nationality);
        ArrayList<String> authors = authorNames.get(nationality);
        Count.Builder b = Count.newBuilder();
        if (authors != null) {
            int number = authors.size();
            b.setNum(number);
            for(String a: authors) {
                b.addNames(a);
            }
        }
        Count response = b.build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
