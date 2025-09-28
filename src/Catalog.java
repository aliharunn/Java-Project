//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

import java.util.List;

public class Catalog {

    private final String name;
    private final List<Title> titleList;

    public Catalog(String catalogName, List<Title> titles) throws NullPointerException {
        if (titles == null) {
            throw new NullPointerException("Error in Catalog constructor, null pointer error");
        } else {
            this.name = catalogName;
            this.titleList = titles;
        }
    }

    public void addTitle(Title newTitle) {
        titleList.add(newTitle);
    }

    public boolean removeTitle(Title oldTitle) {
        //delete Items of Title?
        if (titleList.remove(oldTitle)) {
            System.out.println("Item removed from Catalog successfully! ");
            return true;
        } else {
            System.out.println("Title not found in Catalog, error ");
            return false;
        }
    }

    public List<Title> getTitleList() {
        return this.titleList;
    }

    @Override //fix if bad
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", titleList=" + titleList +
                '}';
    }
}
