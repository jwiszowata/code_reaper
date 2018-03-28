public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
    if (isDataFlavorSupported(flavor))
        return this.indexedBuildables;
    throw new UnsupportedFlavorException(flavor);
}