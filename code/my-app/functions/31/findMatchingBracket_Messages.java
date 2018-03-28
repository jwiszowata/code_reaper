private static int findMatchingBracket(String input, int start) {
    char last = 0;
    int level = 0;
    for (int index = start; index < input.length(); index++) {
        switch(input.charAt(index)) {
            case '{':
                if (last == '{') {
                    last = 0;
                    level++;
                } else {
                    last = '{';
                }
                break;
            case '}':
                if (last == '}') {
                    if (level == 0) {
                        return index - 1;
                    } else {
                        last = 0;
                        level--;
                    }
                } else {
                    last = '}';
                }
                break;
            default:
                break;
        }
    }
    return -1;
}