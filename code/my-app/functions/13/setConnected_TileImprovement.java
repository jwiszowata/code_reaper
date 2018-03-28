private void setConnected(Direction direction, boolean value, String magnitude) {
    String old = (style == null) ? "00000000" : style.getString();
    List<Direction> directions = getConnectionDirections();
    int end = directions.size();
    StringBuilder updated = new StringBuilder();
    for (int index = 0; index != end; ++index) {
        if (directions.get(index) == direction)
            updated.append(value ? magnitude : "0");
        else
            updated.append(old.charAt(index));
    }
    style = TileImprovementStyle.getInstance(updated.toString());
}