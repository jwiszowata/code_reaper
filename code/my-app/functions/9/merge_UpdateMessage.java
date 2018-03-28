public boolean merge(Message message) {
    if (message instanceof UpdateMessage) {
        UpdateMessage other = (UpdateMessage) message;
        this.fcgos.addAll(other.getObjects());
        this.fields.addAll(other.getFields());
        return true;
    }
    return false;
}