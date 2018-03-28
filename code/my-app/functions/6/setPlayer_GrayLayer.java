public void setPlayer(Player player) {
    if (this.player == player)
        return;
    this.player = player;
    repaint();
}