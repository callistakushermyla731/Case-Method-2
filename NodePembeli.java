public class NodePembeli {
    int nomor;
    Pembeli data;
    NodePembeli prev, next; // double linked list

    public NodePembeli(NodePembeli prev, int nomor, Pembeli data, NodePembeli next) {

        this.prev = prev;
        this.nomor = nomor;
        this.data = data;
        this.next = next;
    }
}