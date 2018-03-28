public Component add(Component comp, boolean editState) {
    if (editState) {
        if (comp instanceof UnitLabel) {
            if (!tryWork(((UnitLabel) comp).getUnit()))
                return null;
        } else {
            logger.warning("An invalid component was dropped" + " on this ASingleBuildingPanel.");
            return null;
        }
        update();
    }
    return null;
}