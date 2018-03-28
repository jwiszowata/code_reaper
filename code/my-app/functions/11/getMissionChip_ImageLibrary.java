public BufferedImage getMissionChip(Graphics2D g, Player owner, boolean expert) {
    Color background = owner.getNationColor();
    String key = "color.foreground.mission." + ((expert) ? "expert" : "normal");
    Color foreground;
    if (ResourceManager.hasColorResource(key)) {
        foreground = ResourceManager.getColor(key);
    } else {
        foreground = (expert) ? Color.BLACK : Color.GRAY;
    }
    return createChip(g, ResourceManager.getString("cross"), Color.BLACK, background, foreground);
}