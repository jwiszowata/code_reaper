public void selectLabel() {
    removePropertyChangeListeners();
    super.selectLabel();
    addPropertyChangeListeners();
}