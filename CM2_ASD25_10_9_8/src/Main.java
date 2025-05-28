public class Main {
    public static void main(String[] args) {
        DLL dllDokter = new DLL();
        DLL dllPasien = new DLL();
    
        Dokter[] dataDokter = {
            new Dokter("dr01", "Wike Ratanca"),
            new Dokter("dr02", "Santi Runica"),
            new Dokter("dr03", "Aam Antanica"),
            new Dokter("dr04", "Slamet Sugito")
        };

        for (Dokter d : dataDokter) {
            daftarDokter.tambah(d);
        }

        Scanner sc = new Scanner(System.in);

        int pilihan;
        do {
            System.out.println("Sistem Antrian Klinik");
            System.out.println("1. Tambah Pasien ke Antrian");
            System.out.println("2. Lihat Antrian");
            System.out.println("3. Layani Pasien");
            System.out.println("4. Cek Sisa Antrian Pasien");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("6. Sort Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Input Nama Pasien : ");
                    String nama = sc.nextLine();
                    System.out.print("NIK : ");
                    String nik = sc.nextLine();
                    System.out.print("Keluhan : ");
                    String keluhan = sc.nextLine();
                    Pasien list = new Pasien(nama, nik, keluhan);
                    dllPasien.tambahData(list); 
                    System.out.println();
                    break;
                case 2:
                    list.printPasien();
                    System.out.println();
                    break;
                case 3:
                    list.hapusData();
                    System.out.println();
                    break;
                case 4:
                    list.getSize();
                    System.out.println();
                    break;
                case 5:
                    list.cetak08();
                    System.out.println();
                    break;
                case 6:
                    list.cariId08();
                    System.out.println();
                    break;
                case 0:
                    System.out.println("Terima Kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
                    System.out.println();
            }
        } while (pilihan!=0);
    }
}
    

