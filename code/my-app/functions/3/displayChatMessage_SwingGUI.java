public void displayChatMessage(Player player, String message, boolean privateChat) {
    canvas.displayChatMessage(new GUIMessage(player.getName() + ": " + message, player.getNationColor()));
}