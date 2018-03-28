public void notifyOwnerChanged(FreeColGameObject source, Player oldOwner, Player newOwner) {
    if (freeColGameObjectListener != null) {
        freeColGameObjectListener.ownerChanged(source, oldOwner, newOwner);
    }
}