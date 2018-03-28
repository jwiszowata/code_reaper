public static <T> Collector<T, ?, List<T>> toListNoNulls() {
    return Collector.<T, List<T>>of((Supplier<List<T>>) ArrayList::new, (left, right) -> {
        if (right != null)
            left.add(right);
    }, (left, right) -> {
        left.addAll(right);
        return left;
    }, Collector.Characteristics.IDENTITY_FINISH);
}