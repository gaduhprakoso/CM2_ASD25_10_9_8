public class Pasien {
    String nama;
    String nik;
    String keluhan;

    Pasien (String nama, String nik, String keluhan){
        this.nama = nama;
        this.nik = nik;
        this.keluhan = keluhan;
    }
    public void tampilkanDataPasien(){
        System.out.println("Nama: " + nama);
        System.out.println("NIK: " + nik);
        System.out.println("Keluhan: " + keluhan);
    }
}