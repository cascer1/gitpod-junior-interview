package be.nn.hiring.junior.fish;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import be.nn.hiring.junior.fish.FishSimulator;

class FishSimulatorTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/fishTestData.csv", numLinesToSkip = 1)
    void testSimulators(int days, long expected, String input) {

        FishSimulator simulator = new FishSimulator();
        long result = simulator.simulate(input, days);

        assertEquals(expected, result);
    }

}