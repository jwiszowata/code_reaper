public void displayChatMessage(GUIMessage message) {
    chatDisplay.addMessage(message);
    repaint(0, 0, getWidth(), getHeight());
}