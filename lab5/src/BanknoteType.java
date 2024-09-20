enum BanknoteType {
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
