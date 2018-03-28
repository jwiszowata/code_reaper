public void setGameConnected() {
    final Player player = getMyPlayer();
    if (player != null) {
        player.refilterModelMessages(getClientOptions());
    }
}