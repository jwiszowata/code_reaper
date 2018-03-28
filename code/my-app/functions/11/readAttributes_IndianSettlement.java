protected void readAttributes(FreeColXMLReader xr) throws XMLStreamException {
    super.readAttributes(xr);
    final Specification spec = getSpecification();
    lastTribute = xr.getAttribute(LAST_TRIBUTE_TAG, 0);
    convertProgress = xr.getAttribute(CONVERT_PROGRESS_TAG, 0);
    learnableSkill = xr.getType(spec, LEARNABLE_SKILL_TAG, UnitType.class, (UnitType) null);
    mostHated = xr.findFreeColGameObject(getGame(), MOST_HATED_TAG, Player.class, (Player) null, false);
    for (int i = 0; i < WANTED_GOODS_COUNT; i++) {
        setWantedGoods(i, xr.getType(spec, WANTED_GOODS_TAG + i, GoodsType.class, (GoodsType) null));
    }
}