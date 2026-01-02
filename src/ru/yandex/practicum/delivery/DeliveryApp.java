package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final ArrayList<Parcel> trackableItems = new ArrayList<>();
    private static final ParcelBox<StandartParcel> standartBox = new ParcelBox<>(5.0);
    private static final ParcelBox<BrittleParcel> brittleBox = new ParcelBox<>(5.0);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(5.0);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateСosts();
                    break;
                case 4:
                    System.out.println("выберите какой объект отследить");
                    for (int i = 0; i < allParcels.size(); i++) {
                        System.out.println((i) + " - " + allParcels.get(i));
                    }
                    int numberParcel = scanner.nextInt();
                    scanner.nextLine();
                    Parcel parcel = allParcels.get(numberParcel);
                    System.out.println("введите местоположение");
                    String newLocation = scanner.nextLine();
                    parcel.reportStatus(newLocation);
                    break;
                case 5:
                    System.out.println("Выберите тип коробки: 1 - обычная, 2 - хрупкая, 3 - Скопортящаяся");
                    int boxType = scanner.nextInt();
                    scanner.nextLine();
                    switch (boxType) {
                        case 1:
                            standartBox.getAllParcels();
                            break;
                        case 2:
                            brittleBox.getAllParcels();
                            break;
                        case 3:
                            perishableBox.getAllParcels();
                            break;
                        default:
                            System.out.println("Неверный выбор.");
                            break;
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Статус доставки посылки");
        System.out.println("5 - Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("введите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("введите вес посылки");
        double weight = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("введите адрес доставки");
        String address = scanner.nextLine();
        System.out.println("введите дату отправки");
        int sendDay = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Выберите тип посылки: 1 - обычная, 2 - хрупкая, 3 - Скопортящаяся");
        int type = scanner.nextInt();
        scanner.nextLine();
        Parcel parcel = null;
        switch (type) {
            case 1:
                parcel = new StandartParcel(description, weight, address, sendDay);
                standartBox.addParcel((StandartParcel) parcel);
                break;
            case 2:
                parcel = new BrittleParcel(description, weight, address, sendDay);
                trackableItems.add(parcel);
                brittleBox.addParcel((BrittleParcel) parcel);
                break;
            case 3:
                System.out.println("введите срок годности в днях");
                int timeToLive = scanner.nextInt();
                scanner.nextLine();
                parcel = new PerishableParcel(description, weight, address, sendDay, timeToLive);
                perishableBox.addParcel((PerishableParcel) parcel);
                break;
            default:
                System.out.println("неверный тип посылки");
        }

        if (parcel != null) {
            allParcels.add(parcel);
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateСosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double allСost = 0;
        for (Parcel parcel : allParcels) {
            double cost = parcel.calculateDeliveryСost();
            allСost += cost;
        }
        System.out.println("общая стоимость доставки = " + allСost);
    }

}

