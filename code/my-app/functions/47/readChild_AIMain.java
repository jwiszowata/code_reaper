protected void readChild(FreeColXMLReader xr) throws XMLStreamException {
    final String tag = xr.getLocalName();
    final String oid = xr.readId();
    try {
        Wish wish = null;
        AIObject aio;
        if (oid != null && (aio = getAIObject(oid)) != null) {
            aio.readFromXML(xr);
        } else if (AIColony.TAG.equals(tag)) {
            new AIColony(this, xr);
        } else if (AIGoods.TAG.equals(tag)) {
            new AIGoods(this, xr);
        } else if (AIPlayer.TAG.equals(tag)) {
            Player p = getGame().getFreeColGameObject(oid, Player.class);
            if (p != null) {
                if (p.isIndian()) {
                    new NativeAIPlayer(this, xr);
                } else if (p.isREF()) {
                    new REFAIPlayer(this, xr);
                } else if (p.isEuropean()) {
                    new EuropeanAIPlayer(this, xr);
                } else {
                    throw new RuntimeException("Bogus AIPlayer: " + p);
                }
            }
        } else if (AIUnit.TAG.equals(tag)) {
            new AIUnit(this, xr);
        } else if (GoodsWish.TAG.equals(tag) || OLD_GOODS_WISH_TAG.equals(tag)) {
            wish = new GoodsWish(this, xr);
        } else if (TileImprovementPlan.TAG.equals(tag) || OLD_TILE_IMPROVEMENT_PLAN_TAG.equals(tag)) {
            new TileImprovementPlan(this, xr);
        } else if (WorkerWish.TAG.equals(tag)) {
            wish = new WorkerWish(this, xr);
        } else {
            super.readChild(xr);
        }
        if (wish != null) {
            AIColony ac = wish.getDestinationAIColony();
            if (ac != null)
                ac.addWish(wish);
        }
    } catch (Exception e) {
        logger.log(Level.WARNING, "Exception reading AIObject: " + tag + ", id=" + oid, e);
        final String mainTag = TAG;
        while (xr.moreTags() || !(xr.atTag(tag) || xr.atTag(mainTag))) ;
    }
}