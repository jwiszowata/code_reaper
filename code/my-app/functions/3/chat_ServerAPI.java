public boolean chat(Player player, String chat) {
    return send(new ChatMessage(player, chat, false));
}