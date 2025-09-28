//Lejla Goralija 230302198
//Imran Mujkanovic 230302177
//Ali-Harun Neimarlija 230302176

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LinkedList<Title> titleList = new LinkedList<>();

        // Adding popular music
        Music music1 = new Music("Shape of You", "Catchy pop song by Ed Sheeran", TitleType.NewRelease, "Ed Sheeran", "Ed Sheeran", 233, 1);
        titleList.add(music1);

        Music music2 = new Music("Bohemian Rhapsody", "Iconic rock anthem by Queen", TitleType.Normal, "Queen", "Freddie Mercury", 354, 1);
        titleList.add(music2);

        // Adding popular movies
        Movie movie1 = new Movie("Inception", "Mind-bending thriller directed by Christopher Nolan", TitleType.Promotional, "Christopher Nolan", "Leonardo DiCaprio, Joseph Gordon-Levitt", 148, 2010);
        titleList.add(movie1);

        Movie movie2 = new Movie("The Dark Knight", "Epic superhero film directed by Christopher Nolan", TitleType.Normal, "Christopher Nolan", "Christian Bale, Heath Ledger", 152, 2008);
        titleList.add(movie2);

        // Adding popular games
        Game game1 = new Game("The Witcher 3: Wild Hunt", "Open-world action RPG developed by CD Projekt Red", TitleType.NewRelease, "CD Projekt Red", 2015);
        titleList.add(game1);

        Game game2 = new Game("The Legend of Zelda: Breath of the Wild", "Open-world adventure game developed by Nintendo", TitleType.Promotional, "Nintendo", 2017);
        titleList.add(game2);

        // Displaying the linked list
        System.out.println("Title List:");
        for (Title title : titleList) {
            System.out.println(title);
        }

        // CREATE CATALOG
        Catalog catalog = new Catalog("SuperRentCatalog", titleList);

        Item item1 = new Item(game1);
        Item item2 = new Item(game2);
        Item item3 = new Item(movie1);
        Item item4 = new Item(movie2);
        Item item5 = new Item(music1);
        Item item6 = new Item(music2);


        // Create linked lists
        List<Item> itemList1 = new LinkedList<>();
        itemList1.add(item1);
        itemList1.add(item2);
        itemList1.add(item3);

        List<Item> itemList2 = new LinkedList<>();
        itemList2.add(item4);
        itemList2.add(item5);
        itemList2.add(item6);

        List<Store> stores = new LinkedList<>();
        Store store1 = new Store("Game Haven", "Ilidza", "+387 1234567890", "Dzeno Smajo", itemList1);
        Store store2 = new Store("Cinema Central", "Grbavica", "+387 0987654321", "Musa Kulen", itemList2);
        stores.add(store1);
        stores.add(store2);

        List<Member> members = new LinkedList<>();
        // Create and add four members
        Member member1 = new Member("M1", "Adna", "Sarajevo", "+38761234567");
        Member member2 = new Member("M2", "Aldin", "Banja Luka", "+38761234568");
        Member member3 = new Member("M3", "Emina", "Tuzla", "+38761234569");
        Member member4 = new Member("M4", "Haris", "Zenica", "+38761234570");

        members.add(member1);
        members.add(member2);
        members.add(member3);
        members.add(member4);

        SuperRent superRent = new SuperRent(catalog, stores, members);

        // Displaying the linked list of titles
        System.out.println("Title List:");
        for (Title title : titleList) {
            System.out.println(title);
        }

        // Create rental
        try {
            List<Item> firstRental = new LinkedList<>();
            firstRental.add(item1);
            firstRental.add(item2);
            firstRental.add(item3);

            superRent.createRental(firstRental, store1, member1, new Date(101, 0, 1));
        } catch (NullPointerException e) {
            System.out.println("Error creating rental: " + e.getMessage());
        }


        // Return rental
        try {
            superRent.returnRental(superRent.getRentals().get(0), store1, new Date(104, 0, 4));
        } catch (NullPointerException e) {
            System.out.println("Error returning rental: " + e.getMessage());
        }
    }
}



