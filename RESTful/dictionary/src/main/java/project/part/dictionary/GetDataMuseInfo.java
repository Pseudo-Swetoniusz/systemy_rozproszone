package project.part.dictionary;

import project.part.dictionary.utils.MuseWord;
import org.json.JSONException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class GetDataMuseInfo {
    public static void main(String[] args) throws JSONException {
        URI baseURI = UriBuilder.fromUri("https://api.datamuse.com/").build();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURI);
        String path = "words";
        String word = "wolf";
        String option1 = "ml";
        String option2 = "sp";
        String option3 = "sl";
        String option4 = "rel_rhy";
        String response = target.path(path).queryParam(option1,word).request().accept(MediaType.APPLICATION_JSON).get(String.class);
        Invocation.Builder b = target.path(path).queryParam(option1,word).request().accept(MediaType.APPLICATION_JSON);
        MuseWord muse = new MuseWord();
        muse.parseWord(response);
        muse.printWords();

    }
}
