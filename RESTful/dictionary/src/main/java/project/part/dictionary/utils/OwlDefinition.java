package project.part.dictionary.utils;

public class OwlDefinition {
    public String definition;
    public String type;
    public String example;
    public String imageURL;
    public String emoji;

    public OwlDefinition(String d, String t, String ex, String i, String em) {
        this.definition = d;
        this.type = t;
        this.example = ex;
        this.imageURL = i;
        this.emoji = em;
    }
}