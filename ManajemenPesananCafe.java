import java.util.Scanner;

public class ManajemenPesananCafe {
    static String[][] daftarPesanan = new String[100][4]; // Kapasitas maksimum 100 pesanan
    static int jumlahPesanan = 0; // Jumlah pesanan yang tercatat
    static String[] menuCafe = {"Kopi Hitam", "Latte", "Cappuccino", "Espresso", "Americano", "Mie Goreng"};
    static int[] hargaMenu = {15000, 22000, 30000, 20000, 18000, 18000}; // Harga menu sesuai dengan menuCafe
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;
        do {
            System.out.println("\n=== Sistem Manajemen Pesanan Cafe ===");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.println("");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // membersihkan buffer

            switch (pilihan) {
                case 1:
                    tambahPesanan();
                    break;
                case 2:
                    tampilkanDaftarPesanan();
                    break;
                case 3:
                    System.out.println("Terima kasih telah menggunakan sistem ini!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 3);
    }

    static void tambahPesanan() {
        if (jumlahPesanan >= daftarPesanan.length) {
            System.out.println("Kapasitas daftar pesanan sudah penuh!");
            return;
        }

        System.out.print("Masukkan nama pelanggan: ");
        String namaPelanggan = scanner.nextLine();

        System.out.print("Masukkan nomor meja: ");
        int nomorMeja = scanner.nextInt();
        scanner.nextLine(); // membersihkan buffer

        String detailPesanan = ""; // Menggunakan string biasa untuk menyimpan detail
        int totalHarga = 0;

        System.out.println("\nDaftar Menu:");
        for (int i = 0; i < menuCafe.length; i++) {
            System.out.println((i + 1) + ". " + menuCafe[i] + " (Rp " + hargaMenu[i] + ")");
        }
        // System.out.println("Ketik '0' untuk selesai memilih menu.");

        while (true) {
            System.out.print("\nPilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
            int pilihanMenu = scanner.nextInt();
            if (pilihanMenu == 0) break; // Selesai memilih menu

            if (pilihanMenu < 1 || pilihanMenu > menuCafe.length) {
                System.out.println("Pilihan tidak valid. Silakan coba lagi.");
                continue;
            }

            System.out.print("Masukkan jumlah item untuk " + menuCafe[pilihanMenu - 1] + ": ");
            int jumlahItem = scanner.nextInt();
            int hargaMenuPesanan = jumlahItem * hargaMenu[pilihanMenu - 1];

            // Tambahkan detail pesanan ke string
            detailPesanan += "- " + menuCafe[pilihanMenu - 1] +
                    " x " + jumlahItem +
                    " = Rp " + hargaMenuPesanan + "\n";
            totalHarga += hargaMenuPesanan;
        }

        // Simpan pesanan ke daftar
        daftarPesanan[jumlahPesanan][0] = namaPelanggan;
        daftarPesanan[jumlahPesanan][1] = String.valueOf(nomorMeja);
        daftarPesanan[jumlahPesanan][2] = detailPesanan;
        daftarPesanan[jumlahPesanan][3] = String.valueOf(totalHarga);
        jumlahPesanan++;

        System.out.println("\nPesanan berhasil ditambahkan.");
        System.out.println("Total harga pesanan: Rp " + totalHarga);
    }

    static void tampilkanDaftarPesanan() {
        if (jumlahPesanan == 0) {
            System.out.println("\nBelum ada pesanan yang dicatat.");
            return;
        }

        System.out.println("\n===== DAFTAR PESANAN =====");
        for (int i = 0; i < jumlahPesanan; i++) {
            System.out.println("Nama Pelanggan: " + daftarPesanan[i][0]);
            System.out.println("Nomor Meja: " + daftarPesanan[i][1]);
            System.out.println("Detail Pesanan:");
            System.out.print(daftarPesanan[i][2]); // Detail menu
            System.out.println("Total Harga Pesanan: Rp " + daftarPesanan[i][3]);
            System.out.println("--------------------------------");
        }
    }
}
