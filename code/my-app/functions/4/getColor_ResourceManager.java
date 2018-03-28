public static Color getColor(final String key) {
    final ColorResource r = getColorResource(key);
    return (r == null) ? ColorResource.REPLACEMENT_COLOR : r.getColor();
}