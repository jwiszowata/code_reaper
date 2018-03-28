public Component add(Component comp, boolean editState) {
    if (editState) {
        if (comp instanceof UnitLabel) {
            UnitLabel label = (UnitLabel) comp;
            if (!tryWork(label.getUnit()))
                return null;
            label.setSmall(false);
        } else {
            logger.warning("An invalid component was dropped" + " on this ASingleTilePanel.");
            return null;
        }
    }
    update();
    return comp;
}