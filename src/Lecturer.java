public class Lecturer {

    String id, name;
    boolean gender;
    int age;

    public Lecturer() {

    }

    public Lecturer(String id, String name, boolean gender, int age) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public void print() {
        String jenisKelamin = gender ? "Laki-laki" : "Perempuan";
        System.out.println("ID: " + id + ", Name: " + name + ", Gender: " + jenisKelamin + ", Age: " + age);
    }
}
