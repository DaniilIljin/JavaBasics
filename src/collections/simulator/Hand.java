package collections.simulator;
import java.util.*;

public class Hand implements Iterable<Card>, Comparable<Hand> {

    private List<Card> cards = new ArrayList<>();
    private HandType hand = null;
    private List<Card.CardValue> strongestCard = new ArrayList<>();

    public List<Card.CardValue> getStrongestCard(){
        hand = getHandType();
        return strongestCard;
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    @Override
    public String toString() {
        return cards.toString();
    }

    /**
     * Function getHandType() puts hand`s cards through functions, which check
     * if it is possible to make a strong combination from them. Therefore, this process starts
     * from the strongest combination. if during checking combination won`t be found, each checking
     * function will return HandType.HIGH_CARD, because it is the weakest combination.
     */
    public HandType getHandType() {
        HandType type;
        type = checkStraightFlush(cards);
        // If HandType remained HIGH_CARD, this will tell further functions to check it,
        // but if type has changed, others functions won`t change it.
        if (type == HandType.HIGH_CARD){
            type = checkFourOfAKind(cards);
        }
        if (type == HandType.HIGH_CARD){
            type = checkFullHouse(cards);
        }
        if (type == HandType.HIGH_CARD){
            type = checkFlush(cards);
        }
        if (type == HandType.HIGH_CARD){
            type = checkStraight(cards);
        }
        if (type == HandType.HIGH_CARD){
            type = checkTrips(cards);
        }
        if (type == HandType.HIGH_CARD){
            type = checkPairs(cards);
        }
        if(type == HandType.HIGH_CARD){
            Card strongestCard = cards.get(0);
            for (int i = 1; i < cards.size(); i++) {
                if (strongestCard.getValue().ordinal() < cards.get(i).getValue().ordinal()){
                    strongestCard = cards.get(i);
                }
            }
            this.strongestCard.add(strongestCard.getValue());
        }
        return type;
    }

    public HandType checkPairs(List<Card> cards){
        int totalPairs = 0;
        for (Card card : cards) {
            int counter = 0;
            Card.CardValue value = card.getValue();
            for (Card currentCard: cards) {
               if (value == currentCard.getValue()){
                   counter++;
               }
            }
            if (counter % 2 == 0){
                totalPairs++;
                strongestCard.add(value);
            }
        }
        // The counter will be twice bigger than the number of actual pairs,
        // because it repeats the same comparing with each element, that means elements from pair will give to counter +2
        // But still the number totalPairs will be even, so if it will be equal to 4, then there is 2 pairs, if 2 - 1 pair.
        if (totalPairs == 4){
            return HandType.TWO_PAIRS;
        } else if (totalPairs == 2){
            return HandType.ONE_PAIR;
        } else {
            return HandType.HIGH_CARD;
        }
    }

    public HandType checkTrips(List<Card> cards){
        for (Card card : cards) {
            int counter = 0;
            Card.CardValue value = card.getValue();
            for (Card currentCard: cards) {
                if (value == currentCard.getValue()){
                    counter++;
                }
            }
            //if function will count 3 elements of the same value, it will immediately return HandType.TRIPS
            if (counter == 3){
                strongestCard.add(value);
                return HandType.TRIPS;
            }
        }
        return HandType.HIGH_CARD;
    }

    public HandType checkFullHouse(List<Card> cards){
        // This function and also checkStraightFlush just will use two other checking functions at the same time.
        if(checkTrips(cards) == HandType.TRIPS && checkPairs(cards) == HandType.ONE_PAIR){
            return HandType.FULL_HOUSE;
        }
        return HandType.HIGH_CARD;
    }
    
    public HandType checkFourOfAKind(List<Card> cards){
        for (Card card : cards) {
            int counter = 0;
            Card.CardValue value = card.getValue();
            for (Card currentCard: cards) {
                if ( value == currentCard.getValue()){
                    counter++;
                }
            }
            if (counter == 4){
                strongestCard.add(value);
                return HandType.FOUR_OF_A_KIND;
            }
        }
        return HandType.HIGH_CARD;
    }

    public HandType checkStraight(List<Card> cards){
        int counter = 1;
        int a, b;
        for (int i = 0; i < cards.size(); i++) {
            a = cards.get(i).getValue().ordinal();
            try {
                b = cards.get(i + 1).getValue().ordinal();
            }catch (IndexOutOfBoundsException e){
                break;
            }
            if (cards.get(i).getValue() == Card.CardValue.A){
                if(i == 0 && b == 0){
                    counter++;
                }
            } else if (b - a == 1){
                counter++;
            }
            if(counter == 5){
                strongestCard.add(cards.get(i).getValue());
                return HandType.STRAIGHT;
            }
        }
        return HandType.HIGH_CARD;
    }

    public HandType checkFlush(List<Card> cards){
        for (Card card : cards) {
            int counter = 0;
            Card.CardSuit value = card.getSuit();
            for (Card currentCard: cards) {
                if ( value == currentCard.getSuit()){
                    counter++;
                }
                if (counter % 5 == 0){
                    strongestCard.add(card.getValue());
                    return HandType.FLUSH;
                }
            }
        }
        return HandType.HIGH_CARD;
    }

    public HandType checkStraightFlush(List<Card> cards){
        if(checkFlush(cards) == HandType.FLUSH && checkStraight(cards) == HandType.STRAIGHT){
            return HandType.STRAIGHT_FLUSH;
        }
        return HandType.HIGH_CARD;
    }

    public boolean contains(Card card) {
        return cards.contains(card);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    @Override
    public Iterator<Card> iterator() {
        return cards.iterator();
    }

    @Override
    public int compareTo(Hand other) {
        return 0;
    }
}
