public class Mahasiswa {

    String nim, name, keperluan;

    public Mahasiswa(String nim, String name, String keperluan) {
        this.nim = nim;
        this.name = name;
        this.keperluan = keperluan;
    }

    void print() {
        System.out.println(nim + " - " + name + " - " + keperluan);
    }
}