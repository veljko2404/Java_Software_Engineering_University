package exercises.zad14;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/*
U fajlu podaci.dat se nalaze korisnicke ocene filmova. Fajl je ured¯en na sledeci
nacin:
• prvi red predstavlja korisnicko ime korisnika,
• drugi red predstavlja naziv filma,
• treci red predstavlja ocenu koju je dao korisnik tom filmu 1 − 5
• cetvrti red je prazan;
Program treba da izvrsi sledeci zadatak:
Za uneto korisniko ime treba da izbaci spisak svih filmova koje je taj korisnik ocenio i
prosecnu ocenu koju je dao.
Za unet naziv filma program treba da ottampa spisak svih korisnika i prosecnu ocenu koju
je dobio taj film.
Za unetu komandu ”top10” treba da izbaci 10 ili manje filmova koji su dobili najvecu
prosecnu ocenu.
*/
public class main {
    public static void main(String[] args) throws FileNotFoundException {
        HashMap<String, HashMap<String, Integer>> data = new HashMap<>();
        URL url = main.class.getResource("podaci.dat");
        File file = new File(url.getPath());
        Scanner scanner = new Scanner(file);

        while (scanner.hasNext()) {
            String user = scanner.nextLine();
            String movie = scanner.nextLine();
            int rating = Integer.parseInt(scanner.nextLine());
            scanner.nextLine();
            if (data.containsKey(user)) {
                data.put(user, new HashMap<String, Integer>());
                HashMap<String, Integer> dataUser = data.get(user);
                dataUser.put(movie, rating);
            }
        }

        String input = "korisnik1";
        HashMap<String, Integer> inputUser = data.get(input);
        double avgRating = 0.0;
        int numOfMovies = 0;
        Iterator<String> iterator = inputUser.keySet().iterator();
        while (iterator.hasNext()) {
            String movie = iterator.next();
            int rating = inputUser.get(movie);
            System.out.println(STR."Movie: \{movie}: \{rating}");
            avgRating += rating;
            numOfMovies++;
        }
        avgRating /= numOfMovies;
        System.out.println(STR."Avg rating is: \{avgRating}");

        String movie = "film1";
        avgRating = 0.0;
        numOfMovies = 0;
        Iterator<String> userIterator = data.keySet().iterator();
        while (userIterator.hasNext()) {
            input = userIterator.next();
            inputUser = data.get(userIterator.next());
            if (inputUser.containsKey(movie)) {
                numOfMovies++;
                avgRating += inputUser.get(movie);
            }
        }
        avgRating /= numOfMovies;
        System.out.println(STR."User: \{avgRating}");
    }
}
