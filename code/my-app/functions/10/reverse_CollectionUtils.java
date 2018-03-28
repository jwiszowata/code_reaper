public static <T> void reverse(final List<T> list) {
    final int len = list.size();
    if (len <= 0)
        return;
    for (int i = 0, j = len - 1; i < j; i++, j--) {
        T t = list.get(i);
        list.set(i, list.get(j));
        list.set(j, t);
    }
}