package project.part.dictionary.utils;

import java.util.ArrayList;

public class DictPart {
    public String name;
    public ArrayList<DictDefinition> definitions = new ArrayList<>();

    public DictPart(String name) {
        this.name = name;
    }

    public void addDefinition(String d, String e) {
        DictDefinition def = new DictDefinition(d, e);
        definitions.add(def);
    }

    public void printDefinitons() {
        System.out.println("----------------------------------------");
        System.out.println("PART OF SPEECH: " + this.name);
        System.out.println("DEFINITIONS");
        for(DictDefinition d: definitions) {
            d.printDefinition();
        }
    }
}
