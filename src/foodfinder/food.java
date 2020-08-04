
package foodfinder;

/**
 *
 * @author Porosh
 */
public class food {

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
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the food_name
     */
    public String getFood_name() {
        return food_name;
    }

    /**
     * @param food_name the food_name to set
     */
    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    /**
     * @return the seller_id
     */
    public int getSeller_id() {
        return seller_id;
    }

    /**
     * @param seller_id the seller_id to set
     */
    public void setSeller_id(int seller_id) {
        this.seller_id = seller_id;
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
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }

     private int id;
     private String food_name;
     private int seller_id;
     private float rating;
     private int price;
     private int count = 0;
    
    public food (int id, String food_name, int seller_id , float rating , int price)
    {
        this.id = id;
        this.food_name = food_name;
        this.seller_id = seller_id;
        this.rating = rating;
        this.price = price;
        this.count++;
    }
    public food(){};
}
