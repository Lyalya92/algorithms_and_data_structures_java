package lesson2;

public class Notebook {
    public static int counter = 0;
    private static final int [] RAM = {4,8,16,20,24};

    private double price;
    private int ram;
    private Brand brand;

    public Notebook(double price, int ram, Brand brand) {
        this.price = price;
        this.ram = ram;
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    public Brand getBrand() {
        return brand;
    }

    public static Notebook generateNotebook() {
       return new Notebook(
               (int)(Math.random() * 10 + 1) * 100,
                    RAM[(int) (Math.random() * RAM.length)],
                    Brand.getBrandName((int) (Math.random() * RAM.length)));
   }

   public void print() {
       System.out.println(++counter + ". Brand: " + this.brand + "; RAM: " + this.ram + "; price: " + this.price);

   }
}