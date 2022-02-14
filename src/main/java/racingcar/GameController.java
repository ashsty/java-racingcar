package racingcar;

import racingcar.domain.Cars;
import racingcar.utils.StringSeparator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Scanner;

public class GameController {
    private final Scanner scanner;

    public GameController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void run() {
        String carNames = InputView.getCarNames(scanner);
        Cars cars = new Cars(StringSeparator.splitAndTrim(carNames));
        int moveCount = Integer.parseInt(InputView.getMoveCount(scanner));
        OutputView.printResultMessage();
        startRace(cars, moveCount);
        OutputView.printWinners(cars.findWinners());
    }

    private void startRace(Cars cars, int moveCount) {
        for (int i = 0; i < moveCount; i++) {
            cars.startEachRace();
            OutputView.printCarsPosition(cars);
        }
    }
}