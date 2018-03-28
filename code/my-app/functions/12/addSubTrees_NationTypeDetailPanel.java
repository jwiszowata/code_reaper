public void addSubTrees(DefaultMutableTreeNode root) {
    DefaultMutableTreeNode parent = new DefaultMutableTreeNode(new ColopediaTreeItem(this, getId(), getName(), null));
    List<NationType> nations = new ArrayList<>();
    nations.addAll(getSpecification().getEuropeanNationTypes());
    nations.addAll(getSpecification().getREFNationTypes());
    nations.addAll(getSpecification().getIndianNationTypes());
    ImageIcon icon = new ImageIcon(ImageLibrary.getMiscImage(ImageLibrary.BELLS, ImageLibrary.ICON_SIZE));
    for (NationType type : nations) {
        parent.add(buildItem(type, icon));
    }
    root.add(parent);
}