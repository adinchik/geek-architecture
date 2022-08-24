package proxy;

public class SecureDoor {
    private Door door;

    public SecureDoor(Door door) {
        this.door = door;
    }

    public void open(String password) {
        if (authenticate(password)) {
            this.door.open();
        } else {
            System.out.println("Big no! It ain't possible.");
        }
    }

    public boolean authenticate(String password)
    {
        return password.equals("$ecr@t");
    }

    public void close()
    {
        this.door.close();
    }

}
