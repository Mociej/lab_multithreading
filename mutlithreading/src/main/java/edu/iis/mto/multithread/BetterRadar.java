package edu.iis.mto.multithread;

public class BetterRadar {
    private static final int ROCKET_COUNT = 10;
    private PatriotBattery battery;
    public Thread launchingThread;

    public BetterRadar(PatriotBattery battery) {
        this.battery = battery;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, ROCKET_COUNT);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(enemyMissle);
            }
    }
}
