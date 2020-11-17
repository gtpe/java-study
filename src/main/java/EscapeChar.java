/**
 * -------------------------------------------------------------------------------------------------------
 * |   Escape sequence   |                         Character value                                       |
 * -------------------------------------------------------------------------------------------------------
 * |         \b          |                            Backspace                                          |
 * |         \t          |                         Horizontal tab                                        |
 * |         \n          |                             Newline                                           |
 * |         \f          |                            Form feed                                          |
 * |         \r          |                         Carriage return                                       |
 * |         \"          |                           Double quote                                        |
 * |         \'          |                           Single quote                                        |
 * |         \\          |                             Backslash                                         |
 * |         \xxx        | The Latin-1 character with the encodingxxx,                                   |
 * |                     | wherexxxis an octal (base 8) number between 000 and 377.                      |
 * |                     | The formsxand\xxare also legal, as in\0,                                      |
 * |                     | but are not recommended because they can cause difficulties                   |
 * |                     | in string constants where the escape sequence is followed by a regular digit. |
 * |                     | This form is generally discouraged in favor of the \uXXXX form.               |
 * |         \uxxxx      | The Unicode character with encodingxxxx, wherexxxxis four hexadecimal digits. |
 * |                     | Unicode escapes can appear anywhere in a Java program,                        |
 * |                     | not only in character and string literals.                                    |
 * -------------------------------------------------------------------------------------------------------
 */
public class EscapeChar {
}
