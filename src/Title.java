//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

public abstract class Title {
    private static int rentalCodeCounter = 0;
    private final int rentalCode;
    private final String name;
    private final String description;
    private final TitleType type;

    public Title(String name, String description, TitleType type) {
        this.rentalCode = ++rentalCodeCounter;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public abstract double getCharge();

    public int getRentalLength() {
        return switch (type) {
            case NewRelease -> 5;
            case Promotional -> 10;
            case Normal -> 14;
        };
    }

    public int getRentalCode() {
        return this.rentalCode;
    }

    @Override
    public String toString() {
        return "Title{" +
                "rentalCode=" + rentalCode +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                '}';
    }
}
