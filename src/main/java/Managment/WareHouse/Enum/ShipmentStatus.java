package Managment.WareHouse.Enum;

public enum ShipmentStatus {
    IN_TRANSIT(1, "In Transit"),
    DELIVERED(2, "Delivered");

    private int id;
    private String name;

    ShipmentStatus(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
