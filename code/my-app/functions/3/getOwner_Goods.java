public Player getOwner() {
    return (this.location instanceof Ownable) ? ((Ownable) this.location).getOwner() : null;
}