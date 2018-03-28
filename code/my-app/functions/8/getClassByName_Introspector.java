public static Class<?> getClassByName(String name) {
    Class<?> messageClass;
    try {
        return Class.forName(name);
    } catch (ClassNotFoundException ex) {
        return null;
    }
}