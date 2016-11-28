package edu.siu.bargame;

public class Story extends Inventory{
	protected int storyCounter = 1;
	
	protected static String forestConversations[] = {"You strike up a conversation with the old man.  \"And a hearty hello"
			+ " to you as well, stranger!  Many a year I have walked this land, yet the death of Xaltis the exalted has "
			+ "been the worst event I've seen, or catalyst to an event if you prefer.  I lost my son, I did, in that terrible war that followed.  Not just my son, but my village"
			+ " as well.  This peace cannot last with such a weak ceasefire agreement.  Only a matter o' time, I reckon, with people like that fellow with the axe looking for revenge...\n\n"
			+ "Anyhow, young'un, in a past life I was an authority on deciphering old texts.  Always remember, and it is"
			+ " especially true for your generation, \'If the wind will not serve, take to the oars.\'  Hoho!  To be young again...\"", "OLD MAN WITH BOOK",
			 "A young boy and girl turn away from a picture they were drawing in the mud and turn.  \"Hello mister!\" they say in unison."
			 + "  \n\n\"Have you heard about the monster in the BIIIIIGGEST tree?\" the boy asks."
			 + "\n\n\"My mommy says that it was left over from the Great War and no one has been able to beat it.  It guards a treasure too, my uncle told me!\" continues the girl.  \n\n"
			 + "\"Do you think that we could become strong enough to beat it?\" asks the boy.\n\n\"Don't be stupid, it's left over from the royal army!", "\"You should just leave me be, stranger.  I'm not the"
			 		+ " friendly type and I have business here.  I'm going to avenge everyone that died from the Feropian militia, but I need that treasure this creature has to enter Ferop.\""};
	
	protected static String townConversations[] = {/*woman, man, professor*/"\"Hey, how can I help you?  Why, this town here was spared in the war thanks to the ceasefire, but it sure was close.  Lotsa people hate us though, shame.  "
			+ "They blame us Ferop for a lot in the war, despite us not participating.  Our neighborin' city, or I ought say former neighborin' city, Icclea, God rest their souls, had the same militia uniforms as us, so people have been mistaking us for them.  They were all wiped"
			+ "out in that awful war.  I wish peace could return again for good...I'm scared that someone may get the idea of revenge and start things up again, which would be bad for everybody, involved or not.\"", "\"Good day to you!  "
					+ "We're situated out here with a mountain behind us, a swamp north of us, and a winding maze of a forest to the east.  Thanks to that, we were spared the ravages of war.  The Icclea, though...best not to dwell on it.  "
					+ "I heard that a merchant in town is selling a machete.  Something like that could help someone travel through the swamp!\"", "Hello, chap.  I have a proposition for you.  I'm a professor of biology.  I have here a book "
					+ "of great value.  But, er, I can't exactly read it.  It's in an old language and I can't identify it, nor can my colleagues, it's that old.  You can have it if you bring me five Undead Bones.  Who knows, you may find more use for it than I.  Come back when you have the bones!"};
	
	
	protected static String castleConversations[] = {"\"Fie!  The castle can't be retaken!  A dragon roosts upon this fortress!  I entered with a band of fellow countrymen to slay the beast, but only I survived, and by the luck of the Gods!  Friend, turn back now.  This place"
			+ "is no longer for us, we have reaped what we have sown!  Do not proceed if you value your life!\"  The soldier stumbles away in hysterics."};
	
	protected static String forestExaminations[] = {"This forest is ancient, judging by the size of the trees.  A brook babbles nearby.  "
			+ "The horrors of the last fifteen years spared this beautiful and peaceful land.", 
			"Small crowds of people move along a dirt path.  There are several rope ladders leading up to treehouses with signs for confections, "
			+ "a meatery, and an assortment of other businesses."
			+ "Carved into the base of a tree, " + player.getName() + " sees a merchant peddling wares.",
			player.getName() + " enters a less crowded area of Silanger.  The inhabitants of the forest are sitting atop"
			+ " treehouses, observing the sky.  Only a few remain on the dirt road.  This could be a good chance to learn something from the inhabitants."};
	
	protected static String townExaminations[] = {};
	
	protected static String castleExaminations[] = {};//the book unlocks a special shop item to increase your defense greatly
	
	protected static String story[] = {"The world is amidst an era of great chaos.  Following the death of the great King Xaltis, a long-lasting "
			+ "era of peace was broken.\n\nIn the aftermath of a Great War, much of the population has been destroyed."
			+ " the world is unsteady.  Anarchy is the law of the land.  "
			+ "One individual, " + player.getName() + ", hopes to find an answer.  Good luck, hero!", "The tree stretches for miles upward.  Its trunk is thicker than "
			+ "one could imagine.  You hear a trumpeting sound and feel the tree shake slightly.  Tapping the tree, you realize that it has been hollowed out somewhat.  You spot an entrance on the side, guarded.  A quick conversation "
			+ "with the guards leads you inside to attempt the challenge.  As you enter, you spot an enormous beast, flesh rotting off and decorated with the colors of the nation's former military.  It charges you.  Prepare for combat!",
			player.getName() + " cuts their way through the thick foliage of the swamp while fighting the muddy floor.  Eventually, the destination is in sight, the castle of the previous king!  Smoke pours out from it.  Charging forward, forgetting the plight endured, "+ player.getName() + " narrowly "
			+ "avoids a strike from a monster.  A large, two-headed snake blocks the way!  Fight through!", "Resolute will pushes the hero forward.  This is what " + player.getName() + " has traveled so far for.  Up a winding staircase, past dozens of rooms, through a throne room, and onto the roof, bridges leading to the stone "
			+ "parapets.  A large shadow descends upon " + player.getName() + ".  Golden red scales, sharp claws, razor teeth.  The surrounding temperature increases.  The dragon appears.  It spits a blast of fire at " + player.getName() + ", who narrowly avoids it.  The ground that was hit remains hot.  It flies at you.  The final challenge begins NOW!", "The castle has been retaken.  Your strength "
			+ "has been proven to all in the land.  " + player.getName() + " seizes the throne to rule the kingdom.  Only time will tell if true peace will return...\n\n\n                                               THANKS FOR PLAYING!\n\n\n                                       ~Lucas, Jackson, David"};//boss 1--Undead War Mammoth, boss 2--Two-headed snake
	
	protected static String levelBarrier[] = {"You must be at least level 5 to enter this location.", "You must be at least level 10 to enter this location.", "You must be at least level 15 to enter this location."};
	
	public String[] getForestConversations() {
		return forestConversations;
	}
	public void setForestConversations(String[] forestConversations) {
		this.forestConversations = forestConversations;
	}
	public String[] getStory() {
		return story;
	}
	public void setStory(String[] story) {
		this.story = story;
	}

}