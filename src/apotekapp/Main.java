package apotekapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Object Apotek
        Apotek apotek = new Apotek("Apotek Dr. Rasyid");

        // Data awal obat
        apotek.tambahObat(new Obat("OBT001", "Paracetamol 500mg", 3000, 100, "Analgesik"));
        apotek.tambahObat(new Obat("OBT002", "Vitamin C 1000mg", 5000, 80, "Suplemen"));
        apotek.tambahObat(new Obat("OBT003", "Antasida Tablet", 4500, 60, "Antasida"));

        // Data awal Object ObatResep
        apotek.tambahObat(new ObatResep("OBT004", "Amoxicillin 500mg", 8000, 40, "Antibiotik", "dr.Rasyid"));

        boolean running = true;

        System.out.println("==================================================");
        System.out.println("   SELAMAT DATANG DI " + apotek.getNamaApotek().toUpperCase());
        System.out.println("==================================================");

        while (running) {
            System.out.println("\n================ MENU UTAMA =================");
            System.out.println(" 1. Tampil Semua Obat");
            System.out.println(" 2. Cari Obat");
            System.out.println(" 3. Tambah Obat Baru");
            System.out.println(" 4. Proses Penjualan");
            System.out.println(" 5. Tambah Obat Resep");
            System.out.println(" 0. Keluar");
            System.out.println("=============================================");
            System.out.print("Pilih menu: ");

            try {
                // IO Sederhana + Error Handling
                int pilihan = Integer.parseInt(scanner.nextLine().trim());

                switch (pilihan) {
                    case 1:
                        apotek.tampilSemuaObat();
                        break;

                    case 2:
                        System.out.print("Masukkan kode obat: ");
                        String kodeCari = scanner.nextLine().trim();
                        Obat hasil = apotek.cariObat(kodeCari);
                        if (hasil != null) {
                            hasil.tampilInfo();
                        } else {
                            System.out.println("Obat tidak ditemukan.");
                        }
                        break;

                    case 3:
                        System.out.println("--- Tambah Obat Biasa ---");
                        System.out.print("Kode Obat : "); String kode = scanner.nextLine().trim();
                        System.out.print("Nama Obat : "); String nama = scanner.nextLine().trim();
                        System.out.print("Harga     : "); double harga = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Stok      : "); int stok = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Kategori  : "); String kat = scanner.nextLine().trim();

                        Obat obatBaru = new Obat(kode, nama, harga, stok, kat);
                        if (apotek.tambahObat(obatBaru)) {
                            System.out.println("Obat berhasil ditambahkan!");
                        }
                        break;

                   

                    case 4:
                        System.out.print("Kode obat yang dijual : ");
                        String kodeJual = scanner.nextLine().trim();
                        System.out.print("Jumlah                : ");
                        int jumlah = Integer.parseInt(scanner.nextLine().trim());
                        apotek.prosesJual(kodeJual, jumlah);
                        break;

                    case 5:
                        System.out.println("--- Tambah Obat Resep ---");
                        System.out.print("Kode Obat   : "); String kodeR = scanner.nextLine().trim();
                        System.out.print("Nama Obat   : "); String namaR = scanner.nextLine().trim();
                        System.out.print("Harga       : "); double hargaR = Double.parseDouble(scanner.nextLine().trim());
                        System.out.print("Stok        : "); int stokR = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Kategori    : "); String katR = scanner.nextLine().trim();
                        System.out.print("Nama Dokter : "); String dokter = scanner.nextLine().trim();

                        // Polymorphism
                        ObatResep obatResepBaru = new ObatResep(kodeR, namaR, hargaR, stokR, katR, dokter);
                        if (apotek.tambahObat(obatResepBaru)) {
                            System.out.println("Obat resep berhasil ditambahkan!");
                        }
                        break;

                    case 0:
                        running = false;
                        System.out.println("Terima kasih telah menggunakan sistem apotek. Sampai jumpa!");
                        break;

                    default:
                        System.out.println("Menu tidak valid. Masukkan angka 0-5.");
                }

            } catch (NumberFormatException e) {
                // Error Handling
                System.out.println("[ERROR] Input harus berupa angka! Detail: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("[ERROR] Terjadi kesalahan: " + e.getMessage());
            }
        }

        scanner.close();
    }
}