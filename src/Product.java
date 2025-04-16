public class Product {
    private String name, category, activity;

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
}



