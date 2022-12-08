package hangul.jaso.plugin;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;

import hangul.jaso.filters.ChosungFilterFactory;
import hangul.jaso.filters.EngToHanFilterFactory;
import hangul.jaso.filters.HanToEngFilterFactory;
import hangul.jaso.filters.HanToJamoFilterFactory;

public class HangulJasoPlugin extends Plugin implements AnalysisPlugin {

	@Override
	public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
		Map<String, AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();
		extra.put("kr_chosung", ChosungFilterFactory::new);
		extra.put("kr_jamo", HanToJamoFilterFactory::new);
		extra.put("kr_engtokor", EngToHanFilterFactory::new);
		extra.put("kr_hantoeng", HanToEngFilterFactory::new);
		return extra;
	}
}