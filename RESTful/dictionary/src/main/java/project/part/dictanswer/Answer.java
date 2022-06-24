package project.part.dictanswer;

import project.part.dictionary.utils.*;
import org.json.JSONException;
import project.part.dictionary.utils.*;

import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.util.*;
import java.util.concurrent.*;

public class Answer {

    String YOUR_TOKEN = "your token";
    String word;
    String option;
    DictWord dictWord = new DictWord();
    OwlWord owlWord = new OwlWord();
    MuseWord museWord = new MuseWord();
    String option1 = "ml";
    String option2 = "sp";
    String option3 = "sl";
    String option4 = "rel_rhy";
    ArrayList<String> responses = new ArrayList<>();
    HashMap<Integer,OwlWord> additional = new HashMap<Integer, OwlWord>();

    public Answer(String word, String option) {
        this.word = word;
        this.option = option;
    }

    public static class StringResponse implements Callable<Object[]> {
        Invocation.Builder builder;
        int index;
        public StringResponse(Invocation.Builder b, int index) {
            this.builder = b;
            this.index = index;
        }

        public Object[] call() throws Exception {
            String result;
            try {
                result = this.builder.get(String.class);
            }catch (NotFoundException e){
                System.out.println("Not found exeption");
                return new Object[] {"Not found exeption",this.index};
            }catch (NotAuthorizedException e) {
                System.out.println("Not authorized");
                return new Object[] {"Not authorized",this.index};
            }
            return new Object[] {result,this.index};
        }
    }

    public void getInfo() throws ExecutionException, InterruptedException, JSONException {
        ExecutorService pool = Executors.newFixedThreadPool(3);
        Set<Future<Object[]>> set = new HashSet<Future<Object[]>>();


        URI baseURI1 = UriBuilder.fromUri("https://api.dictionaryapi.dev/api/v2/entries/en/").build();
        Client client1 = ClientBuilder.newClient();
        WebTarget target1 = client1.target(baseURI1);
        Invocation.Builder builder1 = target1.path(this.word).request().accept(MediaType.APPLICATION_JSON);
        Callable<Object[]> callable1 = new StringResponse(builder1, 1);


        URI baseURI2 = UriBuilder.fromUri("https://api.datamuse.com/").build();
        Client client2 = ClientBuilder.newClient();
        WebTarget target2 = client2.target(baseURI2);
        String museOption;
        if(this.option.equals("simMean")){
            museOption = option1;
        }
        else if(this.option.equals("simSpell")){
            museOption = option2;
        }
        else if(this.option.equals("simSound")){
            museOption = option3;
        }
        else {
            museOption = option4;
        }
        Invocation.Builder builder2 = target2.path("words").queryParam(museOption,this.word).request().accept(MediaType.APPLICATION_JSON);
        Callable<Object[]> callable2 = new StringResponse(builder2, 2);

        URI baseURI3 = UriBuilder.fromUri("https://owlbot.info/api/v4/dictionary/").build();
        Client client3 = ClientBuilder.newClient();
        WebTarget target3 = client3.target(baseURI3);
        Invocation.Builder builder3 = target3.path(this.word).request().header(HttpHeaders.AUTHORIZATION, "Token " + YOUR_TOKEN).accept(MediaType.APPLICATION_JSON);
        Callable<Object[]> callable3 = new StringResponse(builder3, 3);

        Future<Object[]> future1 = pool.submit(callable1);
        set.add(future1);
        Future<Object[]> future2 = pool.submit(callable2);
        set.add(future2);
        Future<Object[]> future3 = pool.submit(callable3);
        set.add(future3);

        for(Future<Object[]> future: set) {
            Object[] o = future.get();
            String s = (String) o[0];
            int index = (int) o[1];

            if(index == 1) {
                dictWord.parseWord(s);
            }
            else if(index == 2) {
                museWord.parseWord(s);
            }
            else if(index == 3) {
                owlWord.parseWord(s);
            }
        }

        pool.shutdown();

        ExecutorService pool2 = Executors.newFixedThreadPool(5);
        Set<Future<Object[]>> set2 = new HashSet<Future<Object[]>>();

        int i = 0;
        for(String m: museWord.words) {
            URI baseURI = UriBuilder.fromUri("https://owlbot.info/api/v4/dictionary/").build();
            Client client = ClientBuilder.newClient();
            WebTarget target = client.target(baseURI);
            Invocation.Builder builder = target.path(m).request().header(HttpHeaders.AUTHORIZATION, "Token " + YOUR_TOKEN).accept(MediaType.APPLICATION_JSON);
            Callable<Object[]> callable = new StringResponse(builder, i);
            Future<Object[]> future = pool2.submit(callable);
            set2.add(future);
            i++;
        }

        for(Future<Object[]> future: set2) {
            Object[] o = future.get();
            String s = (String) o[0];
            int index = (int) o[1];

            OwlWord owl = new OwlWord();
            owl.parseWord(s);
            additional.put(index,owl);
        }

        pool2.shutdown();


    }

    public void printWords() {
        dictWord.printWord();
        owlWord.printWord();
        museWord.printWords();
    }

    public Map<String, String> getMap() {
        Map<String,String> map = new HashMap<>();
        if (dictWord.error.equals("Not found exeption") || owlWord.error.equals("Not found exeption") || museWord.error.equals("Not found exeption")) {
            map.put("word", "Server was unable to find the word");
            map.remove("phon");
            map.remove("image");
            map.remove("word_def");
            return map;
        }
        if(dictWord.error.equals("Not authorized") || owlWord.error.equals("Not authorized") || museWord.error.equals("Not authorized")) {
            map.put("word", "You are not authorized to access the servers");
            return map;
        }
        map.put("word", dictWord.word);
        map.put("phon", dictWord.phonetic);
        String i = owlWord.getImageURL();
        String iURL;
        if(!i.equals("None")) {
            iURL = i;
        }
        else {
            iURL = "";
        }
        map.put("image",iURL);
        String definition = "";
        for(DictPart p: dictWord.partsOfSpeech){
            definition = definition + "<h2>" + p.name + "</h2>";
            for(DictDefinition d: p.definitions) {
                definition = definition + "<div class=\"def\">";
                definition = definition + "<div>" + d.definition + "</div>";
                if(!d.example.equals("")) {
                    definition = definition + "<div>" + "example: " + d.example + "</div>";
                }
                definition = definition + "</div>";
            }
        }
        //System.out.println(dictWord.phonetic);
        map.put("word_def", definition);
        if(this.option.equals("simMean")){
            map.put("add_title", "Words with similar meaning:");
        }
        else if(this.option.equals("simSpell")){
            map.put("add_title", "Words with similar spelling:");
        }
        else if(this.option.equals("simSound")){
            map.put("add_title", "Similar sounding words:");
        }
        else {
            map.put("add_title", "Rhymes:");
        }
        String mW ="";
        int j=0;
        for(String w: museWord.words) {
            mW =  mW + "<div><h3>" + w + "</h3></div>";
            OwlWord md = this.additional.get(j);
            if(md.error.equals("")){
                for(OwlDefinition od: md.definitions) {
                    mW = mW + "<div>" + od.definition +"</div>";
                }
            }
            j++;
        }
        map.put("additional",mW);
        return map;
    }

    public static void main(String[] args) throws JSONException, ExecutionException, InterruptedException {
        Answer a = new Answer("wolf", "rhyme");
        a.getInfo();
        a.printWords();
    }


}
