class TransaksiLayanan {

    Pasien pasien;
    Dokter dokter;
    int durasiLayanan, biaya;

    public TransaksiLayanan(Pasien pasien, Dokter dokter, int durasiLayanan) {
        this.pasien = pasien;
        this.dokter = dokter;
        this.durasiLayanan = durasiLayanan;
    }

    int hitungBiaya() {
        int totalBayar = durasiLayanan * biaya;
        return totalBayar;
    }
}
