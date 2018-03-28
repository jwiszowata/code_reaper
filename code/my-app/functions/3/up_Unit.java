public Location up() {
    return (isInEurope()) ? getLocation().up() : (isInColony()) ? getColony() : (hasTile()) ? getTile().up() : this;
}