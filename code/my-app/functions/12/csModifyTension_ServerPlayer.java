public void csModifyTension(Player player, int add, Settlement origin, ChangeSet cs) {
    Tension.Level oldLevel = getTension(player).getLevel();
    getTension(player).modify(add);
    if (oldLevel != getTension(player).getLevel()) {
        cs.add(See.only((ServerPlayer) player), this);
    }
    if (isIndian()) {
        for (IndianSettlement is : transform(getIndianSettlements(), i -> i != origin && i.hasContacted(player))) {
            ((ServerIndianSettlement) is).csModifyAlarm(player, add, false, cs);
        }
    }
}