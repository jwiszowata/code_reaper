public static <T> T construct(Constructor<T> constructor, Object[] params) {
    T instance;
    try {
        instance = constructor.newInstance(params);
    } catch (IllegalAccessException | InstantiationException | InvocationTargetException ex) {
        instance = null;
    }
    return instance;
}