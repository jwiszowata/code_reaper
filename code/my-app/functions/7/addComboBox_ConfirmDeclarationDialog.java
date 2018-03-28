private <T> void addComboBox(JPanel panel, JComboBox<T> box, String prefix, T value) {
    box.setRenderer(new EnumRenderer<T>(prefix));
    box.setSelectedItem(value);
    box.addItemListener(this);
    panel.add(Utility.localizedLabel(prefix + "label"));
    panel.add(box);
}