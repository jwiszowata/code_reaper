public Object getTransferData(DataFlavor flavor) {
    if (isDataFlavorSupported(flavor)) {
        return label;
    }
    return null;
}