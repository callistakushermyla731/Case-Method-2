public class PesananDLL {

    NodePesanan head;
    NodePesanan tail;

    boolean isEmpty() {

        return head == null;
    }

    public void tambahPesanan(Pesanan p) {

        NodePesanan baru = new NodePesanan(tail, p, null); //object node pesanan

        if(isEmpty()){
            head = tail =  baru;
        }else{
            // operasi double linked list
            tail.next = baru;
            baru.prev = tail;
            tail = baru;
        }
        System.out.println("Pesanan berhasil disimpan");
    }

    //bubble sort
    public void sorting() {
        if(head == null){
            return;
        }

        boolean tukar;

        do{
            tukar = false;
            NodePesanan current = head;
            while(current.next != null){

                if(current.data.namaPesanan.compareToIgnoreCase(current.next.data.namaPesanan) > 0) {
                    Pesanan temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    tukar = true;
                }
                current = current.next;
            }
        } while(tukar);
    }

    public void tampilPesanan() {
        if(isEmpty()) {
            System.out.println("Belum ada pesanan");
            return;
        }
        sorting();
        NodePesanan tmp = head;
        int total = 0;
        System.out.println();
        System.out.println("======================================");
        System.out.println("LAPORAN PESANAN (URUT NAMA PESANAN)");
        System.out.println("======================================");
        System.out.printf("%-18s %-22s %s\n","Kode Pesanan", "Nama Pesanan", "Harga");

        while(tmp != null){
            System.out.printf("%-18d %-22s %d\n", tmp.data.kodePesanan, tmp.data.namaPesanan, tmp.data.harga);
            total += tmp.data.harga;
            tmp = tmp.next;
        }
        System.out.println("======================================");
        System.out.println("Total Pendapatan : " + total);
    }
}