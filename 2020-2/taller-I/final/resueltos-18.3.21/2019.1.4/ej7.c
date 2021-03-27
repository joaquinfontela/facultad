#include <math.h>
#include <stdbool.h>
#include <stdio.h>

typedef struct complex_t {
  float re;
  float im;
} complex;

/*
 * @param cmp a complex number.
 *
 * @return The module of cmp.
 */
float module(complex* cmp);

/*
 * @param cmp a complex number.
 *
 * @return The real part of cmp.
 */
float get_re(complex* cmp);

/*
 * @param cmp a complex number.
 *
 * @return The imaginary part of cmp.
 */
float get_im(complex* cmp);

/*
 * @param cmp a complex number.
 *
 * @return true if imaginary part equals zero.
 */
bool is_re(complex* cmp);

/*
 * @param cmp a complex number.
 *
 * @return shows through stdout the complex number.
 */
void print_cmp(complex* cmp);

/*
 * @param cmp1 a complex number.
 * @param cmp2 a complex number.
 *
 * @return The sum of cmp1 and cmp2.
 */
complex* sum(complex* cmp1, complex* cmp2);

int main() { return 0; }