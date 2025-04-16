public class Rarting {
    final private String productName, user, comment;
    final private int numberOfStars;
    public Rarting(String productName, String user, int numberOfStars, String comment){
        this.productName = productName;
        this.user = user;
        this.numberOfStars = numberOfStars;
        this.comment = comment;
    }

    public String getProductName() {
        return productName;
    }

    public String getUser() {
        return user;
    }

    public String getComment() {
        return comment;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }
}
