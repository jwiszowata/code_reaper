public StringTemplate getLocationLabelFor(Player player) {
    return (getOwner() == player) ? getLocationLabel() : getColony().getLocationLabelFor(player);
}