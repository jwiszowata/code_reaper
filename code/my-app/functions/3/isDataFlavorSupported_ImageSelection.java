public boolean isDataFlavorSupported(DataFlavor flavor) {
    return flavor.equals(DefaultTransferHandler.flavor);
}