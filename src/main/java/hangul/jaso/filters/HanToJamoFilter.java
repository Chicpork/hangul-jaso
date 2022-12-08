package hangul.jaso.filters;

import java.io.IOException;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import hangul.jaso.util.JasoUtil;

public class HanToJamoFilter extends TokenFilter {

	private final CharTermAttribute charAttr;
	private final JasoUtil jasoUtil;
	private final boolean decomposeDoubleChar;

	public HanToJamoFilter(TokenStream input, boolean decomposeDoubleChar) {
		super(input);
		this.jasoUtil = new JasoUtil();
		this.charAttr = addAttribute(CharTermAttribute.class);
		this.decomposeDoubleChar = decomposeDoubleChar;
	}

	@Override
	public final boolean incrementToken() throws IOException {
		if (input.incrementToken()) {
			String hanToJamo = jasoUtil.hanToJamo(charAttr.toString(), decomposeDoubleChar);
			charAttr.setEmpty().append(hanToJamo);
			return true;
		}

		return false;
	}
}
