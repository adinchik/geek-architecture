package proxy;

public class MainClass {
    public static void main(String[] args) {
        SecureDoor door = new SecureDoor (new LabDoor());
        door.open("invalid"); // Big no! It ain't possible.

        door.open("$ecr@t"); // Opening lab door
        door.close();
    }

}
