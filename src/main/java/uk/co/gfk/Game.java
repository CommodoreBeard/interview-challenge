package uk.co.gfk;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    HashMap<String, Integer> backtrackCheck = new HashMap<>();

    public String playGame(Wonder wonderToBuild, List<Card> cards) {

        Integer counter = 1;

        for(Integer resourceInWonder: wonderToBuild.getPrimeValues()) {

            int stackSize = cards.size();
            for(int i=0; i< stackSize; i++) {

                if(cards.get(i).getPrimeProduct() % resourceInWonder == 0 && cards.get(i).getOrder() == 0) {
                    cards.get(i).setOrder(counter);
                }
                if(i == stackSize - 1) {
                    backtrackCheck.put(getOrders(cards), 1);
                }
            }
            counter++;
        }

        return "";
    }

    public String getOrders(List<Card> cards) {
        return String.join("", cards.stream()
                .map(card -> card.getOrder().toString())
                .collect(Collectors.toList()));
    }
}