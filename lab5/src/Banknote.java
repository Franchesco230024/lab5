import java.lang.reflect.Type;
import java.util.*;
import java.util.Scanner;

public class Banknote {
    private BanknoteType type;
    //поле Старайся объявлять через классы обертки, а не примитивы. Несмотря на то, что они обратносовместимы
    private int amount;
    //Объявляй конструкторы public, а не package private
    Banknote(BanknoteType type, int amount) {
        this.type = type;
        this.amount = amount;
    }
    //здесь то же самое
    Banknote(int amount) {
        this.type = BanknoteType.five;
        this.amount = amount;
    }

    public void setType(BanknoteType type) {
        this.type = type;
    }

    public BanknoteType getType() {
        return type;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
    //Зачем здесь ты формируешь отдельно string? Ты ведь не используешь ее нигде больше, так верни сразу строку, а не присваивай переменной
    public String toString() {
        String string = "Тип купюры - " + type + ". Количество купюр - " + amount;
        return string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Banknote banknote = (Banknote) o;
        return getAmount() == banknote.getAmount() && getType() == banknote.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getType(), getAmount());
    }
}
