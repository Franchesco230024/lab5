import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final List<Banknote> banknotes = new ArrayList<>();

    public void start() {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1: Добавить банкноту");
            System.out.println("2: Посмотреть банкноты");
            System.out.println("3: Подсчитать сумму");
            System.out.println("4: Сравнить банкноты");
            System.out.println("0: Выйти");
            System.out.print("Выберите пункт из меню: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addMoney();
                    break;
                case 2:
                    viewBanknotes(banknotes);
                    break;
                case 3:
                    countTotalSum(banknotes);
                    break;
                case 4:
                    compareBanknotes(banknotes);
                    break;
                case 0:
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        }
    }

    public int enterAmount() {
        System.out.println("Введите количество купюр:");
        int amount = scanner.nextInt();
        scanner.nextLine();
        return amount;
    }

    public BanknoteType enterBanknoteType() {
        System.out.println("Введите тип банкноты (five, ten, twenty, fifty):");
        String banknoteType = scanner.nextLine();
        try {
            return BanknoteType.valueOf(banknoteType);
        } catch (IllegalArgumentException e) {
            System.out.println("Неверный тип банкноты! Используется тип по умолчанию - five.");
            return BanknoteType.five;
        }
    }

    public int enterId() {
        System.out.println("Введите id купюры:");
        return scanner.nextInt();
    }

    public void addMoney() {
        int amount = enterAmount();
        Banknote newBanknote = new Banknote(enterBanknoteType(), amount);
        banknotes.add(newBanknote);
        System.out.println("Купюра по умолчанию успешно добавлена: тип: " + newBanknote.getType() + ", количество: " + newBanknote.getAmount());
    }

    public void viewBanknotes(List<Banknote> banknotes) {
        int id = 0;
        for (Banknote banknote : banknotes) {
            System.out.println("ID: " + id + ". " + banknote);
            id++;
        }
    }

    public void countTotalSum(List<Banknote> banknotes) {
        viewBanknotes(banknotes);
        Banknote selectedBanknote = banknotes.get(enterId());
        int totalSum = selectedBanknote.getType().getValue() * selectedBanknote.getAmount();
        System.out.println("Итоговая сумма: " + totalSum);
    }

    public void compareBanknotes(List<Banknote> banknotes) {
        viewBanknotes(banknotes);
        Banknote banknote1 = banknotes.get(enterId());
        Banknote banknote2 = banknotes.get(enterId());
        if (banknote1.equals(banknote2)) {
            System.out.println("Банкноты равны.");
        } else {
            System.out.println("Банкноты не равны.");
        }
    }
}
