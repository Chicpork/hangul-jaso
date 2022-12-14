package hangul.jaso.util;

import java.util.HashMap;
import java.util.Map;

public class JasoUtil {
    // {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ',
    // 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'}
    private static final char[] CHOSUNG = { 0x3131, 0x3132, 0x3134, 0x3137, 0x3138, 0x3139, 0x3141, 0x3142, 0x3143,
            0x3145, 0x3146,
            0x3147, 0x3148, 0x3149, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
    // {'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ',
    // 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'}
    private static final char[] JUNGSUNG = { 0x314f, 0x3150, 0x3151, 0x3152, 0x3153, 0x3154, 0x3155, 0x3156, 0x3157,
            0x3158, 0x3159,
            0x315a, 0x315b, 0x315c, 0x315d, 0x315e, 0x315f, 0x3160, 0x3161, 0x3162, 0x3163 };
    // {' ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ', 'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ', 'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ',
    // 'ㅀ', 'ㅁ', 'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'}
    private static final char[] JONGSUNG = { 0x0000, 0x3131, 0x3132, 0x3133, 0x3134, 0x3135, 0x3136, 0x3137, 0x3139,
            0x313a, 0x313b,
            0x313c, 0x313d, 0x313e, 0x313f, 0x3140, 0x3141, 0x3142, 0x3144, 0x3145, 0x3146, 0x3147,
            0x3148, 0x314a, 0x314b, 0x314c, 0x314d, 0x314e };
    private static final String[] CHOSUNG_EN = { "r", "R", "s", "e", "E", "f", "a", "q", "Q", "t", "T",
            "d", "w", "W", "c", "z", "x", "v", "g" };
    private static final String[] JUNGSUNG_EN = { "k", "o", "i", "O", "j", "p", "u", "P", "h", "hk",
            "ho", "hl", "y", "n", "nj", "np", "nl", "b", "m", "ml", "l" };
    private static final String[] JONGSUNG_EN = { "", "r", "R", "rt", "s", "sw", "sg", "e", "f", "fr", "fa",
            "fq", "ft", "fx", "fv", "fg", "a", "q", "qt", "t", "T", "d", "w", "c", "z", "x", "v", "g" };
    private static final String[] ENGLISH_KO = { "ㅁ", "ㅠ", "ㅊ", "ㅇ", "ㄷ", "ㄹ", "ㅎ", "ㅗ", "ㅑ", "ㅓ", "ㅏ", "ㅣ", "ㅡ", "ㅜ",
            "ㅐ", "ㅔ", "ㅂ", "ㄱ", "ㄴ", "ㅅ", "ㅕ", "ㅍ", "ㅈ", "ㅌ", "ㅛ", "ㅋ" };
    private static final char CHOSUNG_BEGIN_UNICODE = 12593;
    private static final char CHOSUNG_END_UNICODE = 12622;
    private static final char HANGUEL_BEGIN_UNICODE = 44032;
    private static final char HANGUEL_END_UNICODE = 55203;
    private static final char NUMBER_BEGIN_UNICODE = 48;
    private static final char NUMBER_END_UNICODE = 57;
    private static final char ENGLISH_UPPER_BEGIN_UNICODE = 65;
    private static final char ENGLISH_UPPER_END_UNICODE = 90;
    private static final char ENGLISH_LOWER_BEGIN_UNICODE = 97;
    private static final char ENGLISH_LOWER_END_UNICODE = 122;
    // 쉬프트 없이 입력해야 하는 쌍자음,쌍모음들
    private static final Map<Character, String> DOUBLE_CHARACTER_KOR_MAP = new HashMap<>(16);
    private static final Map<Character, String> DOUBLE_CHARACTER_ENG_MAP = new HashMap<>(7);

    static {
        DOUBLE_CHARACTER_KOR_MAP.put('ㄳ', "ㄱㅅ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㄵ', "ㄴㅈ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㄶ', "ㄴㅎ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㄺ', "ㄹㄱ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㄻ', "ㄹㅁ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㄼ', "ㄹㅂ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㄽ', "ㄹㅅ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㄾ', "ㄹㅌ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅀ', "ㄹㅎ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅄ', "ㅂㅅ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅘ', "ㅗㅏ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅙ', "ㅗㅐ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅚ', "ㅗㅣ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅝ', "ㅜㅓ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅞ', "ㅜㅔ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅟ', "ㅜㅣ");
        DOUBLE_CHARACTER_KOR_MAP.put('ㅢ', "ㅡㅣ");

        DOUBLE_CHARACTER_ENG_MAP.put('Q', "ㅃ");
        DOUBLE_CHARACTER_ENG_MAP.put('W', "ㅉ");
        DOUBLE_CHARACTER_ENG_MAP.put('E', "ㄸ");
        DOUBLE_CHARACTER_ENG_MAP.put('R', "ㄲ");
        DOUBLE_CHARACTER_ENG_MAP.put('T', "ㅆ");
        DOUBLE_CHARACTER_ENG_MAP.put('O', "ㅒ");
        DOUBLE_CHARACTER_ENG_MAP.put('P', "ㅖ");
    }

    private static boolean isPossibleCharacter(char c) {
        if (((c >= NUMBER_BEGIN_UNICODE && c <= NUMBER_END_UNICODE)
                || (c >= ENGLISH_UPPER_BEGIN_UNICODE && c <= ENGLISH_UPPER_END_UNICODE)
                || (c >= ENGLISH_LOWER_BEGIN_UNICODE && c <= ENGLISH_LOWER_END_UNICODE)
                || (c >= HANGUEL_BEGIN_UNICODE && c <= HANGUEL_END_UNICODE)
                || (c >= CHOSUNG_BEGIN_UNICODE && c <= CHOSUNG_END_UNICODE))) {
            return true;
        } else {
            return false;
        }
    }

    public String hanToJamo(String source) {
        return hanDecompose(source, false, false);
    }

    public String hanToJamo(String source, boolean decomposeDoubleChar) {
        return hanDecompose(source, false, decomposeDoubleChar);
    }

    public String hanToJamoEng(String source) {
        return hanDecompose(source, true, false);
    }

    public String hanToChosung(String source) {
        StringBuilder chosung = new StringBuilder(source.length());
        int criteria;
        char sourceChar;
        char choIdx;

        for (int i = 0; i < source.length(); i++) {
            sourceChar = source.charAt(i);

            if (sourceChar >= HANGUEL_BEGIN_UNICODE) {
                criteria = (sourceChar - HANGUEL_BEGIN_UNICODE);
                choIdx = (char) (((criteria - (criteria % 28)) / 28) / 21);
                chosung.append(CHOSUNG[choIdx]);
            } else {
                if (isPossibleCharacter(sourceChar)) {
                    chosung.append(sourceChar);
                }
            }
        }

        return chosung.toString();
    }

    public String engToHan(String source) {
        StringBuilder kors = new StringBuilder(source.length());
        char[] sourceChars = source.toCharArray();
        int index;
        for (char ch : sourceChars) {
            if (ch >= ENGLISH_LOWER_BEGIN_UNICODE && ch <= ENGLISH_LOWER_END_UNICODE) {
                // 소문자
                index = ch - ENGLISH_LOWER_BEGIN_UNICODE;
                kors.append(ENGLISH_KO[index]);
            } else if (ch >= ENGLISH_UPPER_BEGIN_UNICODE && ch <= ENGLISH_UPPER_END_UNICODE) {
                // 대문자
                if (DOUBLE_CHARACTER_ENG_MAP.containsKey(ch)) {
                    kors.append(DOUBLE_CHARACTER_ENG_MAP.get(ch));
                } else {
                    index = ch - ENGLISH_UPPER_BEGIN_UNICODE;
                    kors.append(ENGLISH_KO[index]);
                }
            } else {
                kors.append(ch);
            }
        }
        return kors.toString();
    }

    /*
     * [분리 기본 공식]
     * 초성 = ( ( (글자 - HANGUEL_BEGIN_UNICODE) - (글자 - HANGUEL_BEGIN_UNICODE) % 28 ) )
     * / 28 ) / 21
     * 중성 = ( ( (글자 - HANGUEL_BEGIN_UNICODE) - (글자 - HANGUEL_BEGIN_UNICODE) % 28 ) )
     * / 28 ) % 21
     * 종성 = (글자 - HANGUEL_BEGIN_UNICODE) % 28
     * [합치기 기본 공식]
     * 원문 = HANGUEL_BEGIN_UNICODE + 28 * 21 * (초성의 index) + 28 * (중성의 index) + (종성의
     * index)
     * 각 index 정보는 CHOSUNG, JUNGSUNG, JONGSUNG char[]에 정의한 index 입니다.
     * 하지만 아래 코드에서는 원문이 필요 없기 때문에 합치기 위한 로직은 포함 되어 있지 않습니다.
     */
    private String hanDecompose(String source, boolean toEng, boolean decomposeDoubleChar) {
        StringBuilder jamo = new StringBuilder(source.length() * 3);
        int criteria;
        char sourceChar;
        int jamoIdx;

        for (int i = 0; i < source.length(); i++) {
            sourceChar = source.charAt(i);

            if (sourceChar >= HANGUEL_BEGIN_UNICODE &&
                    sourceChar <= HANGUEL_END_UNICODE) {
                criteria = sourceChar - HANGUEL_BEGIN_UNICODE;
                jamoIdx = (((criteria - (criteria % 28)) / 28) / 21);
                if (toEng) {
                    jamo.append(CHOSUNG_EN[jamoIdx]);
                } else {
                    jamo.append(CHOSUNG[jamoIdx]);
                }

                jamoIdx = (((criteria - (criteria % 28)) / 28) % 21);
                if (toEng) {
                    jamo.append(JUNGSUNG_EN[jamoIdx]);
                } else {
                    jamo.append(decomposeDoubleChar ? decomposeDoubleChar(JUNGSUNG[jamoIdx]) : JUNGSUNG[jamoIdx]);
                }

                jamoIdx = (criteria % 28);
                // NUL 문자에 대한 제거
                if ((int) jamoIdx != 0) {
                    if (toEng) {
                        jamo.append(JONGSUNG_EN[jamoIdx]);
                    } else {
                        jamo.append(decomposeDoubleChar ? decomposeDoubleChar(JONGSUNG[jamoIdx]) : JONGSUNG[jamoIdx]);
                    }
                }
            } else {
                if (isPossibleCharacter(sourceChar)) {
                    jamo.append(sourceChar);
                }
            }
        }

        return jamo.toString();
    }

    private String decomposeDoubleChar(char sourceChar) {
        if (DOUBLE_CHARACTER_KOR_MAP.containsKey(sourceChar)) {
            return DOUBLE_CHARACTER_KOR_MAP.get(sourceChar);
        } else {
            return String.valueOf(sourceChar);
        }
    }

}