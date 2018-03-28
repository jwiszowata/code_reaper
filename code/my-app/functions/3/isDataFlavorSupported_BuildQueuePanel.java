public boolean isDataFlavorSupported(DataFlavor flavor) {
    return any(supportedFlavors, matchKeyEquals(flavor));
}