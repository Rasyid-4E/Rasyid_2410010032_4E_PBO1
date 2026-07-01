package apotekapp;

public class Apotek {

    private String namaApotek;
    private Obat[] daftarObat;   // Array of Obat
    private int jumlahObat;
    private static final int KAPASITAS = 50;

    // Constructor
    public Apotek(String namaApotek) {
        this.namaApotek  = namaApotek;
        this.daftarObat  = new Obat[KAPASITAS];
        this.jumlahObat  = 0;
    }

    // Accessor
    public String getNamaApotek() { return namaApotek; }
    public int getJumlahObat()    { return jumlahObat; }

    // Tambah obat ke array
    public boolean tambahObat(Obat obat) {
        if (jumlahObat >= KAPASITAS) {
            System.out.println("Kapasitas apotek penuh!");
            return false;
        }
        // Cek duplikat kode
        for (int i = 0; i < jumlahObat; i++) {
            if (daftarObat[i].getKodeObat().equalsIgnoreCase(obat.getKodeObat())) {
                System.out.println("Kode obat sudah ada!");
                return false;
            }
        }
        daftarObat[jumlahObat++] = obat;
        return true;
    }

    // Cari obat berdasarkan kode - return null jika tidak ada
    public Obat cariObat(String kode) {
        for (int i = 0; i < jumlahObat; i++) {
            if (daftarObat[i].getKodeObat().equalsIgnoreCase(kode)) {
                return daftarObat[i];
            }
        }
        return null;
    }

    // Tampil semua obat (Perulangan)
    public void tampilSemuaObat() {
        if (jumlahObat == 0) {
            System.out.println("Belum ada data obat.");
            return;
        }
        System.out.println("==================================================");
        System.out.println("          DAFTAR OBAT - " + namaApotek);
        System.out.println("==================================================");
        for (int i = 0; i < jumlahObat; i++) {
            System.out.println((i + 1) + ".");
            daftarObat[i].tampilInfo(); // Polymorphism tampil beda sesuai tipe
        }
        System.out.println("==================================================");
        System.out.println("Total obat terdaftar: " + jumlahObat);
    }

    // Proses penjualan
    public void prosesJual(String kode, int jumlah) {
        Obat obat = cariObat(kode);

        // Seleksi
        if (obat == null) {
            System.out.println("Obat dengan kode '" + kode + "' tidak ditemukan.");
            return;
        }

        boolean berhasil = obat.jual(jumlah);
        if (berhasil) {
            double total = obat.getHarga() * jumlah;
            System.out.println("--------------------------------------------------");
            System.out.println("Penjualan berhasil!");
            System.out.println("Obat  : " + obat.getNamaObat());
            System.out.println("Qty   : " + jumlah + " keping");
            System.out.printf ("Total : Rp %.0f%n", total);
            System.out.println("Sisa stok: " + obat.getStok());
        } else {
            System.out.println("Stok tidak cukup! Stok tersedia: " + obat.getStok());
        }
    }
}