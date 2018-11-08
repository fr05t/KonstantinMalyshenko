package io.github.epam.jdi.enums;

public enum Odds {
    One(1), Three(3), Five(5), Seven(7);

    public int value;

    Odds(int value) {
        this.value = value;
    }
}
