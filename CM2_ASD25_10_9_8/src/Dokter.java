public class Dokter {
    String id;
    String nama;

    public Dokter(String id, String nama) {
        this.id = id;
        this.nama = nama;
    }

    public void tampil() {
        System.out.println(id + "\t" + nama);
    }
}
