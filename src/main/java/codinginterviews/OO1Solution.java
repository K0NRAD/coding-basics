package codinginterviews;

/*
StrintToInteger
    Implementiere die myAtoi(string s) Funktion, die eine Zeichenfolge in
    eine 32-Bit-Ganzzahl mit Vorzeichen konvertiert (ähnlich der atoi von C/C++).

    Der Algorithmus für atoi(string s) lautet wie folgt:

        Lese den String ein, und ignoriere alle führenden Leerzeichen.
        Überprüfe ob das nächste Zeichen (falls nicht bereits am Ende der Zeichenfolge)
        '-' oder '+' ist. Lese dieses Zeichen ein, wenn es eines von beiden ist.
        Dies bestimmt, ob das Endergebnis negativ bzw. positiv ist, das Ergebnis ist auch
        positiv, wenn keines von beiden vorhanden ist.
        Lese die nächsten Zeichen ein, bis das nächste Zeichen keine Zahl oder das Ende
        des Textes erreicht ist.
        Der Rest der Zeichenfolge wird ignoriert.
        Konvertiere diese Ziffern in eine ganze Zahl (z. B. "123" -> 123, "0032" -> 32).
        Wenn keine Ziffern gelesen wurden, ist die ganze Zahl 0.
        Wenn die Ganzzahl außerhalb des 32-Bit-Ganzzahlbereichs mit Vorzeichen liegt [-2^31, 2^31 - 1],
        dann gebe den minimal oder maximal Wert eines 32 Bit Integer-Wertes aus, ist die Zahl
        kleiner als -2^31 gebe den minimal Wert eines 32 Bit Integer-Datentyps zurück,
        ist die Zahl größer 2^31 - 1 geben den maximal Wert eines 32 Bit Integer-Datentyps zurück.

        Gebe die ganze Zahl als Endergebnis zurück.

Anmerkung:

    Nur das Leerzeichen ' ' ' als Leerzeichen betrachtet.
    Ignoriere keine anderen Zeichen als das führende Leerzeichen oder den Rest der Zeichenfolge nach den Ziffern.

Beispiel 1:

    Input:  txt = "42"
    Output: 42

    Erläuterung: Die unterstrichenen Zeichen sind das, was eingelesen wird, das Caret-Zeichen
                 ist die aktuelle Leseposition.

    Step 1: "42" (es werden keine Zeichen gelesen, da kein führendes Leerzeichen vorhanden ist)
             ^
    Step 2: "42" (keine Zeichen gelesen, da weder '-' noch ' ')
             ^
    Step 3: "42" („42“ wird eingelesen)
             ^
    Die geparste Ganzzahl ist 42.

    Da 42 im Bereich [-2^31, 2^31 - 1] liegt, ist das Endergebnis 42.

Beispiel 2:

    Input:  txt = "   -42"
    Output: -42

    Explanation:

    Step 1: "   -42" (Führende Leerzeichen werden gelesen und ignoriert)
                ^
    Step 2: "   -42" ('-' wird gelesen, also sollte das Ergebnis negativ sein)
                 ^
    Step 3: "   -42" ("42" wird eingelesen)
                   ^
    Die geparste Ganzzahl ist -42.
    Da -42 im Bereich [-2^31, 2^31 - 1] liegt, ist das Endergebnis -42.

Beispiel 3:

    Input: txt = "4193 with words"
    Output: 4193

    Erläuterung:

    Step 1: "4193 with words" (es werden keine Zeichen gelesen, da kein führendes Leerzeichen vorhanden ist)
             ^
    Step 2: "4193 with words" (es werden keine Zeichen gelesen, da weder '-' noch ' ' vorhanden ist)
             ^
    Step 3: "4193 with words" ("4193" wird eingelesen; das Lesen stoppt, weil das nächste Zeichen keine Ziffer ist)

    Die geparste Ganzzahl ist 4193.

    Da 4193 im Bereich [-2^31, 2^31 - 1] liegt, ist das Endergebnis 4193.
 */
public class OO1Solution {
    long ergebnis = 0;
    boolean alreadyReadNumber = false;
    boolean isAlreadyReadSign = false;
    boolean isErgebnisNegativ = false;



    public int atoi(String txt) {

        for (int i = 0; i < txt.length(); i++) {
            char chr = txt.substring(i, i + 1).charAt(0);
            if (chr == ' ' && (alreadyReadNumber || isAlreadyReadSign)) {
                break;
            } else if (chr == '+' || chr == '-') {
                if (isAlreadyReadSign) {
                    break;
                } else if (chr == '-' && !alreadyReadNumber) {
                    isErgebnisNegativ = true;
                    isAlreadyReadSign = true;
                } else if (chr == '+' && !alreadyReadNumber) {
                    isAlreadyReadSign = true;
                } else {
                    break;
                }
            } else if ((chr > '9' || chr < '0') && chr != ' ') {
                break;
            } else{
                ergebnis = ergebnis * 10 + chr - '0';
                alreadyReadNumber = true;
            }
        }

        if(isErgebnisNegativ) {
            ergebnis = -ergebnis;
        }
        if (ergebnis > Integer.MAX_VALUE) {
            ergebnis = Integer.MAX_VALUE;
        } else if (ergebnis < Integer.MIN_VALUE) {
            ergebnis = Integer.MIN_VALUE;
        }

        return (int) this.ergebnis;

}

    public static void main(String[] args) {
        OO1Solution solution = new OO1Solution();
        System.out.println(solution.atoi("  -799"));


    }
}





