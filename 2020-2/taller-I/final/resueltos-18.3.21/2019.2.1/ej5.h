#include <stdio.h>

/*
 * @brief Get the length of a determined char array.
 *
 * @param str a pointer to char array.
 *
 * @return the length of the char array.
 */
size_t getStringLength(const char* str);

/*
 * @brief Replaces every occurrence of value in str with newValue and saves the
 * result in buf.
 *
 * @param str a pointer to a char array.
 * @param buf a pointer to an empty char array.
 * @param value the character to be replaced.
 * @param newValue the character which will replace value.
 *
 * @return The number of appearences of value that were replaced with newValue.
 */
int strReplace(const char* str, char* buf, const char value,
               const char newValue);

/*
 * @brief Get a array of char arrays that consists of str splitted were delim
 * appears.
 *
 * @param str a pointer to a char array.
 * @param delim a character that works as delimiter.
 *
 * @return A pointer to the first element of an array of char arrays.
 */
char** split(const char* str, char delim);

/*
 *
 * @param str a pointer to a char array.
 * @param value a character to be found in the char array.
 *
 * @return the position of the first appearance of value in str, or -1 if not
 * found.
 */
int findChar(const char* str, char value);