public void removeDisplayedModelMessages() {
    synchronized (this.modelMessages) {
        removeInPlace(this.modelMessages, ModelMessage::hasBeenDisplayed);
    }
}