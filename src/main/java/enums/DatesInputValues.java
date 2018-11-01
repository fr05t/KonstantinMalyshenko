package enums;

public enum DatesInputValues {

    STEP6_LEFT_SLIDER_VALUE(0),
    STEP6_RIGHT_SLIDER_VALUE(100),

    STEP8_RIGHT_SLIDER_VALUE(0),
    STEP8_LEFT_SLIDER_VALUE(0),

    STEP10_RIGHT_SLIDER_VALUE(100),
    STEP10_LEFT_SLIDER_VALUE(100),

    STEP12_RIGHT_SLIDER_VALUE(70),
    STEP12_LEFT_SLIDER_VALUE(30);


    private int value;

    DatesInputValues(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }

    public String getStringValue() {
        return "" + value;
    }

}
