public class KRSQueue {
    
    Mahasiswa[] data;
    int front,rear, size, max, totalApproved;

    public KRSQueue(int n) {
        max = n;
        data = new Mahasiswa[max];
        size = 0;
        front = rear = -1;
        totalApproved = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        if (!isEmpty()) {
            front = rear = -1;
            size = 0;
            System.out.println("All data has been removed");
        }else {
            System.out.println("Queue is already empty");
        }
    }

    public void enqueue(Mahasiswa dt) {
            if (!isFull()) { 
                if (isEmpty()) {
                    front = rear = 0;
                } else {
                    if (rear == max - 1) {
                        rear = 0;
                    } else {
                        rear++;
                    }
                }
                data[rear] = dt;
                size++;
                System.out.printf("%s is successfully added at index %d\n", dt.name, rear);
            } else {
                System.out.println("Antrian sudah penuh!");
            }
        }

    public void dequeue() {
        if (!isEmpty()) {
            int sesiIIni = Math.min(2, size);
            System.out.println("Mahasiswa yang diproses KRS:");
            for (int i = 0; i < sesiIIni; i++) {
                System.out.println("- " + data[front].name);
                size--;
                totalApproved++;

                if (isEmpty()) {
                    front = rear = -1;
                }else {
                    front = (front == max - 1) ? 0 : front + 1;
                }
            }
            System.out.println(sesiIIni + " mahasiswa berhasil diproses");
        }else {
            System.out.println("Antrian kosong, tidak ada yang diproses");
        }
    }
    
    public void showAll() {
        if (!isEmpty()) {
            System.out.println("=== Daftar Antrian KRS ===");
            int i = front;
            int count = 0;
            while (count < size) {
                System.out.println((count + 1) + ". NIM: " + data[i].nim + 
                                " | Name: " + data[i].name + 
                                " | Study Program: " + data[i].studyProgram + 
                                " | Class: " + data[i].className);
                i = (i + 1) % max;
                count++;
            }
            System.out.println("Total antrian: " + size);
        } else {
            System.out.println("Queue is empty.");
        }
    }

    public void showLast() {
        if (!isEmpty()) {
            System.out.println("Mahasiswa paling belakang:");
            System.out.println("NIM: " + data[rear].nim + " | Name: " + data[rear].name);
        }else {
            System.out.println("Data kosong");
        }
    }

    public void showFirstTwo() {
        if (!isEmpty()) {
            int tampil = Math.min(2, size);
            System.out.println("=== 2 Mahasiswa Terdepan ===");
            int i = front;
            for (int j = 0; j < tampil; j++) {
                System.out.println((j + 1) + ". " + data[i]);
                i = (i + 1) % max;
            }
        }else {
            System.out.println("Antrian Kosong");
        }
    }

    public void printTotalAntrian() {
        System.out.println("Total mahasiswa di antrian: " + size);
    }

    public void printTotalApproved() {
        System.out.println("Total mahasiswa yang selesai KRS: " + totalApproved);
    }

    public void printTotalBelumSelesai(int maxDPA) {
        int belumSelesai = maxDPA - totalApproved;
        System.out.println("Total mahasiswa yang belum selesai KRS: " + belumSelesai);
    }

    public void displayMenu() {
        System.out.println("===== STUDENT COURSE REGISTRATION =====");
        System.out.println("1. Add student data");
        System.out.println("2. Process KRS Approval");
        System.out.println("3. Show all student data");
        System.out.println("4. Show first two in queue");
        System.out.println("5. Show the last student in queue");
        System.out.println("6. Clear Queue");
        System.out.println("7. Check if Queue is empty");
        System.out.println("8. Check if Queue is full");
        System.out.println("9. Show Total number of student in queue");
        System.out.println("10. Show of students who have completed the KRS");
        System.out.println("11. Show of students who haven't completed the KRS");
        System.out.println("0. Exit");
    }
}
