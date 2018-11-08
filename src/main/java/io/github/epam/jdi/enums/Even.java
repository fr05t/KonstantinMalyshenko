package io.github.epam.jdi.enums;

public enum Even {
    Two(2), Four(4), Six(6), Eight(8);

    public int value;

    Even(int value) {
        this.value = value;
    }
}
