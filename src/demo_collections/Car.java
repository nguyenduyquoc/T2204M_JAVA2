package demo_collections;

public class Car {
    private String brand;
    private Integer produceYear;

    public Car(String brand, Integer produceYear) {
        this.brand = brand;
        this.produceYear = produceYear;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getProduceYear() {
        return produceYear;
    }

    public void setProduceYear(Integer produceYear) {
        this.produceYear = produceYear;
    }


}
