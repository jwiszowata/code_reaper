public Component add(Component comp, boolean editState) {
    Component c = add(comp);
    update();
    return c;
}