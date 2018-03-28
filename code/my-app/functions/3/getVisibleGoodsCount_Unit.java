public int getVisibleGoodsCount() {
    return (visibleGoodsCount >= 0) ? visibleGoodsCount : getGoodsSpaceTaken();
}