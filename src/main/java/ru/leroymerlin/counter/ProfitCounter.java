package ru.leroymerlin.counter;

import ru.leroymerlin.data.Item;
import ru.leroymerlin.data.Service;

public class ProfitCounter {

    private final String itemName;
    private final Double sum;
    private final Integer quantity;
    private final Double commission;

    public ProfitCounter(Item item) {
        this.itemName = item.getItemName();
        this.sum = item.getSum();
        this.quantity= item.getQuantity();
        this.commission = item.getCommission();
    }

    public ProfitCounter(Service service) {
        this.itemName = service.getItemName();
        this.sum = service.getSum();
        this.quantity= 1;
        this.commission = service.getCommission();
    }

    public void showResult() {
        System.out.println("Минимальная выручка: "+ getSweetProfit()+ " по товару/услуге: "+this.itemName+" c комиссией: " + this.commission);
    }

    private Double getSweetProfit() {
        return this.sum*this.quantity*this.commission/100;
    }

}
