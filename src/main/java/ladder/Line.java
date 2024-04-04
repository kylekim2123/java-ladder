package ladder;

import static java.lang.Boolean.FALSE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Line {

    private final List<Boolean> connections;

    Line(final List<Boolean> connections) {
        this.connections = connections;
    }

    public static Line from(final PlayersCount playersCount, final ConnectionGenerator connectionGenerator) {
        return new Line(createConnections(playersCount, connectionGenerator));
    }

    private static List<Boolean> createConnections(
            final PlayersCount playersCount,
            final ConnectionGenerator connectionGenerator
    ) {
        final List<Boolean> connections = new ArrayList<>();
        connections.add(connectionGenerator.generate());

        IntStream.range(1, playersCount.value())
                .mapToObj(i -> connections.get(i - 1) ? FALSE : connectionGenerator.generate())
                .forEach(connections::add);

        return connections;
    }

    @Override
    public boolean equals(final Object otherLine) {
        if (this == otherLine) {
            return true;
        }

        if (otherLine == null || getClass() != otherLine.getClass()) {
            return false;
        }

        return Objects.equals(this.connections, ((Line)otherLine).connections);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.connections);
    }
}
