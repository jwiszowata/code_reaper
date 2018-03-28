public boolean rename(FreeColGameObject object, String name) {
    return ask(object.getGame(), new RenameMessage(object, name));
}