private SimpleZippedAnimation getAnimation(Unit unit, Direction direction) {
    float scale = ((SwingGUI) getGUI()).getMapScale();
    String roleStr = (unit.hasDefaultRole()) ? "" : "." + unit.getRoleSuffix();
    String startStr = "animation.unit." + unit.getType().getId() + roleStr + ".attack.";
    SimpleZippedAnimation sza;
    sza = getAnimation(startStr, scale, direction);
    if (sza != null)
        return sza;
    sza = getAnimation(startStr, scale, direction.getNextDirection());
    if (sza != null)
        return sza;
    sza = getAnimation(startStr, scale, direction.getPreviousDirection());
    if (sza != null)
        return sza;
    sza = getAnimation(startStr, scale, direction.getNextDirection().getNextDirection());
    if (sza != null)
        return sza;
    sza = getAnimation(startStr, scale, direction.getPreviousDirection().getPreviousDirection());
    if (sza != null)
        return sza;
    sza = getAnimation(startStr, scale, direction.getNextDirection().getNextDirection().getNextDirection());
    if (sza != null)
        return sza;
    sza = getAnimation(startStr, scale, direction.getPreviousDirection().getPreviousDirection().getPreviousDirection());
    if (sza != null)
        return sza;
    sza = getAnimation(startStr, scale, direction.getReverseDirection());
    return sza;
}