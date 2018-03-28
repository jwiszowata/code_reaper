public static final Predicate<String> matchesName(String key) {
    return matchKeyEquals(key, (String k) -> Messages.getName(k));
}