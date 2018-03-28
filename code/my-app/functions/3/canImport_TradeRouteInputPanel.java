public boolean canImport(JComponent c, DataFlavor[] flavors) {
    return any(flavors, matchKeyEquals(STOP_FLAVOR));
}