public static <T> boolean equals(T one, T two) {
    return (one == null) ? (two == null) : one.equals(two);
}