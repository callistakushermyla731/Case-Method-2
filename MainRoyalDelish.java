import java.util.Scanner;

public class MainRoyalDelish {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AntrianDLL antrian = new AntrianDLL(); //oject antrian
        PesananDLL pesanan = new PesananDLL(); //object pesanan

        int pilih;
        do{
            System.out.println("\n============================");
            System.out.println("SISTEM ANTRIAN ROYAL DELISH");
            System.out.println("============================");
            System.out.println("1. Tambah Antrian");
            System.out.println("2. Cetak Antrian");
            System.out.println("3. Hapus Antrian + Pesan");
            System.out.println("4. Laporan Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            pilih = sc.nextInt();
            sc.nextLine();

            switch(pilih){
                case 1:
                    System.out.print("Nama : ");
                    String nama = sc.nextLine();
                    System.out.print("No HP : ");
                    String hp = sc.nextLine();
                    Pembeli p = new Pembeli(nama, hp); //object pembeli
                    antrian.tambahAntrian(p);
                    break;
                case 2:
                    antrian.cetakAntrian();
                    break;
                case 3:
                    System.out.print("Kode Pesanan : ");
                    int kode = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nama Pesanan : ");
                    String np = sc.nextLine();
                    System.out.print("Harga : ");
                    int harga = sc.nextInt();
                    Pesanan ps = new Pesanan(kode, np, harga); //object pesanan
                    antrian.layani(pesanan,ps);
                    break;
                case 4:
                    pesanan.tampilPesanan();
                    break;
                case 5:
                    System.out.println("Program selesai");
                    break;
                default:
                    System.out.println("Menu salah");
            }
        } while (pilih != 5);
    }
}