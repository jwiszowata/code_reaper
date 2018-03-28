public Color getNationColor() {
    final Nation nation = getNation();
    Color color = nation.getColor();
    return (color != null) ? color : nation.forceDefaultColor();
}