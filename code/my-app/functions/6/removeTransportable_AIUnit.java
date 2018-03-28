public void removeTransportable(AIGoods ag) {
    TransportMission tm = getMission(TransportMission.class);
    if (tm != null) {
        tm.removeTransportable(ag);
    }
}