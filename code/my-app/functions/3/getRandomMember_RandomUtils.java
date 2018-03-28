public static <T> T getRandomMember(Logger logger, String logMe, Stream<T> stream, Random random) {
    return (stream == null) ? null : getRandomMember(logger, logMe, stream.collect(Collectors.toList()), random);
}