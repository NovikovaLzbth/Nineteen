enum Size {
    XXS(32),
    XS(34),
    S(36),
    M(38),
    L(40);

    private int euroSize;

    Size(int euroSize) {

        this.euroSize = euroSize;
    }

    public String getDescription() {
        if (this == XXS) {
            return "Детский размер";
        }
        return "Взрослый размер";
    }
}

interface MenClothing {
    void dressMen();
}

interface WomenClothing {
    void dressWomen();
}

abstract class Clothing {
    Size size;
    long price;
    String color;

    Clothing(Size size, long price, String color){
        this.size = size;
        this.price = price;
        this.color = color;
    }
}

class TShirt extends Clothing implements MenClothing, WomenClothing {
    TShirt(Size size, long price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMen() {
        System.out.println("Мужская футболка " + size + " размера, " + "стоимостью " + price + " рублей, цвет - " + color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женская футболка " + size + " размера, " + "стоимостью " + price + " рублей, цвет - " + color);
    }
}

class Pants extends Clothing implements MenClothing, WomenClothing {
    Pants(Size size, long price, String color) {
        super(size, price, color);
    }
    @Override
    public void dressMen() {
        System.out.println("Мужские штаны " + size + " размера, " + "стоимостью " + price + " рублей, цвет - " + color);

    }

    @Override
    public void dressWomen() {
        System.out.println("Женские штаны " + size + " размера, " + "стоимостью " + price + " рублей, цвет - " + color);
    }
}

class Skirt extends Clothing implements WomenClothing {
    Skirt(Size size, long price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Женская юбка " + size + " размера, " + "стоимостью " + price + " рублей, цвет - " + color);
    }
}

class Tie extends Clothing implements MenClothing {
    Tie(Size size, long price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMen() {
        System.out.println("Мужской галстук " + size + " размера, " + "стоимостью " + price + " рублей, цвет - " + color);
    }
}

class Atelier {
    public void dressWomen(Clothing[] clothes) {
        System.out.println("ЖЕНСКАЯ ОДЕЖДА НА ВЕТРИНЕ:");
        for (Clothing c : clothes) {
            if (c instanceof WomenClothing) {
                ((WomenClothing) c).dressWomen();
            }
        }
    }

    public void dressMen(Clothing[] clothes) {
        System.out.println("МУЖСКАЯ ОДЕЖДА НА ВЕТРИНЕ:");
        for (Clothing c : clothes) {
            if (c instanceof MenClothing) {
                ((MenClothing) c).dressMen();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Clothing[] clothes = new Clothing[4];
        clothes[0] = new TShirt(Size.XS, 2000, "розовый");
        clothes[1] = new Pants(Size.M, 4500, "черный");
        clothes[2] = new Skirt(Size.S, 7000, "графитовый");
        clothes[3] = new Tie(Size.L, 500, "белый");

        Atelier atelier = new Atelier();
        atelier.dressWomen(clothes);
        atelier.dressMen(clothes);
    }
}
