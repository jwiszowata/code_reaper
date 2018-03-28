public void valueChanged(TreeSelectionEvent event) {
    detailPanel.removeAll();
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    if (node != null) {
        if (node.isLeaf()) {
            OptionGroup group = (OptionGroup) node.getUserObject();
            for (Option option : group.getOptions()) {
                addOptionUI(option, editable && group.isEditable());
            }
        } else {
            tree.expandPath(event.getPath());
        }
    }
    detailPanel.revalidate();
    detailPanel.repaint();
}