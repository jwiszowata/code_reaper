private void logModifiers(LogBuilder lb, Set<Modifier> modSet) {
    lb.addCollection(" ", sort(modSet, Modifier.ascendingModifierIndexComparator));
}