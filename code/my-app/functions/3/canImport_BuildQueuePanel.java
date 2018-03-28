public boolean canImport(JComponent comp, DataFlavor[] flavors) {
    return flavors != null && any(flavors, matchKeyEquals(BUILD_LIST_FLAVOR));
}