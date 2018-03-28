protected <T> T invokeMethod(String methodName, Class<T> returnClass, T defaultValue) {
    if (methodName != null && returnClass != null) {
        try {
            return Introspector.invokeMethod(this, methodName, returnClass);
        } catch (Exception ex) {
            logger.log(Level.WARNING, "Invoke failed: " + methodName, ex);
        }
    }
    return defaultValue;
}