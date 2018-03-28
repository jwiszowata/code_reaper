public <T> void addCollection(String delim, Collection<T> c) {
    if (sb != null) {
        for (T t : c) add(sb, t, delim);
        if (!c.isEmpty())
            shrink(delim);
    }
}