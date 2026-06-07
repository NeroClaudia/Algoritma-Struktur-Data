public class BinaryTree07 {
    Node07 root;

    public BinaryTree07() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void add(Student07 data) {
        if (isEmpty()) {
            root = new Node07(data);
        }else {
            Node07 current = root;
            while (true) {
                if (data.ipk < current.data.ipk) {
                    if (current.left != null) {
                        current = current.left;
                    }else {
                        current.left = new Node07(data);
                        break;
                    }
                }else if (data.ipk > current.data.ipk) {
                    if (current.right != null) {
                        current = current.right;
                    }else {
                        current.right = new Node07(data);
                        break;
                    }
                }else {
                    break;
                }
            }
        }
    }

    public boolean find(double ipk) {
        boolean result = false;
        Node07 current = root;
        while (current != null) {
            if (current.data.ipk == ipk) {
                result = true;
                break;
            }else if (ipk < current.data.ipk) {
                current = current.left;
            }else {
                current = current.right;
            }
        }
        return result;
    }

    public void traversePreOrder(Node07 node) {
        if (node != null) {
            node.data.print();
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    public void traverseInOrder(Node07 node) {
        if (node != null) {
            traverseInOrder(node.left);
            node.data.print();
            traverseInOrder(node.right);
        }
    }

    public void traversePostOrder(Node07 node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            node.data.print();
        }
    }

    public Node07 getSuccessor(Node07 del) {
        Node07 successor = del.right;
        Node07 successorParent = del;
        while (successor.left != null) {
            successorParent = successor;
            successor = successor.left;
        }
        if (successor != del.right) {
            successorParent.left = successor.right;
            successor.right = del.right;
        }
        return successor;
    }

    public void delete(double ipk) {
        if (isEmpty()) {
            System.out.println("Tree is empty");
            return;
        }
        Node07 parent = root;
        Node07 current = root;
        boolean isLeftChild = false;
        while (current.data.ipk != ipk) {
            parent = current;

            if (ipk < current.data.ipk) {
                isLeftChild = true;
                current = current.left;
            }else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                System.out.println("Couldn't find data!");
                return;
            }
        }
        //Delete node with no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }else if (isLeftChild) {
                parent.left = null;
            }else {
                parent.right = null;
            }
        }else if (current.right == null) {//Delete node with a left child
            if (current == root) {
                root = current.left;
            }else if (isLeftChild) {
                parent.left = current.left;
            }else {
                parent.right = current.left;
            }
        }else if (current.left == null) {//Delete node with a right child
            if (current == root) {
                root = current.right;
            }else if (isLeftChild) {
                parent.left = current.right;
            }else {
                parent.right = current.right;
            }
        }else {//Delete node with 2 children
            Node07 successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            }else if (isLeftChild) {
                parent.left = successor;
            }else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
    }

    public void addRekursif(Student07 data) {
        root = addRekursif(root, data);
    }

    public Node07 addRekursif(Node07 current, Student07 data) {
        if (current == null) {
            return new Node07(data);
        }else {
            if (data.ipk < current.data.ipk) {
                current.left = addRekursif(current.left, data);
            }else if (data.ipk > current.data.ipk) {
                current.right = addRekursif(current.right, data);
            }
        }
        return current;
    }

    public void getMinIPK() {
        Node07 current = root;
        while (current.left != null) {
            current = current.left;
        }
        current.data.print();
    }
}
