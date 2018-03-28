public void addModelMessage(ModelMessage modelMessage) {
    synchronized (this.modelMessages) {
        this.modelMessages.add(modelMessage);
    }
}