public class ExcuseLetterStack {
    
    ExcuseLetter07[] stack;
    int top, size;

    public ExcuseLetterStack(int size) {
        this.size = size;
        top = -1;
        stack = new ExcuseLetter07[size];
    }

    public boolean isFull() {
        int count = 0;
        for (int i = 0; i <= top; i++) {
            if (!stack[i].isProcessed) count++;
        }
        return count == size;
    }

    public boolean isEmpty() {
        for (int i = 0; i <= top; i++) {
            if (!stack[i].isProcessed) return false;
        }
        return true;
    }

    public void push(ExcuseLetter07 let) {
        if (top < size - 1) {
            top++;
            stack[top] = let;
        } else {
            System.out.println("Stack is already full!");
        }
    }

    public ExcuseLetter07 pop() {
        for (int i = top; i >= 0; i--) {
            if (!stack[i].isProcessed) {
                stack[i].isProcessed = true;
                return stack[i];
            }
        }
        System.out.println("There is no data in stack!");
        return null;
    }

    public ExcuseLetter07 peek() {
        for (int i = top; i >= 0; i--) {
            if (!stack[i].isProcessed) {
                return stack[i];
            }
        }
        System.out.println("There is no data in stack!");
        return null;
    }

    public void print() {
        System.out.println("Excuse Letter List:");
        System.out.printf("%-6s  %-10s  %-12s  %-14s  %s%n",
                "ID", "Name", "Class Name", "Type of Excuse", "Duration");
        for (int i = 0; i <= top; i++) {
            if (!stack[i].isProcessed) {
                System.out.printf("%-6s  %-10s  %-12s  %-14c  %d day(s)%n",
                        stack[i].id,
                        stack[i].name,
                        stack[i].className,
                        stack[i].typeOfExcuse,
                        stack[i].duration);
            }
        }
        System.out.println("");
    }

    public ExcuseLetter07 search(String name) {
        for (int i = 0; i <= top; i++) {
            if (stack[i].name.equalsIgnoreCase(name)) {
                return stack[i];
            }
        }
        return null;
    }
}