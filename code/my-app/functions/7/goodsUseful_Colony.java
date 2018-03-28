public boolean goodsUseful(GoodsType goodsType) {
    if (getOwner().getPlayerType() == Player.PlayerType.INDEPENDENT) {
        if ((goodsType.isLibertyType() && getSoLPercentage() >= 100) || goodsType.isImmigrationType())
            return false;
    }
    return true;
}