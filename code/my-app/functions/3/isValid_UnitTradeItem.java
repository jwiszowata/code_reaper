public boolean isValid() {
    return unit.getOwner() == getSource() && unit.getType().isAvailableTo(getDestination());
}