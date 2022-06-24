package project.part.dictionary.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MuseWord {
    public ArrayList<String> words = new ArrayList<>();
    int maxWordsNumber = 5;
    public String error = "";

    public MuseWord() {}

    private int countWords(String s) {
        String t = s.trim();
        if (t.isEmpty())
            return 0;
        return t.split("\\s+").length;
    }

    public void parseWord(String response) throws JSONException {
        if(response.equals("Not found exeption") || response.equals("Not authorized")) {
            error = response;
            return;
        }
        JSONArray array = new JSONArray(response);
        int m = this.maxWordsNumber;
        for(int i=0; i<array.length() && m > 0; i++) {
            JSONObject o = array.getJSONObject(i);
            String musew = o.getString("word");
            if(countWords(musew) == 1) {
                words.add(musew);
                m--;
            }
        }
    }

    public void printWords() {
        System.out.println("-----------------------------");
        for(String w: words) {
            System.out.println(w);
        }
        System.out.println("-----------------------------");
    }
}
