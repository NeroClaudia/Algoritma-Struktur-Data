public class MahasiswaNode {

    Mahasiswa data;
    MahasiswaNode next;

    public MahasiswaNode() {
        
    }

    public MahasiswaNode(Mahasiswa data, MahasiswaNode next) {
        this.data = data;
        this.next = next;
    }
}