public int compare(ModelMessage message1, ModelMessage message2) {
    String sourceId1 = message1.getSourceId();
    String sourceId2 = message2.getSourceId();
    if (Utils.equals(sourceId1, sourceId2)) {
        return messageTypeComparator.compare(message1, message2);
    }
    FreeColGameObject source1 = game.getMessageSource(message1);
    FreeColGameObject source2 = game.getMessageSource(message2);
    int base = getClassIndex(source1) - getClassIndex(source2);
    if (base == 0) {
        if (source1 instanceof Colony) {
            return getColonyComparator().compare((Colony) source1, (Colony) source2);
        }
    }
    return base;
}