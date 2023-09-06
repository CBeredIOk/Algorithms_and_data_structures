package Lafore.head_4.SuperMarket;

import java.util.Random;
import java.util.Scanner;

public class SupermarketSimulation {
    public static void main(String[] args) {

        int sizeQueue = 100;
        Queue queue_1 = new Queue(sizeQueue); // Создание 3-х очередей на 3 кассы
        Queue queue_2 = new Queue(sizeQueue);
        Queue queue_3 = new Queue(sizeQueue);

//        Queue<Customer> queue1 = new LinkedList<>();
//        Queue<Customer> queue2 = new LinkedList<>();
//        Queue<Customer> queue3 = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int time = 0; // Начальное время
        int customersNumber = 1;

        while (true) {
            System.out.println("Минут прошло: " + time);
            System.out.println("Enter - Добавить покупателя в очередь");
            System.out.println("Q - Выйти из программы");

            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("Q")){
                break;
            }

            if (queue_1.isEmpty()){
                queue_1.insert(customersNumber);
            }
            else if (queue_2.isEmpty()){
                queue_2.insert(customersNumber);
            }
            else if (queue_3.isEmpty()){
                queue_3.insert(customersNumber);
            }

            else {
                int size_1 = queue_1.size();
                System.out.println("Size_1: " + size_1);
                int size_2 = queue_2.size();
                System.out.println("Size_2: " + size_2);
                int size_3 = queue_3.size();
                System.out.println("Size_3: " + size_3);

                if (size_3 < size_2 && size_3 < size_1){
                    queue_3.insert(customersNumber);
                }
                else if (size_2 < size_1 && size_2 <= size_3){
                    queue_2.insert(customersNumber);
                }
                else queue_1.insert(customersNumber);
            }

            System.out.println("Очередь 1: ");
            queue_1.output();
            System.out.println("Очередь 2: ");
            queue_2.output();
            System.out.println("Очередь 3: ");
            queue_3.output();

            int randomQueue = random.nextInt(3);
            if(randomQueue == 1){
                if(!queue_1.isEmpty()){
                    queue_1.remove();
                }
            } else if (randomQueue == 2) {
                if(!queue_2.isEmpty()){
                    queue_2.remove();
                }
            } else if (randomQueue == 3) {
                if(!queue_3.isEmpty()){
                    queue_3.remove();
                }
            }

            time++; // Прошла одна минута
            customersNumber++; // Пришёл покупатель
        }
    }
}
