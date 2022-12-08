package hangul.jaso.filters;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import hangul.jaso.util.JasoUtil;

public class HanToEngFilter extends TokenFilter {

	private final CharTermAttribute charAttr;
	private final JasoUtil jasoUtil;

	public HanToEngFilter(TokenStream input) {
		super(input);
		jasoUtil = new JasoUtil();
		charAttr = addAttribute(CharTermAttribute.class);
	}

	@Override
	public final boolean incrementToken() throws IOException {
		if (input.incrementToken()) {
			String hanToEng = jasoUtil.hanToJamoEng(charAttr.toString());
			charAttr.setEmpty().append(hanToEng);
			return true;
		}

		return false;
	}
}
