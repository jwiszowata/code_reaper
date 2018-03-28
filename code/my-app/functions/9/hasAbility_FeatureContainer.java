public static boolean hasAbility(Stream<Ability> abilities) {
    boolean ret = false;
    for (Ability ability : iterable(abilities)) {
        if (!ability.getValue())
            return false;
        ret = true;
    }
    return ret;
}