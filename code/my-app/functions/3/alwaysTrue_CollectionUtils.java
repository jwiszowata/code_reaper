public static <T> Predicate<T> alwaysTrue() {
    return (T t) -> true;
}