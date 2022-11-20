package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String START_GUIDE = "다리 건너기 게임을 시작합니다.";

    public void printStart() {
        System.out.println(START_GUIDE);
        System.out.println();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, int index, boolean same) {
        System.out.println("[" + getMap(bridge, index, "U", same) + "]");
        System.out.println("[" + getMap(bridge, index, "D", same) + "]");
    }

    private String getMap(List<String> bridge, int index, String moving, boolean same) {
        StringBuilder map = new StringBuilder();
        for (int i = 0; i < index; i++) {
            map.append(getStatus(bridge.get(i), moving));
        }
        map.append(getLastStatus(bridge.get(index), moving, same));
        return map.toString();
    }

    private String getStatus(String bridge, String moving) {
        if (bridge.equals(moving)) {
            return " O |";
        }
        return "   |";
    }

    private String getLastStatus(String bridge, String moving, boolean same) {
        if (bridge.equals(moving) && same) {
            return " O ";
        } else if (bridge.equals(moving)) {
            return " X ";
        }
        return "   ";
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(boolean success, int tryCount) {
        System.out.println("게임 성공 여부: " + (success ? "성공" : "실패"));
        System.out.println("총 시도한 횟수: " + tryCount);
        System.out.println();
    }
}
