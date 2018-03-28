public Component add(Component comp, boolean editState) {
    if (editState) {
        if (!(comp instanceof GoodsLabel)) {
            logger.warning("Invalid component: " + comp);
            return null;
        }
        comp.getParent().remove(comp);
        return comp;
    }
    return add(comp);
}