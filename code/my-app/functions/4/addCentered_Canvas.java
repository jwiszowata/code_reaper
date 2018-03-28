private void addCentered(Component comp, Integer i) {
    comp.setLocation((getWidth() - comp.getWidth()) / 2, (getHeight() - comp.getHeight()) / 2);
    this.add(comp, i);
}