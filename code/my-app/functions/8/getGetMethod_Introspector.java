private Method getGetMethod() throws IntrospectorException {
    String methodName = "get" + capitalize(field);
    try {
        return theClass.getMethod(methodName);
    } catch (NoSuchMethodException | SecurityException e) {
        throw new IntrospectorException(theClass.getName() + "." + methodName, e);
    }
}