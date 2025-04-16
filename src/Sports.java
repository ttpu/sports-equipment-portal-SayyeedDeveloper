import java.util.*;

/**
 * Facade class for the research evaluation system
 *
 */
public class Sports {
    final private List<String> listOfActivities = new ArrayList<>();
    final private HashMap<String, List<String>> categories = new HashMap<>();
    final private HashMap<String, Product> products = new HashMap<>();

    //R1
    /**
     * Define the activities types treated in the portal.
     * The method can be invoked multiple times to add different activities.
     *
     * @param activities names of the activities
     * @throws SportsException thrown if no activity is provided
     */
    public void defineActivities (String... activities) throws SportsException {
        if (activities.length == 0){
            throw new SportsException();
        }
        for(String activity : activities){
            if (listOfActivities.contains(activity)){
                throw new SportsException();
            }
            listOfActivities.add(activity);
        }
    }


    /**
     * Retrieves the names of the defined activities.
     *
     * @return activities names sorted alphabetically
     */
    public List<String> getActivities() {
        ArrayList<String> result = new ArrayList<>(listOfActivities);
        Collections.sort(result);
        return result;
    }


    /**
     * Add a new category of sport products and the linked activities
     *
     * @param name name of the new category
     * @param linkedActivities reference activities for the category
     * @throws SportsException thrown if any of the specified activity does not exist
     */
    public void addCategory(String name, String... linkedActivities) throws SportsException {
        for(String activity: linkedActivities){
            if (!listOfActivities.contains(activity)) {
                throw new SportsException();
            }
        }
        categories.put(name, List.of(linkedActivities));
    }

    /**
     * Retrieves number of categories.
     *
     * @return categories count
     */
    public int countCategories() {
        return categories.size();
    }

    /**
     * Retrieves all the categories linked to a given activity.
     *
     * @param activity the activity of interest
     * @return list of categories (sorted alphabetically)
     */
    public List<String> getCategoriesForActivity(String activity) {
        ArrayList<String> result = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : categories.entrySet()){
            if (entry.getValue().contains(activity)) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }

    //R2
    /**
     * Add a research group and the relative disciplines.
     *
     * @param name name of the research group
     * @param activityName list of disciplines
     * @throws SportsException thrown in case of duplicate name
     **/
    public void addProduct(String name, String activityName, String categoryName) throws SportsException {
        if (products.containsKey(name)){
            throw new SportsException();
        }
        Product product = new Product(name, activityName, categoryName);
        products.put(name, product);
    }

    /**
     * Retrieves the list of products for a given category.
     * The list is sorted alphabetically.
     *
     * @param categoryName name of the category
     * @return list of products
     *
     *     Map <String, Product> products = new TreeMap<>();
     */
    public List<String> getProductsForCategory(String categoryName){
        if(!categories.containsKey(categoryName)){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        for(Product product: products.values()){
            if(categoryName.equals(product.getCategory())){
                result.add(product.getName());
            }
        }
        Collections.sort(result);
        return  result;
    }

    /**
     * Retrieves the list of products for a given activity.
     * The list is sorted alphabetically.
     *
     * @param activityName name of the activity
     * @return list of products
     */
    public List<String> getProductsForActivity(String activityName){
        if(!listOfActivities.contains(activityName)){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        for(Product product: products.values()){
            if (activityName.equals(product.getActivity())) {
                result.add(product.getName());
            }
        }
        Collections.sort(result);
        return result;
    }
    /**
     * Retrieves the list of products for a given activity and a set of categories
     * The list is sorted alphabetically.
     *
     * @param activityName name of the activity
     * @param categoryNames names of the categories
     * @return list of products
     */
    public List<String> getProducts(String activityName, String... categoryNames){
        if(!listOfActivities.contains(activityName)){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        for (Product product: products.values()){
            if(activityName.equals(product.getActivity()) && new ArrayList<>(List.of(categoryNames)).contains(product.getCategory())){
                result.add(product.getName());
            }
        }
        Collections.sort(result);
        return result;
    }

    //R3
    /**
     * Add a new product rating
     *
     * @param productName name of the product
     * @param userName name of the user submitting the rating
     * @param numStars score of the rating in stars
     * @param comment comment for the rating
     * @throws SportsException thrown numStars is not correct
     */
    public void addRating(String productName, String userName, int numStars, String comment) throws SportsException {
        if(numStars < 0 || numStars > 5){
            throw new SportsException();
        }
        products.get(productName).addRating(userName, numStars, comment);
    }

    /**
     * Retrieves the ratings for the given product.
     * The ratings are sorted by descending number of stars.
     *
     * @param productName name of the product
     * @return list of ratings sorted by stars
     */
    public List<String> getRatingsForProduct(String productName) {
        if(products.get(productName).getRatings().isEmpty()){
            return new ArrayList<>();
        }
        ArrayList<String> result = new ArrayList<>();
        for (Rarting rating: products.get(productName).getRatings()){
            result.add(String.format("%d : %s", rating.getNumberOfStars(), rating.getComment()));
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }


    //R4
    /**
     * Returns the average number of stars of the rating for the given product.
     *
     *
     * @param productName name of the product
     * @return average rating
     */
    public double getStarsOfProduct (String productName) {
        return 0;
    }

    /**
     * Computes the overall average stars of all ratings
     *
     * @return average stars
     */
    public double averageStars() {
        return 0;
    }

    //R5 Statistiche
    /**
     * For each activity return the average stars of the entered ratings.
     *
     * Activity names are sorted alphabetically.
     *
     * @return the map associating activity name to average stars
     */
    public SortedMap<String, Double> starsPerActivity() {
        return null;
    }

    /**
     * For each average star rating returns a list of
     * the products that have such score.
     *
     * Ratings are sorted in descending order.
     *
     * @return the map linking the average stars to the list of products
     */
    public SortedMap<Double, List<String>> getProductsPerStars () {
        return null;
    }

}