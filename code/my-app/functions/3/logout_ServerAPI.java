public boolean logout(Player player, LogoutReason reason) {
    return ask(player.getGame(), new LogoutMessage(player, reason));
}