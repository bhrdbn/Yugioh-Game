package model;

public class Card {

    protected String name;
    protected int number;
    protected String cardType;
    protected String description;
    //protected ArrayList<Command> commands;
    protected boolean side=true;
    protected long price;
    private Location location;
    protected boolean isForbidden=false;
    protected int countInShop;
    public void setName(String name) {
        this.name = name;
    }

    public void setForbidden(boolean forbidden) {
        isForbidden = forbidden;
    }

    public int getCountInShop() {
        return countInShop;
    }

    public boolean isForbidden() {
        return isForbidden;
    }

    public void addCountInShop() {
        countInShop++;
    }
    public void decCountInShop() {
        countInShop--;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return cardType;
    }

    public void setType(String type) {
        this.cardType = type;
    }

    public String getCardDescription() {
        return description;
    }

    public void setCardDescription(String cardDescription) {
        this.description = cardDescription;
    }

    public Card(String name, int number, String type, String cardDescription, boolean side, long price) {
        this.name = name;
        this.number = number;
        this.cardType = type;
        this.description = cardDescription;
     //   this.commands = new ArrayList<>();
        this.side = true;
        this.price = price;
        countInShop=10;
    }

    public void setCountInShop(int countInShop) {
        this.countInShop = countInShop;
    }
    // public void run(PlayBoard playBoard,Card card){
  //      for (Command command:commands)
  //          command.doAction(GlobalVariable.getBoard());
  // }


    public boolean isSide() {
        return side;
    }

    public void setSide(boolean side) {
        this.side = side;
    }

    //public static ArrayList<Card> getAllCards() {
    //    return allCards;
    //}
//
    //public static void setAllCards(ArrayList<Card> allCards) {
    //    Card.allCards = allCards;
    //}

    public long getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


  //  private  static ArrayList<Card> allCards=new ArrayList<>();

    public String getName() {
        return name;
    }
  //  public static Card getCardByName(String name) {
  //      for(Card card:allCards){
  //          if(card.getName().equals(name))return card;
  //      }
  //      return null;
  //  }

    public void setLocation(Location location) {
        this.location = location;
    }
    public Location getLocation() {
        return location;
    }

   // public static boolean doesCardExist(String name) {
   //     for(Card card:allCards){
   //         if(card.getName().equals(name))return true;
   //     }
   //     return false;
   // }

    @Override
    public String toString() {
        return "Card{" +
                "card name : " + name +
                " cardDescription : " + description
                ;
    }
}
