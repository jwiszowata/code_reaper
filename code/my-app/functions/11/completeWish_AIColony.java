public boolean completeWish(Wish wish, String reason, LogBuilder lb) {
    if (!wishes.remove(wish)) {
        lb.add(", ", reason, " not wished for at ", colony.getName());
        return false;
    }
    getAIOwner().completeWish(wish);
    lb.add(", ", reason, " fulfills at ", colony.getName());
    wish.dispose();
    requestRearrange();
    return true;
}