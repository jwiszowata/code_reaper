public static <T> int getTotalProbability(Collection<RandomChoice<T>> input) {
    return sum(input, RandomChoice::getProbability);
}