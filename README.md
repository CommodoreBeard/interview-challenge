# interview-challenge

## Description
In the Seven Wonders board game there are:

Four basic resources, **Wood**, **Brick**, **Stone** and **Ore**
Resource cards that can produce one resource out of a range of resource options offered by the card. (e.g.: a card denoted with W/B can produce 1 wood or 1 brick but not both)
Wonders that are denoted by the sequence of resources required to build them (e.g.: `WWSS` is a wonder that requires 2 wood and 2 stone)
Given the wonder `WWSS` and resource cards `W/B/S/O, W, S/B, and S`, it is possible to produce 2 wood and 2 stone: use the first two cards to get wood, and the last two to get stone.

## Goal
Write software to determine if a list of available cards can be used to build a wonder.

## Input
A comma-separated sequence of cards surrounded by square brackets, with the options separated by a slash.

> A question phrased "Can you build \<Wonder\>?".

## Output
> **Yes** \<a sequence of options chosen for each card, _ if a card is not used\>

> **No** if the wonder cannot be built with the provided cards

## Example Inputs and Outputs
```bash
Cards [W/B/S/O, W, S/B, S] Can you build WWSS?
Yes WWSS
```

```bash
Cards [S, W/B/S/O, W, S/B] Can you build BSWW?
Yes SWWB
```

```bash
Cards [B, S, W/B/O] Can you build OS?
Yes _SO
```

```bash
Cards [W/B/S/O, W/B/S/O] Can you build WWW?
No
```

```bash
Cards [W/B/S/O, S/O, W/S, W/B, W/B, W, B] Can you build WWBSSOO?
No
```

## Hints
- write well modelled, production quality code accompanied by unit tests
- input and output handling is nice to have:
    - inputs can be provided as constants
- correct operation can be demonstrated with unit tests
- be agile a partial solution is more desirable than a non working solution