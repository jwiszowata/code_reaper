private void chat(Element element) {
    final Game game = getGame();
    final ChatMessage chatMessage = new ChatMessage(game, element);
    getGUI().displayChatMessage(chatMessage.getPlayer(game), chatMessage.getMessage(), chatMessage.isPrivate());
}