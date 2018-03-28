public static <T> Constructor<T> getConstructor(Class<T> cl, Class[] types) {
    Constructor<T> constructor;
    try {
        constructor = cl.getDeclaredConstructor(types);
    } catch (NoSuchMethodException | SecurityException ex) {
        constructor = null;
    }
    return constructor;
}