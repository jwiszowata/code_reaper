public void actionPerformed(ActionEvent ae) {
    ColorButton button = (ColorButton) ae.getSource();
    Color color = JColorChooser.showDialog(this, this.label.getText(), button.getBackground());
    button.setColor(color);
    setColors();
    this.label.setIcon(new ImageIcon(this.flag.getImage()));
}