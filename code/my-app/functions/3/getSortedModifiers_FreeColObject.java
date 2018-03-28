public final List<Modifier> getSortedModifiers() {
    return sort(getModifiers(), Modifier.ascendingModifierIndexComparator);
}