package uk.co.gfk;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public String playGame() {
        String ret = "TODO";
        System.out.println(ret);

        //TODO: high-level check number of cards vs resources required

        //Test 1 - happy path
        String[] inputCards = {"W", "W", "S", "S"};
        String inputWonders = "WWSS";
        processCards(inputCards, inputWonders);

        //Test 2 - shuffled cards
        String[] inputCards2 = {"W", "S", "W", "S"};
        String inputWonders2 = "WWSS";
        processCards(inputCards2, inputWonders2);

        //Test 3 - negative (not enough cards)
        String[] inputCards3 = {"W", "S", "W"};
        String inputWonders3 = "WWSS";
        processCards(inputCards3, inputWonders3);

        //Test 4 - mismatched resources
        String[] inputCards4 = {"W", "S", "O", "B"};
        String inputWonders4 = "WWSS";
        processCards(inputCards4, inputWonders4);

        //Test 5 - input card has multiple resources
        /*String[] card1 = {"W", "B"};
        String[] card2 = {"W"};
        String[] card3 = {"S"};
        String[] card4 = {"S"};*/
        List<String> card1 = new ArrayList<>();
        card1.add("W");
        card1.add("B");
        List<String> card2 = new ArrayList<>();
        card2.add("W");
        List<String> card3 = new ArrayList<>();
        card3.add("S");
        List<String> card4 = new ArrayList<>();
        card4.add("S");
        List<List<String>> inputCards5b = new ArrayList<>();
        inputCards5b.add(card1);
        inputCards5b.add(card2);
        inputCards5b.add(card3);
        inputCards5b.add(card4);
        //String[][] inputCards5 = {card1, card2, card3, card4};
        String inputWonders5 = "WWSS";
        processCards(inputCards5b, inputWonders5);

        return ret;
    }

    private boolean processCards(List<List<String>> listOfCardsWithMultipleResources, String wonderResourcesRequired) {
        System.out.println("---- new game -----");

        //convert cards array to arraylist
        //List<String> cardsList = convertCardsArrayToArrayList(listOfCards);

        char[] wonderResources = wonderResourcesRequired.toCharArray();

        //Check number of cards
        /*if(!haveEnoughCards(listOfCards, wonderResources)) {
            System.out.println("canBuild = "+false);
            return false;
        }*/

        boolean canBuild = true;

        //iterate through wonder resources
        for(int i=0; i<wonderResources.length; i++) {
            //if card[i] can be used for resource[i]
            System.out.println("Size="+listOfCardsWithMultipleResources.size());
            //System.out.println(String.format("listofCards[%d] = %s", i, listOfCardsWithMultipleResources.get(i)));
            //System.out.println(String.format("wonderResources[%d] = %s", i, String.valueOf(wonderResources[i])));

            String resourceNeeded = String.valueOf(wonderResources[i]);

            //TODO: iterate through cardsList. If match - remove from list. If no match from whole list, canBuild = false
            boolean cardMatched = false;

            for(int c=0; c<listOfCardsWithMultipleResources.size(); c++) {
                cardMatched = false;
                //if there's a match - remove from list
                List<String> resourcesInCard = listOfCardsWithMultipleResources.get(c);

                for(int r=0; r<resourcesInCard.size(); r++) {
                    String resource = resourcesInCard.get(r);

                    if(resource.equalsIgnoreCase(resourceNeeded)) {
                        listOfCardsWithMultipleResources.remove(c);
                        cardMatched = true;
                        System.out.println("-"+listOfCardsWithMultipleResources.size());
                        //c=listOfCardsWithMultipleResources.size();
                        break;
                    }
                }

                if(cardMatched) {
                    break;
                }
            }

            if(!cardMatched) {
                canBuild = false;
                i = wonderResources.length;
            }
        }

        System.out.println("canBuild = "+canBuild);
        return false;
    }

    private boolean processCards(String[] listOfCards, String wonderResourcesRequired) {
        System.out.println("---- new game -----");

        //convert cards array to arraylist
        List<String> cardsList = convertCardsArrayToArrayList(listOfCards);

        char[] wonderResources = wonderResourcesRequired.toCharArray();

        //TODO check number of cards
        if(!haveEnoughCards(listOfCards, wonderResources)) {
            System.out.println("canBuild = "+false);
            return false;
        }

        boolean canBuild = true;

        //iterate through wonder resources
        for(int i=0; i<wonderResources.length; i++) {
            //if card[i] can be used for resource[i]
            System.out.println(String.format("listofCards[%d] = %s", i, listOfCards[i]));
            System.out.println(String.format("wonderResources[%d] = %s", i, String.valueOf(wonderResources[i])));

            String resourceNeeded = String.valueOf(wonderResources[i]);

            //TODO: iterate through cardsList. If match - remove from list. If no match from whole list, canBuild = false
            boolean cardMatched = false;

            for(int c=0; c<cardsList.size(); c++) {
                cardMatched = false;
                //if there's a match - remove from list
                if(cardsList.get(c).equalsIgnoreCase(resourceNeeded)) {
                    cardsList.remove(c);
                    cardMatched = true;
                    System.out.println("-"+cardsList.size());
                    break;
                }
            }

            if(!cardMatched) {
                canBuild = false;
                i = wonderResources.length;
            }
        }

        System.out.println("canBuild = "+canBuild);
        return false;
    }

    private List<String> convertCardsArrayToArrayList(String[] cardsArray) {
        List<String> cardsList = new ArrayList<>();

        for(int i=0; i<cardsArray.length; i++) {
            cardsList.add(cardsArray[i]);
        }

        return cardsList;
    }

    /*
    private List<List<String>> convertCardsArrayToArrayList(String[][] cardsArray) {
        List<List<String>> cardsList = new ArrayList<>();

        for(int i=0; i<cardsArray.length; i++) {
            cardsList.add(cardsArray[i][]);
        }

        return cardsList;
    }*/

    private boolean haveEnoughCards(String[] inputCards, char[] inputWonderRequirements) {
        return(inputCards.length >= inputWonderRequirements.length);
    }

}