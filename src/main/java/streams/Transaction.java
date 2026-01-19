package streams;

public class Transaction {

    private int id;
    private double amount;
    private String status;   // SUCCESS / FAILED
    
    public Transaction() {
    	super();
    }

    public Transaction(int id, double amount, String status) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

 

    @Override
    public String toString() {
        return "Transaction{id=" + id +
               ", amount=" + amount +
               ", status='" + status + '\'' +
               '}';
    }
}
