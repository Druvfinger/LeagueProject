package Champion;

import java.util.Map;

public record ChampionData(
        String type,
        String format,
        String version,
        Map<String, Champion> data
) {
}
