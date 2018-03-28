public Player getOwner() {
    return (parent instanceof Ownable) ? ((Ownable) parent).getOwner() : null;
}