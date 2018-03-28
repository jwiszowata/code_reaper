public Component addCargo(Component comp, Unit carrier, CargoPanel cargoPanel) {
    Unit unit = ((UnitLabel) comp).getUnit();
    if (carrier.canAdd(unit)) {
        Container oldParent = comp.getParent();
        if (cargoPanel.igc().boardShip(unit, carrier)) {
            ((UnitLabel) comp).setSmall(false);
            if (oldParent != null)
                oldParent.remove(comp);
            cargoPanel.update();
            return comp;
        }
    }
    return null;
}