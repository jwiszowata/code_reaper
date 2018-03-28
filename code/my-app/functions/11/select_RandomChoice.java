private static <T> T select(Collection<RandomChoice<T>> input, int probability) {
    if (input.isEmpty())
        return null;
    int total = 0;
    for (RandomChoice<T> choice : input) {
        total += choice.getProbability();
        if (probability < total)
            return choice.getObject();
    }
    return first(input).getObject();
}