public void setIndianSettlementInternals(Player player, UnitType skill, List<GoodsType> wanted) {
    IndianSettlementInternals isi = getPlayerIndianSettlement(player);
    if (isi == null) {
        isi = new IndianSettlementInternals();
        playerIndianSettlements.put(player, isi);
    }
    isi.setValues(skill, wanted);
}