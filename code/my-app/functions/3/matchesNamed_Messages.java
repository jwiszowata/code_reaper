public static final Predicate<Named> matchesNamed(String key) {
    return matchKeyEquals(key, (Named k) -> Messages.getName(k));
}