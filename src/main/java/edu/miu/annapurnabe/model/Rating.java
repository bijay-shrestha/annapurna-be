package edu.miu.annapurnabe.model;

/**
 * @author bijayshrestha on 7/9/22
 * @project annapurna-be
 */
public enum Rating{
    WOW ("Wow!"),
    GOOD("Good"),
    NAH("Nah.."),
    BAD("Bad");

    public final String label;
    private Rating(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
