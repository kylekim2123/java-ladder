package ladder.view;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ladder.view.io.Input;
import ladder.view.io.Output;

public class LadderInputView {

    private static final String NAMES_DELIMITER = ",";
    private static final Pattern namesPattern = Pattern.compile(
            "^[a-zA-Z0-9\\uAC00-\\uD7A3]+(,[a-zA-Z0-9\\uAC00-\\uD7A3]+)*$");

    private final Input input;
    private final Output output;

    public LadderInputView(final Input input, final Output output) {
        this.input = input;
        this.output = output;
    }

    public List<String> readPlayerNames() {
        output.printLine("참여할 플레이어들의 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        return readLineWithDelimiter();
    }

    public List<String> readItemNames() {
        output.printLine("\n실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        return readLineWithDelimiter();
    }

    private List<String> readLineWithDelimiter() {
        final String userInput = input.readLine();

        validateUserInputMatchesNamesPattern(userInput);

        return List.of(userInput.split(NAMES_DELIMITER));
    }

    private void validateUserInputMatchesNamesPattern(final String userInput) {
        final Matcher matcher = namesPattern.matcher(userInput);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("입력하신 문자열이 형식에 맞지 않습니다. 입력 : " + userInput);
        }
    }

    public int readLadderHeight() {
        output.printLine("\n최대 사다리 높이는 몇 개인가요?");
        final String userInput = input.readLine();

        try {
            return Integer.parseInt(userInput);
        } catch (final NumberFormatException e) {
            throw new IllegalArgumentException("사다리 높이는 정수 형태로 입력해야 합니다. 입력: " + userInput);
        }
    }

    public String readResultPlayerName() {
        output.printLine("\n결과를 보고 싶은 사람은? (종료하려면 -1을 입력하세요.)");

        return input.readLine();
    }
}
