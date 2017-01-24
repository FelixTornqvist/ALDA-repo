    private Node last;

    public void push(int element) {
        Node newNode = new Node(element);
        last.next = newNode;
        last = newNode;
    }

    private class Node {

        private int element;
        public Node next;

        public Node(int element) {
            this.element = element;
        }
    }