package apotekapp;

public class Obat {

    // Atribut (private - Encapsulation)
    private String kodeObat;
    private String namaObat;
    private double harga;
    private int stok;
    private String kategori;

    // Constructor
    public Obat(String kodeObat, String namaObat, double harga, int stok, String kategori) {
        this.kodeObat = kodeObat;
        this.namaObat = namaObat;
        this.harga = harga;
        this.stok = stok;
        this.kategori = kategori;
    }

    // Accessor (getter)
    public String getKodeObat() { return kodeObat; }
    public String getNamaObat() { return namaObat; }
    public double getHarga()    { return harga; }
    public int getStok()        { return stok; }
    public String getKategori() { return kategori; }

    // Mutator (setter)
    public void setNamaObat(String namaObat) { this.namaObat = namaObat; }
    public void setHarga(double harga)        { this.harga = harga; }
    public void setStok(int stok)             { this.stok = stok; }
    public void setKategori(String kategori)  { this.kategori = kategori; }

    // Method tampil info
    public void tampilInfo() {
        System.out.println("--------------------------------------------------");
        System.out.println("Kode     : " + kodeObat);
        System.out.println("Nama     : " + namaObat);
        System.out.println("Kategori : " + kategori);
        System.out.printf ("Harga    : Rp %.0f%n", harga);
        System.out.println("Stok     : " + stok + " keping");
    }

    // Method kurangi stok saat penjualan
    public boolean jual(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
            return true;
        }
        return false;
    }
}