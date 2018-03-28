protected DefaultMutableTreeNode buildItem(FreeColSpecObjectType type, ImageIcon icon) {
    String name = Messages.getName(type);
    return new DefaultMutableTreeNode(new ColopediaTreeItem(this, type.getId(), name, icon));
}