public void removeNotify() {
    super.removeNotify();
    removeAll();
    detailPanel = null;
    listPanel = null;
    tree = null;
    nodeMap = null;
}