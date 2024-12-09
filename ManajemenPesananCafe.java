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
                    //tambahPesanan();
                    //break;
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