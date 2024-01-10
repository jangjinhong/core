package hello.core.singleton;

public class StatefulService {
    // private int price; //상태를 유지하는 필드

    public int order(String name, int price) {
        System.out.println("name = " + name + "\t price = " + price);
        // this.price = price; //문제 발생 부분
        return price;
    }
}
