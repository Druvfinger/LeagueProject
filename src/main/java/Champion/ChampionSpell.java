package Champion;

import java.util.List;
public record ChampionSpell(
        String id,
        String name,
        String description,
        String tooltip,
        LevelTip leveltip,
        int maxrank,
        List<Integer> cooldown,
        String cooldownBurn,
        List<Integer> cost,
        String costBurn,
        List<List<Integer>> effect,
        List<String> effectBurn,
        String costType,
        int maxammo,
        List<Long> range,
        String rangeBurn,
        ChampionImage image,
        String resource,
        Object datavalues,
        List<Object> vars
) {
}
