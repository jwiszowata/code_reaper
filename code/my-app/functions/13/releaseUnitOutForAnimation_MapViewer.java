private void releaseUnitOutForAnimation(final Unit unit) {
    Integer i = unitsOutForAnimation.get(unit);
    if (i == null) {
        throw new IllegalStateException("Tried to release unit that was not out for animation");
    }
    if (i == 1) {
        unitsOutForAnimation.remove(unit);
        gui.getCanvas().removeFromCanvas(unitsOutForAnimationLabels.remove(unit));
    } else {
        i--;
        unitsOutForAnimation.put(unit, i);
    }
}