package edu.iis.mto.multithread;
import java.util.concurrent.ExecutorService;


public class BetterRadar {
    private static int ROCKET_COUNT = 10;
    private PatriotBattery battery;
    public ExecutorService executor;

    public BetterRadar(PatriotBattery battery,ExecutorService executor) {
        this.battery = battery;
        this.executor = executor;
    }
    public BetterRadar(PatriotBattery battery,ExecutorService executor,int newrocketcount) {
        this.battery = battery;
        this.executor = executor;
        this.ROCKET_COUNT = newrocketcount;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, ROCKET_COUNT);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) {
        executor.execute( () -> {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(enemyMissle);
            }
        });
    }
}
