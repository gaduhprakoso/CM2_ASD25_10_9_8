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
        System.out.println(nama +"\t"+ nik + "\t"+ keluhan);
    }
}