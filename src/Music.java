//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

public class Music extends Title {
    private final String producer;
    private final String singer;
    private final int duration;
    private final int tracks;

    public Music(String name, String description, TitleType type, String producer, String singer, int duration, int tracks) {
        super(name, description, type);
        this.producer = producer;
        this.singer = singer;
        this.duration = duration;
        this.tracks = tracks;
    }

    @Override
    public double getCharge() {
        return 4;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Music{" +
                "producer='" + producer + '\'' +
                ", singer='" + singer + '\'' +
                ", duration=" + duration +
                ", tracks=" + tracks +
                ", cost=" + 5 +
                '}';
    }
}
