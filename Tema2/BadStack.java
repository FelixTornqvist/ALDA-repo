    int[] stack = new int[100];
    int pointer;

    public void push(int element) {
        if (stack[stack.length-1] != 0) {
            int[] newStack = new int[(stack.length * 2)];

            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[pointer] = element;
        pointer++;
    }