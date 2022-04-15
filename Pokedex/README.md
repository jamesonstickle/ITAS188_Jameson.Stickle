# Jameson's Pokedex App
## _ITAS188 - Mobile Development I_
This project is a Pokedex application using a tutorial from [EDMT Dev](https://www.youtube.com/watch?v=r2ALBYx1JuY) on YouTube.
View my project on [GitHub](https://github.com/jamesonstickle/ITAS188_Jameson.Stickle/tree/master/Pokedex)
The app requires a device running at least Android 9.0 with an internet connection.

I think I bit off a bit more than I could chew with this project, but I'm happy with the resulting product. The majority of my time spent on this felt like time wasted in dependency hell, trying to get the right version of the right implementation. Most of the code for my project is from the tutorial, but I added in the text-to-speech service from lines 95-101 and lines 154-165 on PokemonDetail.java. The original tutorial was using a Pokedex.json file from [Biuni](https://github.com/Biuni/PokemonGO-Pokedex/blob/master/pokedex.json) on GitHub to populate the list of Pokemon, so I swapped that file out for [my own pokedex.json](https://github.com/jamesonstickle/ITAS188_Jameson.Stickle/blob/master/Pokedex/pokedex.json) which I can edit manually to add more pokemon, create new pokemon, etc. 

If given more time, I would have liked to have perfected the UI, added some more assets that would make the app more closely resemble the pokedex from the Pokemon show. I also would have liked to add a feature that used the camera and created an augmented reality version of the Pokemon, another feature that would use the camera combined with some sort of AI to recognize a pokemon that the camera can see, similar to how apps like PlantSnap work with flowers. If I had quite a bit more extra time on my hands I'd also add a description for each pokemon that could be spoken by the text-to-speech engine as well as adding more pokemon, since there are around 1000 total.

## Bugs
- Pokemon types and weaknesses do not display inline, the user needs to scroll sideways to see additional types/weaknesses
- When the user clicks next or previous evolution the name of the pokemon changes in the toolbar, but there is something wrong with the intent that is supposed to bring up the new fragment.
- CardView did not want to work with RecyclerView on my PokemonDetail fragment, but I managed to make it look fairly nice without the CardView. If I had more time I would have designed the PokemonDetail fragment to look more like the Pokedex from the Pokemon anime, which is something I may do over the summer for fun

