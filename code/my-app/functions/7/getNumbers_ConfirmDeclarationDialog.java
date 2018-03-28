private String[] getNumbers(int count) {
    String[] result = new String[count];
    for (int index = 0; index < count; index++) {
        result[index] = Integer.toString(index + 1);
    }
    return result;
}