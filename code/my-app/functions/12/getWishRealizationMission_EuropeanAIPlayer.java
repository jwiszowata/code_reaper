public Mission getWishRealizationMission(AIUnit aiUnit, WorkerWish wish) {
    if (WishRealizationMission.invalidReason(aiUnit) != null)
        return null;
    final Unit unit = aiUnit.getUnit();
    if (wish == null) {
        wish = getBestWorkerWish(aiUnit, unit.getType());
    }
    if (wish == null)
        return null;
    consumeWorkerWish(aiUnit, wish);
    return new WishRealizationMission(getAIMain(), aiUnit, wish);
}