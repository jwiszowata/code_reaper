private void accumulateChoice(GoodsType workType, Collection<GoodsType> tried, List<Collection<GoodsType>> result) {
    if (workType == null)
        return;
    accumulateChoices(workType.getEquivalentTypes(), tried, result);
}