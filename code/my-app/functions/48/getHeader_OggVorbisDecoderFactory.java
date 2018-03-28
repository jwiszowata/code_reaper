private String getHeader() {
    String input;
    int packet = 0;
    oggSyncState.init();
    while (packet < 1) {
        switch(oggSyncState.pageout(oggPage)) {
            case 1:
                oggStreamState.init(oggPage.serialno());
                oggStreamState.reset();
                orbisInfo.init();
                orbisComment.init();
                if (oggStreamState.pagein(oggPage) == -1) {
                    return "Error on header page";
                }
                if (oggStreamState.packetout(oggPacket) != 1) {
                    return "Error on first packet";
                }
                if (orbisInfo.synthesis_headerin(orbisComment, oggPacket) < 0) {
                    return "Non-vorbis data found";
                }
                packet = 1;
                break;
            case 0:
                if ((input = getInput()) != null)
                    return input;
                break;
            default:
                return "Error reading first page";
        }
    }
    while (packet < 3) {
        switch(oggStreamState.packetout(oggPacket)) {
            case 1:
                orbisInfo.synthesis_headerin(orbisComment, oggPacket);
                packet++;
                break;
            case 0:
                if ((input = getPage()) != null)
                    return input;
                break;
            default:
                return "Error in header packet " + packet;
        }
    }
    orbisDspState.synthesis_init(orbisInfo);
    orbisBlock.init(orbisDspState);
    return null;
}