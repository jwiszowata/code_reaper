public static <T> void rotate(final List<T> list, int n) {
    final int len = list.size();
    if (len <= 0 || n == 0)
        return;
    n %= len;
    if (n > 0) {
        for (; n > 0; n--) {
            T t = list.remove(0);
            list.add(t);
        }
    } else {
        for (; n < 0; n++) {
            T t = list.remove(n - 1);
            list.add(0, t);
        }
    }
}