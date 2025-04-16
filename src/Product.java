import java.util.ArrayList;

public class Product {
    private String name, category, activity;
    private ArrayList<Rating> ratings = new ArrayList<>();

    public Product(String name, String activity, String category){
        this.name = name;
        this.category = category;
        this.activity = activity;
    }

    public String getCategory() {
        return category;
    }
    public String getActivity(){
        return activity;
    }
    public String getName(){
        return name;
    }
    public void addRating(String user, int stars, String comment){
        Rating rating = new  Rating(name, user, stars, comment);
        ratings.add(rating);
    }
    public ArrayList<Rating> getRatings(){
        return ratings;
    }
}



