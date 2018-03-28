private Method getSetMethod(Class<?> argType) throws IntrospectorException {
    String methodName = "set" + capitalize(field);
    try {
        return theClass.getMethod(methodName, argType);
    } catch (NoSuchMethodException | SecurityException e) {
        throw new IntrospectorException(theClass.getName() + "." + methodName, e);
    }
}