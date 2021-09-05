# Dead Cells Companion

Dead Cells Companion provides information about the items found in the Dead Cells video game. This
includes where to find the items and their stats.

![Gear Page](http://github.com/vanhine/DeadCellsCompanion/blob/master/docs/gear_page.png?raw=true)
![Info Page](http://github.com/vanhine/DeadCellsCompanion/blob/master/docs/info_page.png?raw=true)

[![Get it on Google Play](http://github.com/vanhine/DeadCellsCompanion/blob/master/docs/play_badge.png?raw=true)](https://play.google.com/store/apps/details?id=com.mrwinston.deadcellscompanion&hl=en_US&gl=US)

## Backend Info

The data about the items and their stats are sourced from the
[Dead Cells Wiki Gear Page](https://deadcells.fandom.com/wiki/Gear). A web scraper scrapes the
information from the page and updates a Firestore.

The Wiki is created by the community, so I have the diffs emailed to me to approve/deny the changes.

The scraper checks for updates each morning at 11am PST.

The app talks to a Firestore database containing the item data.
