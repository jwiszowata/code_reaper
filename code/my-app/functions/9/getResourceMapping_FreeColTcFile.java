public ResourceMapping getResourceMapping() {
    ResourceMapping result = new ResourceMapping();
    if (getParent() != null) {
        final FreeColTcFile parentTcData = FreeColTcFile.getFreeColTcFile(getParent());
        result.addAll(parentTcData.getResourceMapping());
    }
    result.addAll(super.getResourceMapping());
    return result;
}