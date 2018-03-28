private JTree buildTree() {
    String name = Messages.message("colopedia");
    DefaultMutableTreeNode root = new DefaultMutableTreeNode(new ColopediaTreeItem(null, null, name, null));
    FreeColClient fcc = getFreeColClient();
    new TerrainDetailPanel(fcc, this).addSubTrees(root);
    new ResourcesDetailPanel(fcc, this).addSubTrees(root);
    new GoodsDetailPanel(fcc, this).addSubTrees(root);
    new UnitDetailPanel(fcc, this).addSubTrees(root);
    new BuildingDetailPanel(fcc, this).addSubTrees(root);
    new FatherDetailPanel(fcc, this).addSubTrees(root);
    new NationDetailPanel(fcc, this).addSubTrees(root);
    new NationTypeDetailPanel(fcc, this).addSubTrees(root);
    new ConceptDetailPanel(fcc, this).addSubTrees(root);
    DefaultTreeModel treeModel = new DefaultTreeModel(root);
    tree = new JTree(treeModel) {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension((int) (200 * getImageLibrary().getScaleFactor()), super.getPreferredSize().height);
        }
    };
    tree.setRootVisible(false);
    tree.setCellRenderer(new ColopediaTreeCellRenderer());
    tree.setOpaque(false);
    tree.addTreeSelectionListener(this);
    listPanel.add(tree);
    Enumeration allNodes = root.depthFirstEnumeration();
    while (allNodes.hasMoreElements()) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) allNodes.nextElement();
        ColopediaTreeItem item = (ColopediaTreeItem) node.getUserObject();
        nodeMap.put(item.getId(), node);
    }
    return tree;
}