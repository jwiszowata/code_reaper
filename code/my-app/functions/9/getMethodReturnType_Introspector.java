private Class<?> getMethodReturnType(Method method) throws IntrospectorException {
    Class<?> ret;
    try {
        ret = method.getReturnType();
    } catch (Exception e) {
        throw new IntrospectorException(theClass.getName() + "." + method.getName() + " return type.", e);
    }
    return ret;
}