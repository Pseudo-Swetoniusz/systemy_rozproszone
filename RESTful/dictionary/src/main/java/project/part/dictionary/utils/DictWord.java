package project.part.dictionary.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;

public class DictWord {

    public String word;
    public String phonetic;
    public ArrayList<DictPart> partsOfSpeech = new ArrayList<>();
    ArrayList<String> IPA = new ArrayList<String>(Arrays.asList("ʒ", "ð", "ŋ", "ʃ", "θ", "ʔ", "ɜ", "ɑ", "ɒ", "æ", "ɪ", "ʊ", "ɛ", "ɔ", "ʌ", "ə", "ː", "ɹ", "ɡ"));
    ArrayList<String> IPAnumeric = new ArrayList<String>(Arrays.asList("&#658;","&#240;", "&#331;", "&#643;", "&#952;", "&#660;", "&#604;", "&#593;", "&#594;", "&#230;", "&#618;", "&#650;", "&#603", "&#596;", "&#652;", "&#601;", "&#720", "&#692", "&#609;"));
    public String error = "";
    public DictWord() {}

    public void replaceIPA() {
        int l = IPA.size();
        for(int i=0; i<l; i++) {
            this.phonetic = phonetic.replace(IPA.get(i),IPAnumeric.get(i));
        }
    }

    public void parseWord(String response) throws JSONException {
        //System.out.println(response);
        if(response.equals("Not found exeption") || response.equals("Not authorized")) {
            error = response;
            return;
        }
        JSONArray ar = new JSONArray(response);
        JSONObject obj = ar.getJSONObject(0);
        this.word = obj.optString("word");
        this.phonetic = obj.optString("phonetic");
        replaceIPA();
        JSONArray array = obj.getJSONArray("meanings");
        for(int i=0; i<array.length(); i++) {
            JSONObject o = array.getJSONObject(i);
            //System.out.println("O " + o);
            String pOS = o.optString("partOfSpeech");
            DictPart dict = new DictPart(pOS);
            JSONArray defs = o.getJSONArray("definitions");
            for (int j=0; j<defs.length(); j++) {
                JSONObject ob = defs.getJSONObject(j);
                //System.out.println(ob);
                String def = ob.optString("definition");
                String ex = ob.optString("example");
                dict.addDefinition(def,ex);
            }
            partsOfSpeech.add(dict);
        }
    }

    public void printWord() {
        System.out.println("WORD: " + this.word);
        System.out.println("PHONETIC: " + this.phonetic);
        for(DictPart d: partsOfSpeech) {
            d.printDefinitons();
        }
    }
}
