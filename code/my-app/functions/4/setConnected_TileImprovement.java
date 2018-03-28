private void setConnected(Direction direction, boolean value) {
    if (style == null || isConnectedTo(direction) != value)
        setConnected(direction, value, Integer.toString(magnitude));
}