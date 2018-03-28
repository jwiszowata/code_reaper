public static <T> boolean allSame(final Collection<T> c) {
    T datum = null;
    boolean first = true;
    for (T t : c) {
        if (first)
            datum = t;
        else if (t != datum)
            return false;
        first = false;
    }
    return true;
}