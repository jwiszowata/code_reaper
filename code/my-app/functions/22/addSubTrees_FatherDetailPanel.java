public void addSubTrees(DefaultMutableTreeNode root) {
    final Specification spec = getSpecification();
    DefaultMutableTreeNode parent = new DefaultMutableTreeNode(new ColopediaTreeItem(this, getId(), getName(), null));
    EnumMap<FoundingFatherType, List<FoundingFather>> fathersByType = new EnumMap<>(FoundingFatherType.class);
    for (FoundingFatherType fatherType : FoundingFatherType.values()) {
        fathersByType.put(fatherType, new ArrayList<FoundingFather>());
    }
    for (FoundingFather foundingFather : spec.getFoundingFathers()) {
        fathersByType.get(foundingFather.getType()).add(foundingFather);
    }
    ImageIcon icon = new ImageIcon(ImageLibrary.getMiscImage(ImageLibrary.BELLS, ImageLibrary.ICON_SIZE));
    for (FoundingFatherType fatherType : FoundingFatherType.values()) {
        String id = FoundingFather.getTypeKey(fatherType);
        String typeName = Messages.message(id);
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(new ColopediaTreeItem(this, id, typeName, null));
        parent.add(node);
        for (FoundingFather father : fathersByType.get(fatherType)) {
            node.add(buildItem(father, icon));
        }
    }
    root.add(parent);
}