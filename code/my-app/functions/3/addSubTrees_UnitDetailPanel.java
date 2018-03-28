public void addSubTrees(DefaultMutableTreeNode root) {
    super.addSubTrees(root, getId(), new ArrayList<>(getSpecification().getUnitTypeList()));
}