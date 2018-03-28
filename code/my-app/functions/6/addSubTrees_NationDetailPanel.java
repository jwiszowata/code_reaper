public void addSubTrees(DefaultMutableTreeNode root) {
    List<Nation> nations = new ArrayList<>();
    nations.addAll(getSpecification().getEuropeanNations());
    nations.addAll(getSpecification().getIndianNations());
    super.addSubTrees(root, nations);
}