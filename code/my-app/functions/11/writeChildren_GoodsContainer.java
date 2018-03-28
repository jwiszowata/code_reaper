protected void writeChildren(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeChildren(xw);
    if (xw.validFor(getOwner())) {
        synchronized (this.storedGoods) {
            writeStorage(xw, STORED_GOODS_TAG, this.storedGoods);
            synchronized (this.oldStoredGoods) {
                writeStorage(xw, OLD_STORED_GOODS_TAG, this.oldStoredGoods);
            }
        }
    }
}