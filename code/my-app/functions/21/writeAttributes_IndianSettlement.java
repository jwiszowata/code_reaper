protected void writeAttributes(FreeColXMLWriter xw) throws XMLStreamException {
    super.writeAttributes(xw);
    final Player hated = getMostHated();
    if (getName() != null) {
        xw.writeAttribute(NAME_TAG, getName());
    }
    if (xw.validFor(getOwner())) {
        xw.writeAttribute(LAST_TRIBUTE_TAG, lastTribute);
        xw.writeAttribute(CONVERT_PROGRESS_TAG, convertProgress);
    }
    if (learnableSkill != null) {
        xw.writeAttribute(LEARNABLE_SKILL_TAG, learnableSkill);
    }
    for (int i = 0; i < WANTED_GOODS_COUNT; i++) {
        GoodsType gt = getWantedGoods(i);
        if (gt != null)
            xw.writeAttribute(WANTED_GOODS_TAG + i, gt);
    }
    if (hated != null)
        xw.writeAttribute(MOST_HATED_TAG, hated);
}