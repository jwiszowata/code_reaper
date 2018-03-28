private static Advantages selectAdvantages(String as) {
    Advantages a = find(Advantages.values(), Messages.matchesNamed(as));
    if (a != null)
        setAdvantages(a);
    return a;
}