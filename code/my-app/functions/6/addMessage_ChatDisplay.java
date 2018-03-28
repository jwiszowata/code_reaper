public synchronized void addMessage(GUIMessage message) {
    if (getMessageCount() == MESSAGE_COUNT) {
        messages.remove(0);
    }
    messages.add(message);
}