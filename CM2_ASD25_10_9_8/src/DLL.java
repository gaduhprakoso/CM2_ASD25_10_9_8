public class DLL {
    NodePasien head;
    int size;

    public DLL() {
        head = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void tambahData(Pasien item) {
        if (isEmpty()) {
            head = new NodePasien(null, item, null);
        } else {
            NodePasien current = head;
            while (current.next != null) {
                current = current.next;
            }
            NodePasien newNode = new NodePasien(current, item, null);
            current.next = newNode;
        }
        size++;
    }

    public void hapusData() {
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println(head.data.nama + " telah selesai divaksinasi.");
            head = head.next;
            if (head != null)
                head.prev = null;
            size--;
        }
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Tidak ada data dalam antrian.");
        } else {
            System.out.println("Daftar Pengantre Vaksin");
            System.out.println("Nomor \t Nama");
            NodePasien current = head;
            while (current != null) {
                current.data.tampilkanDataPasien();
                current = current.next;
            }
            System.out.println("Sisa Antrian: " + size);
        }
    }

    public int getSize() {
        return size;
    }
}
