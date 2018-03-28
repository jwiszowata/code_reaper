public void updateIndianSettlement(Player player) {
    if (playerIndianSettlements == null || !player.isEuropean())
        return;
    IndianSettlementInternals isi = getPlayerIndianSettlement(player);
    IndianSettlement is = getIndianSettlement();
    if (is == null) {
        if (isi != null)
            removeIndianSettlementInternals(player);
    } else {
        if (isi == null) {
            isi = new IndianSettlementInternals();
            playerIndianSettlements.put(player, isi);
        }
        isi.update(is);
    }
}