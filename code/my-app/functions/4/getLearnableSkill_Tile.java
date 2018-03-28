public UnitType getLearnableSkill(Player player) {
    IndianSettlementInternals isi = getPlayerIndianSettlement(player);
    return (isi == null) ? null : isi.skill;
}