public boolean fireChanges() {
    boolean ret = false;
    for (GoodsType type : getSpecification().getGoodsTypeList()) {
        int oldCount = getOldGoodsCount(type);
        int newCount = getGoodsCount(type);
        if (oldCount != newCount) {
            firePropertyChange(type.getId(), oldCount, newCount);
            ret = true;
        }
    }
    return ret;
}