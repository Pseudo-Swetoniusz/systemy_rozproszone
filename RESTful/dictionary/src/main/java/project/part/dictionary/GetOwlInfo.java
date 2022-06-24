package project.part.dictionary;

import project.part.dictionary.utils.OwlWord;
import org.json.JSONException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class GetOwlInfo {

    public static void main(String[] args) throws JSONException {
        URI baseURI = UriBuilder.fromUri("https://owlbot.info/api/v4/dictionary/").build();
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(baseURI);

        String response  = target.path("zz").request().header(HttpHeaders.AUTHORIZATION, "Token " + "YOUR_TOKEN").accept(MediaType.APPLICATION_JSON).get(String.class);

        OwlWord word = new OwlWord();
        word.parseWord(response);
        word.printWord();

    }
}
