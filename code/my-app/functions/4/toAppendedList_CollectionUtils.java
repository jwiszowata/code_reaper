public static <T> Collector<List<T>, ?, List<T>> toAppendedList() {
    final BinaryOperator<List<T>> squash = (l1, l2) -> (l1.isEmpty()) ? l2 : (l1.addAll(l2)) ? l1 : l1;
    return Collectors.reducing(Collections.<T>emptyList(), squash);
}