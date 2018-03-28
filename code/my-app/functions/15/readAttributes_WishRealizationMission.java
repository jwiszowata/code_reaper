protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final AIMain aiMain = getAIMain();
    final String wid = xr.getAttribute(WISH_TAG, (String) null);
    wish = xr.getAttribute(aiMain, WISH_TAG, Wish.class, (Wish) null);
    if (wish == null) {
        if (wid.startsWith(GoodsWish.TAG)) {
            wish = new GoodsWish(aiMain, wid);
        } else if (wid.startsWith(WorkerWish.TAG)) {
            wish = new WorkerWish(aiMain, wid);
        } else {
            throw new XMLStreamException("Unknown wish tag: " + wid);
        }
    }
}