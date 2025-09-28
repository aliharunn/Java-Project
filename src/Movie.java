//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

public class Movie extends Title {
    private final String director;
    private final String cast;
    private final int duration;
    private final int yearOfRelease;

    public Movie(String name, String description, TitleType type, String director, String cast, int duration, int yearOfRelease) {
        super(name, description, type);
        this.director = director;
        this.cast = cast;
        this.duration = duration;
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public double getCharge() {
        return 5;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Movie{" +
                "director='" + director + '\'' +
                ", cast='" + cast + '\'' +
                ", duration=" + duration +
                ", yearOfRelease=" + yearOfRelease +
                ", cost=" + 5 +
                '}';
    }
}
