public List<ModelMessage> getNewModelMessages() {
    synchronized (this.modelMessages) {
        return transform(this.modelMessages, m -> !m.hasBeenDisplayed());
    }
}