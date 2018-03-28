private void reapIgnoredMessages(Turn turn) {
    removeInPlace(messagesToIgnore, e -> e.getValue() < turn.getNumber());
}