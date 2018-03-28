public Player getOtherPlayer(Player player) {
    return (this.sender == player) ? this.recipient : this.sender;
}