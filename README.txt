The room file is followed by the following format:
Room number
Room description
Visited rooms
room has item
room has puzzle
room in the north direction
room in the east direction
room in the south direction
 room in the west direction

The item file is followed by the following format:
Item name
Item description
Item location

The puzzle file is followed by the following format:
Puzzle location
Puzzle question
Puzzle answer
Number of attempts

The help file is the Commands Menu

The Navigation file is structured in the following format:
Room number
Beginning dividing line
Navigation title
Middle dividing line
Directions header
North direction
East direction
South direction
West direction
Ending dividing line

The map & compass look like this:
-------------
| 1 I ¦  2  |         N
--   ---   --         ^
| 3 I ¦ 4 P |     W <-|-> E
--   ---   --         v
| 5 I ¦  6  |         S
-------------
If you're in room 1, you can only go east into room 2 & south into room 3. There is an item in this room.
If you're in room 2, you can only go south into room 4 & west into room 1.
If you're in room 3, you can only go north into room 1, east into room 4, & south into room 5. There is an item in this room.
If you're in room 4, you can only go north into room 2, south into room 6, & west into room 3. There is a puzzle in this room.
If you're in room 5, you can only go north into room 3 & east into room 6. There is an item in this room.
If you're in room 6, you can only go north into room 4 & west into room 5.