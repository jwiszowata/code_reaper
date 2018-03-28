public void setMessages(List<ModelMessage> messages) {
    reportPanel.removeAll();
    this.messages.clear();
    if (messages != null)
        this.messages.addAll(messages);
    displayMessages();
}