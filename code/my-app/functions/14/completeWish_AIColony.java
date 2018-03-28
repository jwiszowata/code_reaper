public boolean completeWish(TransportableAIObject t, LogBuilder lb) {
    if (t instanceof AIGoods) {
        return completeWish((Goods) t.getTransportLocatable(), lb);
    } else if (t instanceof AIUnit) {
        AIUnit aiUnit = (AIUnit) t;
        if (aiUnit.isCompleteWishRealizationMission(colony)) {
            lb.add(", at wish-target");
            completeWish(aiUnit.getUnit(), lb);
            aiUnit.removeMission();
            return true;
        }
    }
    return false;
}