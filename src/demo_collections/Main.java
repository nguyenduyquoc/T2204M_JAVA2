package demo_collections;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        HashSet<String> hsStr = new HashSet<>();
        hsStr.add("Quoc");
        hsStr.add("Giang");
        hsStr.add("Hung");
        hsStr.add("Quoc");
        hsStr.add("Quang");
        hsStr.add("Dong");

        for (String s:hsStr) {
            System.out.println(s);
        }


        HashMap<String, String> hm = new HashMap<>();
        hm.put("name", "Nguyen Duy Quoc");
        hm.put("email", "nguyenduyquoc1298@gmail.com");
        System.out.println("Ten SV: " + hm.get("name"));
        System.out.println("Email SV: " + hm.get("email"));

        PriorityQueue<Integer> pi  = new PriorityQueue<>();
        pi.add(9);
        pi.add(6);
        pi.add(8);
        pi.add(3);
        while (!pi.isEmpty()){
            System.out.println(pi.poll());
        }

        Car c1 = new Car("Toyota", 2000);
        Car c2 = new Car("Audi", 2020);
        Car c3 = new Car("BMW", 2011);

        PriorityQueue<Car> pc = new PriorityQueue<>(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o1.getProduceYear() - o2.getProduceYear();
            }
        });
        pc.add(c1);
        pc.add(c2);
        pc.add(c3);

        while (!pc.isEmpty()){
            Car c = pc.poll();
            System.out.println(c.getBrand());
        }

    }
}
