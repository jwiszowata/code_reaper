public static <T> T getWeightedRandom(Logger logger, String logMe, Stream<RandomChoice<T>> input, Random random) {
    return (input == null) ? null : getWeightedRandom(logger, logMe, toList(input), random);
}