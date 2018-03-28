private List<BuildableType> getBuildableTypes(JList<? extends BuildableType> list) {
    List<BuildableType> result = new ArrayList<>();
    if (list == null)
        return result;
    ListModel<? extends BuildableType> model = list.getModel();
    for (int index = 0; index < model.getSize(); index++) {
        result.add(model.getElementAt(index));
    }
    return result;
}