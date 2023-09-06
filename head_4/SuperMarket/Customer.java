package Lafore.head_4.SuperMarket;

import java.util.Random;

class Customer {
    private int itemsCount;

    public Customer() {
        // Генерируем случайное количество товаров в корзине (от 1 до 20)
        Random random = new Random();
        itemsCount = random.nextInt(20) + 1;
    }

    public int getItemsCount() {
        return itemsCount;
    }

    public void loseItems(int boughtItems){
        itemsCount = itemsCount - boughtItems;
    }
}
