public void grow(RiverSection lastSection, Tile tile) {
    boolean found = false;
    for (RiverSection section : sections) {
        if (found) {
            section.grow();
        } else if (section.getTile().equals(tile)) {
            section.setBranch(lastSection.direction.getReverseDirection(), lastSection.getSize());
            section.grow();
            found = true;
        }
    }
    drawToMap(sections);
    if (nextRiver != null) {
        RiverSection section = sections.get(sections.size() - 1);
        Tile neighbor = section.getTile().getNeighbourOrNull(section.direction);
        nextRiver.grow(section, neighbor);
    }
}