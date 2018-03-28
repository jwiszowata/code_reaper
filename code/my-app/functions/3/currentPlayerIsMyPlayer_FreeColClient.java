public boolean currentPlayerIsMyPlayer() {
    return this.inGame && this.game != null && this.player != null && this.player.equals(this.game.getCurrentPlayer());
}