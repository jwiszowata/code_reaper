public Comparator<ModelMessage> getModelMessageComparator(Game game) {
    switch(getInteger(MESSAGES_GROUP_BY)) {
        case MESSAGES_GROUP_BY_SOURCE:
            return new MessageSourceComparator(game);
        case MESSAGES_GROUP_BY_TYPE:
            return messageTypeComparator;
        default:
            return null;
    }
}