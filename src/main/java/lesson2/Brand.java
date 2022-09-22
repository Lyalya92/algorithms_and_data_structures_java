package lesson2;

public enum Brand {
    Lenuvo(0), Asos(1), MacNote(2), Eser(3), Xamiou(4);
    private int value;
    private Brand(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Brand getBrandName(int value) {
        return Brand.class.getEnumConstants()[value];
    }
}
