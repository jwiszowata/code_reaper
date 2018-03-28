public static Object instantiate(String tag, Class[] types, Object[] params) throws IntrospectorException {
    Class<?> messageClass;
    try {
        messageClass = Class.forName(tag);
    } catch (ClassNotFoundException ex) {
        throw new IntrospectorException("Unable to find class " + tag, ex);
    }
    return instantiate(messageClass, types, params);
}