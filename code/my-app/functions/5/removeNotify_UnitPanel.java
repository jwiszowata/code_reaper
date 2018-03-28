public void removeNotify() {
    super.removeNotify();
    removePropertyChangeListeners();
    portPanel = null;
}