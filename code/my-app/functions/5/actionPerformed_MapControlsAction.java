public void actionPerformed(ActionEvent ae) {
    setSelected(((AbstractButton) ae.getSource()).isSelected());
    setOption(isSelected());
    update();
}