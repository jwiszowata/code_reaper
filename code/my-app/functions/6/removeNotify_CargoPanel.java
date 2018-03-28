public void removeNotify() {
    super.removeNotify();
    removeAll();
    removePropertyChangeListeners();
    defaultTransferHandler = null;
}