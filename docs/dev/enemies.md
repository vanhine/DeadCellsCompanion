# Adding Enemies

## Overview

The Dead Cells Companion app currently (Jan 2022) only supports gear/weapons. There have been many reviews left on the app that request additional features. This document will outline the work required to add Enemies feature.

## Requirements

* Scrape wiki daily for changes
* Populate Firestore with Enemies information
* Enemies page added to Dead Cells Companion

## Background

I chose to implement the Enemies feature first due to it being so similar to the existing Gear feature. The wiki page for [Gear](https://web.archive.org/web/20211027200207/https://deadcells.fandom.com/wiki/Gear) and [Enemies](https://web.archive.org/web/20211105174154/https://deadcells.fandom.com/wiki/Enemies) both use tables to display the information about the subjects.

Since both are so similar, the same approach will be used for both and code deduplication will be important to keep in mind.

## Implementation

### Scraping the wiki
The Dead Cells Scraper is used to scrape the wiki and populate a Firestore database. The scraper will use BeautifulSoup to extract the data from the table. This will then be stored as an `Enemy` object.

```python
@dataclass(eq=True, frozen=True)
class Enemy:
    name: str
    image_url: str
    zones: str
    offensive_abilities: str
    defensive_abilities: str
    elite: str
    blueprint_drops: str
```

`parsing_util.py` provides helper methods for converting html to our custom objects. A new function `tr_to_enemy` will need to be added. This will need to parse out each value from the row and create an enemy object using these values.

Finally a method will be added to the `DeadCellsWikiProvider` called `get_enemies()` which will return a list of `Enemy` objects.

### Adding Firestore collection

A new `enemies` collection will be created in the Firestore. In `FirestoreManager.get_firestore_data()` we will include a list of `enemies` in the returned dictionary.

After this, the Firestore will contain a new `enemies` collection with all the information about each enemy in the game. This can now be used to display this information in the app.