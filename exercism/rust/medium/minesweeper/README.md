# Minesweeper

Welcome to Minesweeper on Exercism's Rust Track.
If you need help running the tests or submitting your code, check out `HELP.md`.

## Introduction

[Minesweeper][wikipedia] is a popular game where the user has to find the mines using numeric hints that indicate how many mines are directly adjacent (horizontally, vertically, diagonally) to a square.

[wikipedia]: https://en.wikipedia.org/wiki/Minesweeper_(video_game)

## Instructions

Your task is to add the mine counts to empty squares in a completed Minesweeper board.
The board itself is a rectangle composed of squares that are either empty (`' '`) or a mine (`'*'`).

For each empty square, count the number of mines adjacent to it (horizontally, vertically, diagonally).
If the empty square has no adjacent mines, leave it empty.
Otherwise replace it with the adjacent mines count.

For example, you may receive a 5 x 4 board like this (empty spaces are represented here with the '·' character for display on screen):

```text
·*·*·
··*··
··*··
·····
```

Which your code should transform into this:

```text
1*3*1
13*31
·2*2·
·111·
```

## Performance Hint

All the inputs and outputs are in ASCII.
Rust `String`s and `&str` are utf8, so while one might expect `"Hello".chars()` to be simple, it actually has to check each char to see if it's 1, 2, 3 or 4 `u8`s long.
If we know a `&str` is ASCII then we can call `.as_bytes()` and refer to the underlying data as a `&[u8]` (byte slice).
Iterating over a slice of ASCII bytes is much quicker as there are no codepoints involved - every ASCII byte is one `u8` long.

Can you complete the challenge without cloning the input?

## Source

### Created by

- @EduardoBautista

### Contributed to by

- @ashleygwilliams
- @coriolinus
- @cwhakes
- @EduardoBautista
- @efx
- @ErikSchierboom
- @ffflorian
- @IanWhitney
- @kytrinyx
- @lutostag
- @mkantor
- @nfiles
- @petertseng
- @rofrol
- @stringparser
- @workingjubilee
- @xakon
- @ZapAnton