//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176


public class Game extends Title {
    public final String producer;
    public final int year;

    public Game(String name, String description, TitleType type, String producer, int year) {
        super(name, description, type);
        this.producer = producer;
        this.year = year;
    }

    @Override
    public double getCharge() {
        return 10;
    }

    @Override
    public String toString() {
        return super.toString() + "Game{" +
                "producer='" + producer + '\'' +
                ", year=" + year +
                ", cost=" + 10 +
                '}';
    }
}
