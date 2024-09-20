import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    private List<Banknote> banknotes = new ArrayList<>();

    public void start() {
        while (true) {
            System.out.println("Меню:");
            System.out.println("1: Добавить банкноту");
            System.out.println("2: Посмотреть банкноты");
            System.out.println("3: Подсчитать сумму");
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
                case 0:
                    System.out.println("Выход из программы.");
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
                    break;
            }
        }
    }


    public void addMoney() {
        System.out.println("Введите количество купюр:");
        int amount = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Введите тип банкноты (five, ten, twenty, fifty):");
        String banknoteType = scanner.nextLine();

        try {
            BanknoteType type = BanknoteType.valueOf(banknoteType);

            Banknote newBanknote = new Banknote(type, amount);
            banknotes.add(newBanknote);
            System.out.println("Купюра успешно добавлена: тип: " + type + ", количество: " + amount);

        } catch (IllegalArgumentException e) {
            System.out.println("Неверный тип банкноты! Банкнота по умолчанию - five.");

            Banknote newBanknote = new Banknote(amount);
            banknotes.add(newBanknote);
            System.out.println("Купюра по умолчанию успешно добавлена: тип: " + newBanknote.getType() + ", количество: " + newBanknote.getAmount());
        }
    }


    public void viewBanknotes(List<Banknote> banknotes) {
        int id = 0;
        for (Banknote banknote : banknotes) {
            System.out.println("ID:" + id + ". " + banknote);
            id += 1;
        }

    }

    public void countTotalSum(List<Banknote> banknotes) {
        viewBanknotes(banknotes);

        System.out.println("Введите id купюры");
        int choise = scanner.nextInt();
        Banknote selectedBanknote = banknotes.get(choise);

        int totalSum = selectedBanknote.getType().getValue() * selectedBanknote.getAmount();
        System.out.println("Итоговая сумма: " + totalSum);

    }


}
