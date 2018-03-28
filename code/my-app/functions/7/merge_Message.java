public boolean merge(Message message) {
    if (message.canMergeAttributes()) {
        this.setStringAttributes(message.getStringAttributes());
        return true;
    }
    return false;
}