public static String wide(int size, Object... objects) {
    if (size == 0)
        return "";
    boolean left = size > 0;
    if (!left)
        size = -size;
    StringBuilder s2 = new StringBuilder(size);
    add(s2, objects);
    int delta = size - s2.length();
    if (left) {
        for (; delta > 0; delta--) s2.append(' ');
    } else {
        for (; delta > 0; delta--) s2.insert(0, " ");
    }
    if (delta < 0)
        s2.setLength(size);
    return s2.toString();
}