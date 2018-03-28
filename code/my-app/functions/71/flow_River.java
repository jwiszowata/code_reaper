private boolean flow(Tile source) {
    River other = this;
    flow: while (true) {
        if (other.sections.size() % 2 == 0) {
            int length = DirectionChange.values().length;
            int index = randomInt(logger, "Flow", random, length);
            DirectionChange change = DirectionChange.values()[index];
            other.direction = change.getNewDirection(other.direction);
            other.logger.fine("Direction is now " + other.direction);
        }
        for (DirectionChange change : DirectionChange.values()) {
            Direction dir = change.getNewDirection(other.direction);
            Tile nextTile = source.getNeighbourOrNull(dir);
            if (nextTile == null)
                continue;
            if (!other.riverType.isTileTypeAllowed(nextTile.getType())) {
                other.logger.fine("Tile (" + nextTile + ") can not have a river.");
                continue;
            } else if (other.contains(nextTile)) {
                other.logger.fine("Tile (" + nextTile + ") is already in river.");
                continue;
            } else if (other.isNextToSelf(nextTile)) {
                other.logger.fine("Tile (" + nextTile + ") is next to the river.");
                continue;
            } else {
                for (DirectionChange change2 : DirectionChange.values()) {
                    Direction lastDir = change2.getNewDirection(dir);
                    Tile t = nextTile.getNeighbourOrNull(lastDir);
                    if (t == null)
                        continue;
                    if (t.isLand() && !t.hasRiver())
                        continue;
                    other.sections.add(new RiverSection(source, dir));
                    RiverSection lastSection = new RiverSection(nextTile, lastDir);
                    other.sections.add(lastSection);
                    if (t.hasRiver() && t.isLand()) {
                        other.logger.fine("Tile (" + t + ") is next to another river.");
                        other.nextRiver = other.riverMap.get(t);
                        other.nextRiver.grow(lastSection, t);
                        other.connected |= other.nextRiver.connected;
                        if (other.getLength() < 10) {
                            other.region = other.nextRiver.region;
                        }
                        other.drawToMap(sections);
                    } else {
                        other.logger.fine("Tile (" + t + ") is next to water.");
                        River someRiver = other.riverMap.get(t);
                        if (someRiver == null) {
                            other.sections.add(new RiverSection(t, lastDir.getReverseDirection()));
                            if (lastSection.getSize() < TileImprovement.FJORD_RIVER) {
                                other.createDelta(nextTile, lastDir, lastSection);
                            }
                        } else {
                            RiverSection waterSection = someRiver.getLastSection();
                            waterSection.setBranch(lastDir.getReverseDirection(), TileImprovement.SMALL_RIVER);
                        }
                        other.connected |= t.isHighSeasConnected();
                        other.drawToMap(sections);
                    }
                    return true;
                }
                other.logger.fine("Tile (" + nextTile + ") is suitable.");
                other.sections.add(new RiverSection(source, dir));
                source = nextTile;
                continue flow;
            }
        }
        other.sections = new ArrayList<>();
        return false;
    }
}