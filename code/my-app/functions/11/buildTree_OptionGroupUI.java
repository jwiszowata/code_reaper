private void buildTree(OptionGroup group, DefaultMutableTreeNode parent) {
    for (Option option : group.getOptions()) {
        if (option instanceof OptionGroup) {
            if (!((OptionGroup) option).isVisible())
                continue;
            DefaultMutableTreeNode branch = new DefaultMutableTreeNode(option);
            parent.add(branch);
            buildTree((OptionGroup) option, branch);
        }
    }
}