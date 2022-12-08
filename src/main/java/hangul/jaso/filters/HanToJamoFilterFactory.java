package hangul.jaso.filters;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

public class HanToJamoFilterFactory extends AbstractTokenFilterFactory {

	private final boolean decomposeDoubleChar;

	@Inject
	public HanToJamoFilterFactory(IndexSettings indexSettings, Environment env, String name,
			Settings settings) {
		super(name, settings);
		this.decomposeDoubleChar = settings.getAsBoolean("doublechar", false);
	}

	@Override
	public TokenStream create(TokenStream tokenStream) {
		return new HanToJamoFilter(tokenStream, this.decomposeDoubleChar);
	}
}
