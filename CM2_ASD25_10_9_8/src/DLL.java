import java.util.Scanner;

public class DLL {
    NodePasien headPasien;
    NodeDokter headDokter;
    NodeTransaksi headTransaksi;
    int size;

    public DLL() {
        headPasien = null;
        headDokter = null;
        headTransaksi = null;
        size = 0;
    }

    public boolean isEmpty() {
        return headPasien == null;
    }

    public void tambahDokter(Dokter data) { // isi data dokter
        NodeDokter baru = new NodeDokter(null, data, null);
        if (headDokter == null) {
            headDokter = baru;
        } else {
            NodeDokter current = headDokter;
            while (current.next != null) {
                current = current.next;
            }
            current.next = baru;
        }
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
        System.out.println(">> Pasien Masuk ke dalam Antrian");
    }

    public void printPasien() { // menu 2.lihat antrian
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

    public void layaniPasien(Scanner sc) { // 3. Layani Pasien
        if (isEmpty()) {
            System.out.println("Tidak ada pasien dalam antrian.");
            return;
        }

        NodePasien pasienDilayani = headPasien;
        System.out.println("Pasien " + pasienDilayani.data.nama + " dipanggil");

        printDokter();
        System.out.println();
        System.out.print("Input kode dokter: ");
        String kode = sc.nextLine();

        NodeDokter currentDokter = headDokter;
        Dokter dokterTerpilih = null;
        while (currentDokter != null) {
            if (currentDokter.data.id.equalsIgnoreCase(kode)) {
                dokterTerpilih = currentDokter.data;
                break;
            }
            currentDokter = currentDokter.next;
        }

        if (dokterTerpilih == null) {
            System.out.println("Dokter tidak ditemukan.");
            return;
        }

        System.out.print("Input durasi layanan (jam): ");
        int durasi = sc.nextInt();
        sc.nextLine();

        TransaksiLayanan transaksi = new TransaksiLayanan(pasienDilayani.data, dokterTerpilih, durasi);

        NodeTransaksi transaksiBaru = new NodeTransaksi(null, transaksi, null);
        if (headTransaksi == null) {
            headTransaksi = transaksiBaru;
        } else {
            NodeTransaksi currentTransaksi = headTransaksi;
            while (currentTransaksi.next != null) {
                currentTransaksi = currentTransaksi.next;
            }
            currentTransaksi.next = transaksiBaru;
            transaksiBaru.prev = currentTransaksi;
        }

        hapusDataPasien();
        System.out.println(">> Pasien telah dilayani, transaksi berhasil dicatat");
    }

    public void hapusDataPasien() { // bagian 3
        if (isEmpty()) {
            System.out.println("Antrian kosong!");
        } else {
            headPasien = headPasien.next;
            if (headPasien != null)
                headPasien.prev = null;
            size--;
        }
    }

    public void printDokter() { // bagian 3
        if (isEmpty()) {
            System.out.println("Tidak ada data dalam antrian.");
        } else {
            System.out.println("--daftar Dokter jaga--");
            System.out.println("Kode \t Nama");
            NodeDokter current = headDokter;
            while (current != null) {
                current.data.tampil();
                current = current.next;
            }

        }
    }

    public void getSize() { // menu 4.cek sisa pasien
        System.out.println("Sisa Antrian: " + size);
        return;
    }

    public void cetak() { // menu 5 dan 6
        System.out.println("-- Riwayat Transaksi --");
        System.out.println("Nama\tNama Dokter\tDurasi\tTotal");

        NodeTransaksi current = headTransaksi;
        while (current != null) {
            TransaksiLayanan t = current.data;
            System.out.println(t.pasien.nama + "\t" + t.dokter.nama + "\t" + t.durasiLayanan + "\t" + t.hitungBiaya());
            current = current.next;
        }
    }

    public void sortDESC() { // menu 6
        if (headTransaksi == null || headTransaksi.next == null)
            return;

        boolean swapped;
        do {
            swapped = false;
            NodeTransaksi current = headTransaksi;
            while (current.next != null) {
                if (current.data.pasien.nama.compareToIgnoreCase(current.next.data.pasien.nama) < 0) {
                    TransaksiLayanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
        } while (swapped);

        cetak();
    }
}
