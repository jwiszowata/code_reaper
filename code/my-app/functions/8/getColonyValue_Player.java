public int getColonyValue(Tile tile) {
    List<Double> values = getAllColonyValues(tile);
    if (values.get(0) < 0.0)
        return (int) Math.round(values.get(0));
    double v = 1.0;
    for (Double d : values) v *= d;
    return (int) Math.round(v);
}