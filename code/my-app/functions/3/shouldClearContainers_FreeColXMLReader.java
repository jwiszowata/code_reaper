public boolean shouldClearContainers() {
    return !hasAttribute(FreeColSpecObjectType.EXTENDS_TAG) && !hasAttribute(FreeColSpecObjectType.PRESERVE_TAG);
}