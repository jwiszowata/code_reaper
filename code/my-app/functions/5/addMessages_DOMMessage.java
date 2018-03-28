public DOMMessage addMessages(List<DOMMessage> msgs) {
    if (msgs != null)
        for (DOMMessage msg : msgs) add(msg);
    return this;
}