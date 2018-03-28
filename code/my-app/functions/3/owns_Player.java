public boolean owns(Ownable ownable) {
    return (ownable == null) ? false : this.equals(ownable.getOwner());
}