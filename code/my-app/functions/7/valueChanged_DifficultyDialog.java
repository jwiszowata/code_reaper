public void valueChanged(TreeSelectionEvent event) {
    TreePath path = event.getPath();
    if (path.getPathCount() >= 2) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getPathComponent(1);
        this.selected = (OptionGroup) node.getUserObject();
    }
}