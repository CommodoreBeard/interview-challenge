package uk.co.gfk;

public class Card {



    private Integer primeProduct;
    private Integer order;

    public Card(Integer primeProduct) {
        this.primeProduct = primeProduct;
        this.order = 0;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Integer getPrimeProduct() {
        return primeProduct;
    }
}
