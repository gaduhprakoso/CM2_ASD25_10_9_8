public class DLL {
    NodePasien headPasien;
    NodeDokter headDokter;
    NodeTransaksi headTransaksi;
    int size;

    public DLL() {
        headPasien = null;
        size = 0;
    }

    public boolean isEmpty() {
        return headPasien == null;
    }

    public void tambahData(Pasien item) { // menu 1.tambah pasien ke antrian
        if (isEmpty()) {
            headPasien = new NodePasien(null, item, null);
        } else {
            NodePasien current = headPasien;
            while (current.next != null) {
                current = current.next;
            }
            NodePasien newNode = new NodePasien(current, item, null);
            current.next = newNode;
        }
        size++;
        System.out.println("Pasien Masuk ke dalam Antrian");
    }

    public void hapusData() { // 3. layani pasien
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            System.out.println(headPasien.data.nama + " telah selesai divaksinasi.");
            headPasien = headPasien.next;
            if (headPasien != null)
                headPasien.prev = null;
            size--;
        }
    }

    public void printPasien() { //menu 2.lihat antrian
        if (isEmpty()) {
            System.out.println("Tidak ada data dalam antrian.");
        } else {
            System.out.println("--Antrien Pasien--");
            System.out.println("Nama \t NIK \t Keluhan");
            NodePasien current = headPasien;
            while (current != null) {
                current.data.tampilkanDataPasien();
                current = current.next;
            }

        }
    }

    public void printDokter() { //menu 3.Layani pasien
        if (isEmpty()) {
            System.out.println("Tidak ada data dalam antrian.");
        } else {
            System.out.println("--Antrien Pasien--");
            System.out.println("Kode \t Nama");
            NodePasien current = headDokter;
            while (current != null) {
                current.data.tampil();
                current = current.next;
            }

        }
    }

    public void getSize() { //menu 4.cek sisa pasien
        System.out.println("Sisa Antrian: " + size);
        return;
    }
}
