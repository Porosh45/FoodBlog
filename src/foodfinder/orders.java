/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodfinder;

/**
 *
 * @author Porosh
 */
public class orders
{
    public boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(boolean status) {
        this.status = status;
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
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

   
    public orders(int id,int user_id,int seller_id,int food_id,int quantity,int price)
    {
        this.id = id;
        this.user_id = user_id;
        this.seller_id = seller_id;
        this.food_id = food_id;
        this.quantity = quantity;
        this.price = price;
        this.status = false;
    }
        private int id;
        private int user_id;
        private int seller_id;
        private int food_id;
        private int quantity;
        private int price;
        private boolean status; 
    
    public void orders(){};
}
