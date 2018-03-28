public void addSubTrees(DefaultMutableTreeNode root) {
    DefaultMutableTreeNode node = new DefaultMutableTreeNode(new ColopediaTreeItem(this, id, getName(), null));
    List<DefaultMutableTreeNode> nodes = new ArrayList<>();
    for (String concept : concepts) {
        String nodeId = "colopedia.concepts." + concept;
        String nodeName = Messages.getName(nodeId);
        nodes.add(new DefaultMutableTreeNode(new ColopediaTreeItem(this, nodeId, nodeName, null)));
    }
    Collections.sort(nodes, nodeComparator);
    for (DefaultMutableTreeNode n : nodes) {
        node.add(n);
    }
    root.add(node);
}