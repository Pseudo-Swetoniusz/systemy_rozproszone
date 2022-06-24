package project.part.dictionary.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class OwlWord {
    public ArrayList<OwlDefinition> definitions = new ArrayList<>();
    public String error = "";

    public OwlWord() {}

    public void parseWord(String response) throws JSONException {
        if(response.equals("Not found exeption") || response.equals("Not authorized")) {
            error = response;
            return;
        }
        JSONObject words = new JSONObject(response);
        JSONArray array = words.getJSONArray("definitions");
        for(int i=0; i<array.length(); i++) {
            JSONObject obj = array.getJSONObject(i);
            String definition = obj.getString("definition");
            String type = obj.getString("type");
            String emoji = obj.getString("emoji");
            String imageURL = obj.getString("image_url");
            String example = obj.getString("example");
            OwlDefinition def = new OwlDefinition(definition,type,example,imageURL,emoji);
            this.definitions.add(def);
        }
    }

    public String getImageURL() {
        String result;
        for(OwlDefinition def: definitions) {
            if(!def.imageURL.equals("null")) {
                result = def.imageURL;
                return result;
            }
        }
        return "None";
    }

    public void printWord() {
        for(OwlDefinition def: definitions) {
            System.out.println("_________________________________________________");
            System.out.println("TYPE: " + def.type);
            System.out.println("DEFINITION: " + def.definition);
            System.out.println("EXAMPLE: " + def.example);
            System.out.println("EMOJI: " + def.emoji);
            System.out.println("IMAGE: " + def.imageURL);
            System.out.println("_________________________________________________");
        }
    }
}
