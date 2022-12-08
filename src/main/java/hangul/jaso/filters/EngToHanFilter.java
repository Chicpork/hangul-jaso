package hangul.jaso.filters;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import hangul.jaso.util.JasoUtil;

public class EngToHanFilter extends TokenFilter {

	private final CharTermAttribute charAttr;
	private final JasoUtil jasoUtil;

	public EngToHanFilter(TokenStream input) {
		super(input);
		jasoUtil = new JasoUtil();
		charAttr = addAttribute(CharTermAttribute.class);
	}

	@Override
	public final boolean incrementToken() throws IOException {
		if (input.incrementToken()) {
			String engToHan = jasoUtil.engToHan(charAttr.toString());
			charAttr.setEmpty().append(engToHan);
			return true;
		}

		return false;
	}
}
