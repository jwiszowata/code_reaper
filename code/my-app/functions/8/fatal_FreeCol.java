public static void fatal(String err) {
    if (err == null || err.isEmpty()) {
        err = "Bogus null fatal error message";
        Thread.dumpStack();
    }
    System.err.println(err);
    System.exit(1);
}