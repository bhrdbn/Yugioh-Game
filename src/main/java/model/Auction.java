package model;

import java.util.ArrayList;

public class Auction {
    private Player seller;
    private int time;
    private Player customer;
    private int price;
    private Card card;
    private int id;
    private static int lastId=1;
    private static ArrayList<Auction>auctions=new ArrayList<>();
    private boolean active;

    public Auction(int  price,Player player,Card card){
        setSeller(player);
        setPrice(price);
        setTime(300);
        setId(lastId);
        setCard(card);
        auctions.add(this);
        lastId++;
        active=true;
    }
    public static Auction getAuctionById(int id){
        for (Auction auction : auctions) {
            if(auction.getId()==id)return auction;
        }
        return null;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setSeller(Player seller) {
        this.seller = seller;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setCustomer(Player customer) {
        this.customer = customer;
    }

    public int getTime() {
        return time;
    }
    public int getPrice() {
        return price;
    }

    public Player getCustomer() {
        return customer;
    }

    public Player getSeller() {
        return seller;
    }

    @Override
    public String toString() {
        return "id: " +id+" { "+
                "seller=" + seller.getUsername() +
                ", time=" + time +
                "\n, final price=" + price +
                ", card=" + card.getName()+
                "}";
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public static ArrayList<Auction> getAuctions() {
        return auctions;
    }

    public boolean getActive() {
        return active;
    }
}
