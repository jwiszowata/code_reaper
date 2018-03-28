public int getGoodsCapacity() {
    return (int) applyModifiers(0f, getGame().getTurn(), Modifier.WAREHOUSE_STORAGE);
}