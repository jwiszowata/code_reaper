public void actionPerformed(ActionEvent ae) {
    setSelected(((JCheckBoxMenuItem) ae.getSource()).isSelected());
    setOption(isSelected());
    getGUI().refresh();
}