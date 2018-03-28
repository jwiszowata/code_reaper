private static String findArg(String option, String[] args) {
    for (int i = args.length - 2; i >= 0; i--) {
        if (option.equals(args[i])) {
            return args[i + 1];
        }
    }
    return null;
}