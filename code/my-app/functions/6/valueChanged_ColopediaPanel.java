public void valueChanged(TreeSelectionEvent event) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    if (node != null) {
        showDetails((ColopediaTreeItem) node.getUserObject());
    }
}