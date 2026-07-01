package apotekapp;

// INHERITANCE
public class ObatResep extends Obat {

    // Atribut tambahan khusus obat resep
    private String namaDokter;
    private boolean wajibResep;

    // Constructor ObatResep
    public ObatResep(String kodeObat, String namaObat, double harga, int stok,
                      String kategori, String namaDokter) {
        super(kodeObat, namaObat, harga, stok, kategori); // memanggil constructor Obat
        this.namaDokter = namaDokter;
        this.wajibResep = true;
    }

    // Accessor & Mutator khusus ObatResep
    public String getNamaDokter() { return namaDokter; }
    public void setNamaDokter(String namaDokter) { this.namaDokter = namaDokter; }
    public boolean isWajibResep() { return wajibResep; }

    // POLYMORPHISM: override method tampilInfo() dari class Obat
    @Override
    public void tampilInfo() {
        super.tampilInfo(); // memanggil tampilInfo() versi parent
        System.out.println("Status   : OBAT RESEP (wajib resep dokter)");
        System.out.println("Dokter   : " + namaDokter);
    }

    // Override method jual() juga bisa ditambahkan aturan khusus
    @Override
    public boolean jual(int jumlah) {
        System.out.println("[INFO] Memverifikasi resep dari dr. " + namaDokter + " ...");
        return super.jual(jumlah);
    }
}