public void setVisible(boolean val) {
    if (val)
        this.pane.selectInitialValue();
    super.setVisible(val);
}