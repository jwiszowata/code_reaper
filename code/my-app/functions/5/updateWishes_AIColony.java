private void updateWishes(LogBuilder lb) {
    updateWorkerWishes(lb);
    updateGoodsWishes(lb);
    wishes.sort(ValuedAIObject.descendingValueComparator);
}