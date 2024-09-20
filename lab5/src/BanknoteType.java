//почему не public, а опять package private? Ты ведь классы public объявляешь, если так, то и enum-ы тоже через public
enum BanknoteType {
    //Все static константы и элементы enum должны быть в верхнем регистре, а не в нижнем
    //Форматирование покинуло чат от кол-ва пробелов
    five(5),
    ten(10),
    twenty(20),
    fifty(50);

    private int value;


    BanknoteType(int value) {
        this.value = value;
    }


    public int getValue() {
        return value;
    }
}
