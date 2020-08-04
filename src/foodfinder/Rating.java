
package foodfinder;

/**
 *
 * @author Porosh
 */
public class Rating {

    Rating(int id, float rating, int count, String re) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * @return the food_id
     */
    public int getFood_id() {
        return food_id;
    }

    /**
     * @param food_id the food_id to set
     */
    public void setFood_id(int food_id) {
        this.food_id = food_id;
    }

    /**
     * @return the rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * @param rating the rating to set
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * @return the review
     */
    public String getReview() {
        return review;
    }

    /**
     * @param review the review to set
     */
    public void setReview(String review) {
        this.review = review;
    }
    private int food_id;
    private float rating;
    private int count;
    private String review;
    public void Rating(int food_id ,float rating , String review)
    {
        this.food_id = food_id;
        this.rating = rating;
        this.review = review;
        this.count++;
    }
    public void Rating(){};
}
