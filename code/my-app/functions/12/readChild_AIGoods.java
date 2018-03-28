protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    if (Goods.TAG.equals(tag)) {
        if (goods != null) {
            goods.readFromXML(xr);
        } else {
            goods = new Goods(getAIMain().getGame(), xr);
        }
    } else {
        super.readChild(xr);
    }
}