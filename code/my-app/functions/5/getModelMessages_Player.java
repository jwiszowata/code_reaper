public List<ModelMessage> getModelMessages() {
    synchronized (this.modelMessages) {
        return new ArrayList<>(this.modelMessages);
    }
}