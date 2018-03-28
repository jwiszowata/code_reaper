public StringTemplate getColonyTileLocationLabel(Colony colony) {
    Tile ct = colony.getTile();
    StringTemplate t = StringTemplate.template("model.tile.nameLocation");
    if (ct == this) {
        t.addStringTemplate("%location%", StringTemplate.key("colonyCenter"));
    } else {
        Direction d = getMap().getDirection(ct, this);
        if (d == null)
            return null;
        t.addNamed("%location%", d);
    }
    if (type == null) {
        t.add("%name%", "unexplored");
    } else {
        t.addNamed("%name%", type);
    }
    return t;
}