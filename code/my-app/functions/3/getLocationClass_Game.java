public static Class<? extends FreeColGameObject> getLocationClass(String id) {
    return locationClasses.get(capitalize(FreeColObject.getIdType(id)));
}