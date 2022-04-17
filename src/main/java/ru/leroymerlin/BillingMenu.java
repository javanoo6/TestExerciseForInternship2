package ru.leroymerlin;

import ru.leroymerlin.counter.ProfitCounter;
import ru.leroymerlin.counter.RevenueCounter;
import ru.leroymerlin.reader.ItemReader;
import ru.leroymerlin.reader.RevenueReader;
import ru.leroymerlin.reader.ServiceReader;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class BillingMenu {

    public static void greeting() throws URISyntaxException, IOException {
        System.out.println("Приветствуем в билинговой системе! Что вам требуется?");
        BillingMenu.print();

        Scanner scanner = new Scanner(System.in);
        String input;

        while (true) {
            input = scanner.nextLine();

            switch (input) {
                case "q" -> {
                    System.out.println("Надеемся, вам понравилось наше приложение!");
                    return;
                }
                case "1" -> {
                    for (int i = 0; i < ItemReader.getItems().size(); i++) {
                        ProfitCounter itemsProfit = new ProfitCounter(ItemReader.getItems().get(i));
                        itemsProfit.showResult();
                    }
                    for (int i = 0; i < ItemReader.getItems().size(); i++) {
                        ProfitCounter servicesProfit = new ProfitCounter(ServiceReader.getServices().get(i));
                        servicesProfit.showResult();
                    }
                }
                case "2" -> {
                    RevenueCounter revenueCounter = new RevenueCounter(ItemReader.getItems(), ServiceReader.getServices(), RevenueReader.getRevenue());
                    if (revenueCounter.isEqualToItemRevenue()) {
                        System.out.println("Данные по кассовым чекам товаров сходятся с данными бухгалтерского учета");
                    } else
                        System.out.println("Данные по кассовым чекам товаров не сходятся с данными бухгалтерского учета");
                    revenueCounter.showItemsCheckRevenue();

                    if (revenueCounter.isEqualToServiceRevenue()) {
                        System.out.println("Данные по кассовым чекам услуг сходятся с данными бухгалтерского учета");
                    } else
                        System.out.println("Данные по кассовым чекам услуг не сходятся с данными бухгалтерского учета");
                    revenueCounter.showServicesCheckRevenue();
                }
                default -> System.out.println("Команды не существует");
            }
        }
    }

    private static void print() {
        System.out.println("Рассчёты: ");
        System.out.println("1 - Подсчёт минимальной прибыли по товару и услуге");
        System.out.println("2 - Сверка прибыли по услугам и товарам");
        System.out.println("Для завершения работы, нажмите 'q'");
    }
}
