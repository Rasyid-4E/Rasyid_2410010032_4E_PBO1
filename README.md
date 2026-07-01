# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi manajemen apotek menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa data obat (kode, nama, harga, stok, kategori), dan memberikan output berupa pengelolaan data obat seperti menampilkan daftar obat, mencari obat berdasarkan kode, menambah data obat baru (termasuk obat resep), serta memproses transaksi penjualan obat.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Polymorphism, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Obat`, `ObatResep`, `Apotek`, dan `Main` adalah contoh dari class.

```java
public class Obat {
    ...
}

public class ObatResep extends Obat {
    ...
}

public class Apotek {
    ...
}

public class Main {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `new Obat(...)` dan `new ObatResep(...)` adalah contoh pembuatan object.

```java
apotek.tambahObat(new Obat("OBT001", "Paracetamol 500mg", 3000, 100, "Analgesik"));
ObatResep obatResepBaru = new ObatResep(kodeR, namaR, hargaR, stokR, katR, dokter);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `kodeObat`, `namaObat`, `harga`, `stok`, `kategori`, dan `namaDokter` adalah contoh atribut.

```java
private String kodeObat;
private String namaObat;
private double harga;
private int stok;
private String kategori;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Obat`, `ObatResep`, dan `Apotek`.

```java
public Obat(String kodeObat, String namaObat, double harga, int stok, String kategori) {
    this.kodeObat = kodeObat;
    this.namaObat = namaObat;
    this.harga = harga;
    this.stok = stok;
    this.kategori = kategori;
}

public ObatResep(String kodeObat, String namaObat, double harga, int stok,
                  String kategori, String namaDokter) {
    super(kodeObat, namaObat, harga, stok, kategori);
    this.namaDokter = namaDokter;
    this.wajibResep = true;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNamaObat`, `setHarga`, `setStok`, `setKategori`, dan `setNamaDokter` adalah contoh method mutator.

```java
public void setNamaObat(String namaObat) { this.namaObat = namaObat; }
public void setHarga(double harga) { this.harga = harga; }
public void setStok(int stok) { this.stok = stok; }
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getKodeObat`, `getNamaObat`, `getHarga`, `getStok`, `getKategori`, dan `getNamaDokter` adalah contoh method accessor.

```java
public String getKodeObat() { return kodeObat; }
public String getNamaObat() { return namaObat; }
public double getHarga()    { return harga; }
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, seluruh atribut di class `Obat` dan `ObatResep` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```java
private String kodeObat;
private String namaObat;
private double harga;
private int stok;
private String kategori;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `ObatResep` mewarisi `Obat` dengan sintaks `extends`.

```java
public class ObatResep extends Obat {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama method dapat digunakan untuk merujuk ke beberapa perilaku berbeda tergantung pada tipe objek yang memanggilnya. Pada kode ini, method `tampilInfo()` dan `jual()` di `ObatResep` merupakan **override** dari method `tampilInfo()` dan `jual()` yang ada di class `Obat`.

```java
@Override
public void tampilInfo() {
    super.tampilInfo();
    System.out.println("Status   : OBAT RESEP (wajib resep dokter)");
    System.out.println("Dokter   : " + namaDokter);
}

@Override
public boolean jual(int jumlah) {
    System.out.println("[INFO] Memverifikasi resep dari dr. " + namaDokter + " ...");
    return super.jual(jumlah);
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `jual` dan `tambahObat`, serta seleksi `switch` dalam method `main` untuk memilih menu.

```java
public boolean jual(int jumlah) {
    if (stok >= jumlah) {
        stok -= jumlah;
        return true;
    }
    return false;
}

switch (pilihan) {
    case 1:
        apotek.tampilSemuaObat();
        break;
    case 2:
        ...
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `for` untuk menelusuri array obat, dan loop `while` untuk menjalankan menu utama secara berulang.

```java
for (int i = 0; i < jumlahObat; i++) {
    if (daftarObat[i].getKodeObat().equalsIgnoreCase(kode)) {
        return daftarObat[i];
    }
}

while (running) {
    ...
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` / `System.out.printf` untuk menampilkan output.

```java
Scanner scanner = new Scanner(System.in);
System.out.print("Kode Obat : ");
String kode = scanner.nextLine().trim();

System.out.printf("Harga    : Rp %.0f%n", harga);
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `private Obat[] daftarObat;` adalah contoh penggunaan array.

```java
private Obat[] daftarObat;
private static final int KAPASITAS = 50;
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error, seperti `NumberFormatException` saat input bukan berupa angka.

```java
try {
    int pilihan = Integer.parseInt(scanner.nextLine().trim());
    ...
} catch (NumberFormatException e) {
    System.out.println("[ERROR] Input harus berupa angka! Detail: " + e.getMessage());
} catch (Exception e) {
    System.out.println("[ERROR] Terjadi kesalahan: " + e.getMessage());
}
```

## Cara Menjalankan

```bash
# Compile seluruh file Java
javac apotekapp/*.java

# Jalankan program
java apotekapp.Main
```

## Struktur Project

```
apotekapp/
├── Obat.java          # Class induk (parent) data obat
├── ObatResep.java      # Class turunan (child) khusus obat resep
├── Apotek.java          # Class pengelola data obat (array, CRUD)
└── Main.java            # Program utama (menu & interaksi user)
```

## Usulan Nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: [RASYID]
NPM: [2410010032]
