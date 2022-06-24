package project.part.dictionary;

import project.part.dictionary.utils.DictWord;
import org.json.JSONException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class GetDictWord {
    public static void main(String[] args) throws JSONException {
        URI baseURI = UriBuilder.fromUri("https://api.dictionaryapi.dev/api/v2/entries/en/").build();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURI);

        String response = target.path("frog").request().accept(MediaType.APPLICATION_JSON).get(String.class);
        DictWord word = new DictWord();
        word.parseWord(response);
        word.printWord();

    }
}
