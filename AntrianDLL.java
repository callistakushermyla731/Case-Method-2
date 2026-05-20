public class AntrianDLL {

    NodePembeli head;
    NodePembeli tail;

    int size = 0;
    int nomor = 1;

    boolean isEmpty() {
        return head == null;
    }

    // tambah pembeli ke antrian
    public void tambahAntrian(Pembeli p) {
        NodePembeli baru = new NodePembeli(tail, nomor, p, null); //object node pembeli
        nomor++;
        if(isEmpty()) {
            head = tail = baru;
        }else{
            // operasi double linked list
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        size++;
        System.out.println("Antrian berhasil ditambah dengan nomor: " + baru.nomor);
    }

    // cetak seluruh antrian
    public void cetakAntrian() {
        if(isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        System.out.println( "\n===== DAFTAR ANTRIAN =====");
        NodePembeli tmp = head;
        while(tmp != null){
            System.out.println("No Antrian : " + tmp.nomor);
            System.out.println("Nama : " + tmp.data.namaPembeli);
            System.out.println("No HP : " + tmp.data.noHp);
            System.out.println();
            tmp = tmp.next;
        }
        System.out.println("Sisa Antrian : " + size);
    }

    // layani pembeli
    public void layani(PesananDLL daftarPesanan, Pesanan p) {
        if(isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        String nama = head.data.namaPembeli;
        daftarPesanan.tambahPesanan(p);
        System.out.println(nama + " telah memesan " + p.namaPesanan);
        // operasi linked list
        head = head.next;
        if(head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        size--;
    }

    //batalkan antrian
    public void batalkanAntrian(int noAntrian){
        if(isEmpty()){
            System.out.println("Antrian kosong, tidak ada antrian yang bisa dibatalkan");
            return;
        }

        NodePembeli tmp = head;
        while(tmp != null){
            if(tmp.nomor == noAntrian){
                if(tmp == head){
                    head = head.next;
                    if(head != null){
                        head.prev = null;
                    }
                } else if(tmp == tail){
                    tail = tail.prev;
                    if(tail != null){
                        tail.next = null;
                    }
                } else{
                    tmp.prev.next = tmp.next;
                    tmp.next.prev = tmp.prev;
                }
                size--;
                System.out.println("Antrian nomor " + noAntrian + " dibatalkan");
                return;
            }
            tmp = tmp.next;
        }
        System.out.println("Nomor antrian tidak ditemukan");
    }
}