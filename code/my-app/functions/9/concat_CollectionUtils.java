public static <T> Stream<T> concat(Stream<T> s0, Stream<T>... streams) {
    Stream<T>[] sts = streams;
    Stream<T> ret = (s0 == null) ? Stream.empty() : s0;
    for (int i = 0; i < sts.length; i++) {
        if (sts[i] != null)
            ret = Stream.concat(ret, sts[i]);
    }
    return ret;
}