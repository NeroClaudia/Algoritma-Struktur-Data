public class StudentAssignmentStack {
    
    Student07[] stack;
    int top, size;

    public StudentAssignmentStack(int size) {
        this.size = size;
        top = -1;
        stack = new Student07[size];
    }

    public boolean isFull() {
        if (top == size - 1) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void push(Student07 std) {
        if (!isFull()) {
            top++;
            stack[top] = std;
        } else {
            System.out.println("Stack is already full!");
        }
    }

    public Student07 pop() {
        if (!isEmpty()) {
            Student07 std = stack[top];
            top--;
            return std;
        } else {
            System.out.println("There is no data in stack!");
            return null;
        }
    }

    public Student07 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("There is no data in stack!");
            return null;
        }
    }

    public void print() {
        System.out.println("Assignment list:");
        System.out.printf("%-6s  %-8s  %s%n", "Name", "NIM", "Class Name");
        for (int i = 0; i <= top; i++) {
            System.out.printf("%-6s  %-8s  %s%n", stack[i].nim, stack[i].name, stack[i].className);
        }
        System.out.println("");
    }

    public String convertToBinary(int grade) {
        ConversionStack stack = new ConversionStack();
        while (grade > 0) {
            int mod = grade % 2;
            stack.push(mod);
            grade /= 2;
        }
        String binary = "";
        while (!stack.isEmpty()) {
            binary += stack.pop();
        }
        return binary;
    }
}