private static StringBuilder prettyPrint(int number) {
    StringBuilder output = new StringBuilder(4);
    if (number < 10)
        output.append(' ');
    if (number < 100)
        output.append(' ');
    if (number < 1000)
        output.append(' ');
    output.append(number);
    return output;
}