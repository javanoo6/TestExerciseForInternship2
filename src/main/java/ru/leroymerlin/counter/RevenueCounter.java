package ru.leroymerlin.counter;

import ru.leroymerlin.data.Item;
import ru.leroymerlin.data.Service;
import ru.leroymerlin.protocol.ReportType;

import java.util.List;
import java.util.Map;

public class RevenueCounter {

    private Double itemsSummaryProfit = 0d;
    private Double servicesSummaryProfit = 0d;
    private Double itemsControlSum;
    private Double servicesControlSum;

    public RevenueCounter(List<Item> items, List<Service> services, Map<ReportType, Double> revenue) {
        this.itemsControlSum = revenue.get(ReportType.ITEM);
        this.servicesControlSum = revenue.get(ReportType.SERVICE);

        for (Item item : items) {
            this.itemsSummaryProfit += (item.getSum() * item.getQuantity() * item.getCommission() / 100);
        }
        for (Service service : services) {
            this.servicesSummaryProfit += (service.getSum() * service.getCommission() / 100);
        }

    }

    public boolean isEqualToItemRevenue() {
        return this.itemsSummaryProfit.equals(this.itemsControlSum);
    }

    public boolean isEqualToServiceRevenue() {
        return this.servicesSummaryProfit.equals(this.servicesControlSum);
    }


    public void showItemsCheckRevenue() {
        System.out.println("Данные по кассовым чекам товаров: " + itemsSummaryProfit);
        System.out.println("Данные по бухгалтерскому учету товаров: " + itemsControlSum);
    }

    public void showServicesCheckRevenue() {
        System.out.println("Данные по кассовым чекам услуг: " + servicesSummaryProfit);
        System.out.println("Данные по бухгалтерскому учету услуг: " + servicesControlSum);
    }
}
