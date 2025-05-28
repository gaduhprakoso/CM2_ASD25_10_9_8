class NodeDokter {
    Dokter data;
    NodeDokter next;
    NodeDokter prev;

    public NodeDokter(NodeDokter prev, Dokter data, NodeDokter next) {
        this.prev = null;
        this.data = data;
        this.next = null;
    }
}