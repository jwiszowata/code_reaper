protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (GoodsContainer.TAG.equals(tag)) {
        goodsContainer = xr.readFreeColObject(getGame(), GoodsContainer.class);
        goodsContainer.setLocation(this);
    } else {
        super.readChild(xr);
    }
}