package hangul.jaso;

import org.junit.jupiter.api.Test;

import hangul.jaso.util.JasoUtil;

import static org.junit.jupiter.api.Assertions.*;

class JasoUtilTest {
    private JasoUtil jasoUtil = new JasoUtil();

    @Test
    void hanToJamoTest() {
        assertEquals("ㄱㅐㄹㄹㅓㄱㅅㅣ", jasoUtil.hanToJamo("갤럭시"));
        assertEquals("ㄱㅐㄹㄹㅓㄳㅅㅣ", jasoUtil.hanToJamo("갤럯시"));
        assertEquals("ㄱㅐㄹㄹㅓㄳㅅㅣ", jasoUtil.hanToJamo("갤럯시", false));
        assertEquals("ㄱㅐㄹㄹㅓㄱㅅㅅㅣ", jasoUtil.hanToJamo("갤럯시", true));
        assertEquals("ㄲㅐㄹㄹㅓㄱㅅㅣ", jasoUtil.hanToJamo("깰럭시"));
    }

    @Test
    void hanToEngTest() {
        assertEquals("roffjrtl", jasoUtil.hanToJamoEng("갤럭시"));
        assertEquals("roffjrttl", jasoUtil.hanToJamoEng("갤럯시"));
        assertEquals("Roffjrtl", jasoUtil.hanToJamoEng("깰럭시"));
    }

    @Test
    void engToHanTest() {
        assertEquals("ㄱㅐㄹㄹㅓㄱㅅㅣ", jasoUtil.engToHan("roffjrtl"));
        assertEquals("ㄱㅐㄹㄹㅓㄱㅅㅅㅣ", jasoUtil.engToHan("roffjrttl"));
        assertEquals("ㄲㅐㄹㄹㅓㄱㅅㅣ", jasoUtil.engToHan("Roffjrtl"));
    }

    @Test
    void hanToChosungTest() {
        assertEquals("ㄱㄹㅅ", jasoUtil.hanToChosung("갤럭시"));
    }
}
