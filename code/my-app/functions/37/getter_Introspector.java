public String getter(Object obj) throws IntrospectorException {
    Method getMethod = getGetMethod();
    Class<?> fieldType = getMethodReturnType(getMethod);
    if (fieldType == String.class) {
        try {
            return (String) getMethod.invoke(obj);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new IntrospectorException(getMethod.getName() + "(obj)", e);
        }
    } else {
        Object result = null;
        try {
            result = getMethod.invoke(obj);
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            throw new IntrospectorException(getMethod.getName() + "(obj)", e);
        }
        Method convertMethod;
        try {
            convertMethod = getToStringConverter(fieldType);
        } catch (NoSuchMethodException nsme) {
            throw new IntrospectorException("No String converter found for " + fieldType, nsme);
        }
        if (Modifier.isStatic(convertMethod.getModifiers())) {
            try {
                return (String) convertMethod.invoke(null, result);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new IntrospectorException(convertMethod.getName() + "(null, result)", e);
            }
        } else {
            try {
                return (String) convertMethod.invoke(result);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new IntrospectorException(convertMethod.getName() + "(result)", e);
            }
        }
    }
}