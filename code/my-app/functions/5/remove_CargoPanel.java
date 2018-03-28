public void remove(Component comp) {
    if (comp instanceof CargoLabel) {
        ((CargoLabel) comp).removeCargo(comp, this);
    }
}