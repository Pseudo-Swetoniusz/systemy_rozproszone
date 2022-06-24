package project.part.dictionary.utils;

public class DictDefinition {
    public String definition;
    public String example;

    public DictDefinition(String d, String e) {
        this.definition = d;
        this.example = e;
    }

    public void printDefinition() {
        System.out.println("---------------------------");
        System.out.println("DEFINITION: " + this.definition);
        System.out.println("EXAMPLE: " + this.example);
        System.out.println("---------------------------");
    }
}
