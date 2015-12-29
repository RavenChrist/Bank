public abstract class Account {

    private int id;
    private int id1;
    private Status status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Account(int id, Status status) {
        this.id = id;
        this.status = status;
    }
}
