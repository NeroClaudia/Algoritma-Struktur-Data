public class NodeTransactions {
    
    Transactions transaction;
    NodeTransactions next, prev;

    public NodeTransactions(Transactions transaction) {
        this.transaction = transaction;
        next = null;
        prev = null;
    }
}
