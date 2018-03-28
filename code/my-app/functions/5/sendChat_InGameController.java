public boolean sendChat(String chat) {
    if (chat == null)
        return false;
    return askServer().chat(getMyPlayer(), chat);
}