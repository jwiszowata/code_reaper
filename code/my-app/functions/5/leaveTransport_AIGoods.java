public boolean leaveTransport(Direction direction) {
    if (direction != null)
        return false;
    return leaveTransport(goods.getAmount());
}