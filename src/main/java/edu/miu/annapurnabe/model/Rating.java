package edu.miu.annapurnabe.model;

import java.util.HashMap;

/**
 * @author bijayshrestha on 7/9/22
 * @project annapurna-be
 */
public enum Rating {
    WOW ("Wow!"),
    GOOD("Good"),
    NAH("Nah.."),
    BAD("Bad");

    private static final HashMap<String, Rating> MAP = new HashMap<String, Rating>();

    private String value;

    private Rating(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public static Rating getByName(String name) {
        return MAP.get(name);
    }

    static {
        for (Rating field : Rating.values()) {
            MAP.put(field.getValue(), field);
        }
    }

    public static Boolean findByValue(String value) {
        for (Rating rating : values()) {
            if (rating.getValue().equalsIgnoreCase(value)) {
                return true;
            }
        }
        return false;
    }
}
