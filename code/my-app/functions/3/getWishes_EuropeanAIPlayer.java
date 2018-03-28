public List<Wish> getWishes() {
    return sort(flatten(getAIColonies(), aic -> aic.getWishes().stream()), ValuedAIObject.descendingValueComparator);
}