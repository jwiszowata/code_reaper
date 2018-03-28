protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (OLD_STORED_GOODS_TAG.equals(tag)) {
        synchronized (this.oldStoredGoods) {
            readStorage(xr, this.oldStoredGoods);
        }
    } else if (STORED_GOODS_TAG.equals(tag)) {
        synchronized (this.storedGoods) {
            readStorage(xr, this.storedGoods);
        }
    } else {
        super.readChild(xr);
    }
}