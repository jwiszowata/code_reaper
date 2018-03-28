private Method getToStringConverter(Class<?> argType) throws NoSuchMethodException {
    return (argType.isEnum()) ? argType.getMethod("name") : String.class.getMethod("valueOf", argType);
}