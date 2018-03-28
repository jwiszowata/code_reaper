public Player getClientPlayer() {
    return (this.clientUserName == null) ? null : getPlayerByName(this.clientUserName);
}