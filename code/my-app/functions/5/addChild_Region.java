public void addChild(Region child) {
    if (this.children == null)
        this.children = new ArrayList<>();
    this.children.add(child);
}