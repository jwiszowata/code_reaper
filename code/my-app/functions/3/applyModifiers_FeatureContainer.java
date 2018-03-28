public final float applyModifiers(float number, Turn turn, String id, FreeColSpecObjectType fcgot) {
    return applyModifiers(number, turn, getModifiers(id, fcgot, turn));
}