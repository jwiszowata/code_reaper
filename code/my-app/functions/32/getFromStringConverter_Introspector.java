private Method getFromStringConverter(Class<?> argType) {
    Method method;
    if (argType.isEnum()) {
        try {
            method = Enum.class.getMethod("valueOf", Class.class, String.class);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new IllegalArgumentException("Enum.getMethod(valueOf(Class, String))", e);
        }
    } else {
        if (argType.isPrimitive()) {
            if (argType == Integer.TYPE) {
                argType = Integer.class;
            } else if (argType == Boolean.TYPE) {
                argType = Boolean.class;
            } else if (argType == Float.TYPE) {
                argType = Float.class;
            } else if (argType == Double.TYPE) {
                argType = Double.class;
            } else if (argType == Character.TYPE) {
                argType = Character.class;
            } else {
                throw new IllegalArgumentException("Need compatible class for primitive " + argType.getName());
            }
        }
        try {
            method = argType.getMethod("valueOf", String.class);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new IllegalArgumentException(argType.getName() + ".getMethod(valueOf(String))", e);
        }
    }
    return method;
}