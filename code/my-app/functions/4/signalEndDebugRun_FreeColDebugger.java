public static void signalEndDebugRun() {
    if (debugRunTurns > 0)
        setDebugRunTurns(0);
}