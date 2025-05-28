public class NodeTransaksi {
    TransaksiLayanan data;
    NodeTransaksi prev, next;

    public NodeTransaksi(NodeTransaksi prev, TransaksiLayanan data, NodeTransaksi next){
        this.prev = prev;
        this.data = data;
        this.next = next;
    }
}
