private void modifySpecialGoods(GoodsType goodsType, int amount) {
    final Turn turn = getGame().getTurn();
    List<Modifier> mods;
    mods = toList(goodsType.getModifiers(Modifier.LIBERTY));
    if (!mods.isEmpty()) {
        modifyLiberty((int) applyModifiers(amount, turn, mods));
    }
    mods = toList(goodsType.getModifiers(Modifier.IMMIGRATION));
    if (!mods.isEmpty()) {
        int migration = (int) applyModifiers(amount, turn, mods);
        modifyImmigration(migration);
        getOwner().modifyImmigration(migration);
    }
}