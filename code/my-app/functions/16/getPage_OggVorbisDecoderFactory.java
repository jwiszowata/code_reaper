private String getPage() {
    String input;
    for (; ; ) {
        switch(oggSyncState.pageout(oggPage)) {
            case 0:
                if ((input = getInput()) != null)
                    return input;
                break;
            case 1:
                oggStreamState.pagein(oggPage);
                return null;
            default:
                return "Bogus page";
        }
    }
}