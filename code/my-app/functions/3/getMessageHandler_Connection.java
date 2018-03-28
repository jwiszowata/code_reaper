private MessageHandler getMessageHandler() {
    return (this.domMessageHandler instanceof MessageHandler) ? (MessageHandler) this.domMessageHandler : null;
}