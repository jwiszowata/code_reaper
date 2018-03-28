public boolean equals(Object o) {
    if (this == o)
        return true;
    if (o instanceof ModelMessage) {
        ModelMessage m = (ModelMessage) o;
        return sourceId.equals(m.sourceId) && messageType == m.messageType && super.equals(m);
    }
    return false;
}