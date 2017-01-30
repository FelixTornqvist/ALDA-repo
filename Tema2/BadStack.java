    int[] stack = new int[100];
    int cursor;

    public void push(int element) {
        if (stack.length == cursor) {
            int[] newStack = new int[(stack.length * 2)];

            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;
        }
        stack[cursor] = element;
        cursor++;
    }

String str = "";
for (int i = 0; i < n; i++) {
  str+="*";
}