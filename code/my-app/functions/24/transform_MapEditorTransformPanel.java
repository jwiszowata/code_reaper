public void transform(Tile t) {
    Resource resource = null;
    if (t.getTileItemContainer() != null) {
        resource = t.getTileItemContainer().getResource();
    }
    if (resource != null) {
        t.getTileItemContainer().removeTileItem(resource);
    } else {
        List<ResourceType> resList = t.getType().getResourceTypes();
        switch(resList.size()) {
            case 0:
                return;
            case 1:
                ResourceType resourceType = first(resList);
                t.addResource(new Resource(t.getGame(), t, resourceType, resourceType.getMaxValue()));
                return;
            default:
                ResourceType choice = getResourceChoice(resList);
                if (choice != null) {
                    t.addResource(new Resource(t.getGame(), t, choice, choice.getMaxValue()));
                }
        }
    }
}