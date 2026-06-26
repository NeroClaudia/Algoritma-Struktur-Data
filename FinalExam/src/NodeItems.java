public class NodeItems {
    Items data;
    NodeItems next, prev;

    public NodeItems(Items data) {
        this.data = data;
        next = null;
        prev = null;
    }
}
