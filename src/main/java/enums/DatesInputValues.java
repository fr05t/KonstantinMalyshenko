package enums;

public enum DatesInputValues {

    STEP6_SET(new int[]{0, 100}),
    STEP8_SET(new int[]{0, 0}),
    STEP10_SET(new int[]{100, 100}),
    STEP12_SET(new int[]{30, 70});

    private int[] value;

    DatesInputValues(int[] value) {
        this.value = value;
    }

    public int[] getValue() {
        return value;
    }
}
