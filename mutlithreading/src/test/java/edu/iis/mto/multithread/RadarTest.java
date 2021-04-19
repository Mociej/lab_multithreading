package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;
    @Mock
    private ExecutorService executor;

    @RepeatedTest(15)
    void launchOne() {
        Scud enemyMissle = new Scud();
        BetterRadar radar = new BetterRadar(batteryMock, executor);
        radar.notice(enemyMissle);
        verify(executor).execute(any(Runnable.class));
    }


}
