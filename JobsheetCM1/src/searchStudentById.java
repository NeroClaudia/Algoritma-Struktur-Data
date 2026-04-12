public class searchStudentById {

    bookLending[] lendings;

    public searchStudentById(bookLending[] lendings) {
        this.lendings = lendings;
    }

    public void findSequentialSearch(String search) {
        boolean found = false;
        for (int i = 0; i < lendings.length; i++) {
            if (lendings[i].sdt.nim.equals(search)) {
                lendings[i].printLending();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Student not found");
        }
    }
}
