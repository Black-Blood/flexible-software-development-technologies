public class Toy {
    //region "a) створіть клас з 3 полями"
    private int price;
    private String name;
    private String manufacturer;
    //endregion

    //region "e) додати конструктор, який приймає на вхід три параметра для ініціалізації полів класу"
    public Toy(String name, int price, String manufacturer) {
        //region "з) Викликати з конструктора з трьома параметрами конструктор з двома параметрами"
        this(name, price);
        //endregion

        this.manufacturer = manufacturer;
    }
    //endregion

    //region "є) Додати конструктор, який приймає на вхід два параметра для ініціалізації двох полів класу початковими значеннями"
    public Toy(String name, int price) {
        this();
        this.name = name;
        this.price = price;
    }
    //endregion

    //region "ж) Додати конструктор без параметрів, який ініціалізує поля классу початковим значенням”
    public Toy() {
        this.name = "No name";
        this.price = 0;
        this.manufacturer = "Unknown";
    }
    //endregion

    //region "і) Додати в клас методи get та set для правильної взаємодії з кожним полем екземпляру"
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
    //endregion
}