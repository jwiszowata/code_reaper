public void fixupRegions() {
    for (Region r : transform(regions, r -> !r.isPacific())) {
        Region p = r.getParent();
        if (r.getDiscoverable() && p != null && p.getDiscoverable()) {
            p = p.getParent();
            r.setParent(p);
        }
        if (p != null && !p.getChildren().contains(r))
            p.addChild(r);
    }
}