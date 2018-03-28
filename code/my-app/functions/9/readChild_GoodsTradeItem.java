protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final Game game = getGame();
    final String tag = xr.getLocalName();
    if (Goods.TAG.equals(tag)) {
        goods = new Goods(game, xr);
    } else {
        super.readChild(xr);
    }
}