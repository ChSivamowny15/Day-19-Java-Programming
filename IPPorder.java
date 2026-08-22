
class IPPorder {
    static int pre = 0;

    static void post(int[] preOrder, int[] in, int l, int r) {
        if (l > r) return;

        int root = preOrder[pre++];
        int pos = l;

        while (in[pos] != root) pos++;

        post(preOrder, in, l, pos - 1);
        post(preOrder, in, pos + 1, r);

        System.out.print(root + " ");
    }

    public static void main(String[] args) {
        int[] preOrder = {1, 2, 4, 5, 3};
        int[] in = {4, 2, 5, 1, 3};

        post(preOrder, in, 0, in.length - 1);
    }
}
