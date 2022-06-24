package project.part.dictanswer;

import org.glassfish.jersey.server.mvc.Viewable;
import org.json.JSONException;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

@Path("/answer")
public class ServerResources {
    @Context
    UriInfo uriInfo;
    @Context
    Response response;

    public static Map<String, String> model = new HashMap<>();

    @GET
    @Produces(MediaType.TEXT_HTML)
    public Viewable answer() {
        //Map<String, String> model = new HashMap<>();
        //model.put("hello", "Hello");
        //model.put("world", "World");
        System.out.println("open");
        for (Map.Entry<String,String> entry : model.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
        Map<String, String> new_model = new HashMap<>(this.model);
        return new Viewable("/answer.jsp", new_model);
    }

    @POST
    //@Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void change(@FormParam("word") String word, @FormParam("options") String value, @Context HttpServletResponse servletResponse) throws IOException, JSONException, ExecutionException, InterruptedException {
        try {
            Answer answer = new Answer(word, value);
            answer.getInfo();
            HashMap<String, String> map = (HashMap<String, String>) answer.getMap();
            model.clear();
            model.putAll(map);
            System.out.println(word);
            servletResponse.sendRedirect("../info/answer");
        } catch(Exception e) {
            model.put("word", "Server error");
        }
    }
}