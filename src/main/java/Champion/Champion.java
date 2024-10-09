package Champion;

import java.util.List;

public record Champion(
        String id,
        String key,
        String name,
        String title,
        ChampionImage image,
        List<ChampionSkin> skins,
        String lore,
        String blurb,
        List<String> allytips,
        List<String> enemytips,
        List<String> tags,
        String partype,
        ChampionInfo info,
        ChampionStats stats,
        List<ChampionSpell> spells,
        ChampionPassive passive,
        List<Object> recommended
) {
}
