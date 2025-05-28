class TransaksiLayanan {

    Pasien pasien;
    Dokter dokter;
    int durasiLayanan;
    double biaya = 50000;

    public TransaksiLayanan(Pasien pasien, Dokter dokter, int durasiLayanan) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasiLayanan;
    }

    public double hitungBiaya() {
        double totalBayar = durasiLayanan * biaya;
        return totalBayar;
    }
}
