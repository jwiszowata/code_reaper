public int getSettlementDefenders(Settlement settlement) {
    int defenders = 0;
    for (AIUnit au : getAIUnits()) {
        Mission dm = au.getMission(DefendSettlementMission.class);
        if (dm != null && dm.getTarget() == settlement && au.getUnit().getSettlement() == settlement) {
            defenders++;
        }
    }
    return defenders;
}