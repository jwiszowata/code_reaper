public Component add(Component comp, boolean editState) {
    if (carrier == null) {
        return null;
    } else if (editState && comp instanceof CargoLabel) {
        return ((CargoLabel) comp).addCargo(comp, carrier, this);
    } else {
        super.add(comp);
    }
    logger.log(Level.FINER, "Attempted to add a component to an invalid carrier.");
    return null;
}