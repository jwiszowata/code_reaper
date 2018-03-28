public List<GoodsType> getWantedGoods(Player player) {
    IndianSettlementInternals isi = getPlayerIndianSettlement(player);
    return (isi == null) ? null : isi.wantedGoods;
}